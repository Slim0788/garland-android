package com.slim.garland;

import com.slim.garland.ui.MainActivity;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient extends Thread {

    int i = 0;
    byte[] data = {0};
    int udp_port = 50000;
    InetAddress addr;
    DatagramSocket ds;

    public UdpClient() {
        try {
            ds = new DatagramSocket();
            addr = InetAddress.getByName(HttpClient.host_address);

        } catch (Exception e) {

        }
        start();
    }

    public void run() {
        while (true) {

            byte temp = MainActivity.Companion.getDirection();

            String s = "" + MainActivity.Companion.getDirection();
            data = s.getBytes();

            if (temp != 100) {
                DatagramPacket pack = new DatagramPacket(data, data.length, addr, udp_port);
                try {
                    ds.send(pack);
                    i = 0;

                    Thread.sleep(200);
                } catch (Exception e) {

                }
            } else {
                if (i == 0) {
                    s = "" + 0;

                    data = s.getBytes();

                    DatagramPacket pack = new DatagramPacket(data, data.length, addr, udp_port);
                    try {
                        ds.send(pack);
                        Thread.sleep(200);
                    } catch (Exception e) {

                    }
                }
                i = 1;// перестаем отправлять нулевые пакеты
            }
        }
    }

}
