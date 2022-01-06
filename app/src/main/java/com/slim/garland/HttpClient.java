package com.slim.garland;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpClient extends Thread {

    int port;
    String s;
    public static String host_address = "192.168.1.138"; // адрес вашего устройства

    public String Greetings_from_S;

    HttpClient(int port) {
        this.port = port;
        start();
    }

    public void run() {
        try (Socket socket = new Socket(host_address, port)) {

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.println("stop data\r");//на всякий случай, вдруг вышли некорректно

            pw.println("data\r");// Greetings with SERVER

            Greetings_from_S = br.readLine();

            if (Greetings_from_S.equals("ready")) {
                new UdpClient();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
