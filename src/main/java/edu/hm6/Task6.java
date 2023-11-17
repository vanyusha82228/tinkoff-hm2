package edu.hm6;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Task6 {
    public static void scanPorts() {
        for (int port = 0; port <= 49151; port++) {
            checkPort(port);
        }
    }

    private static void checkPort(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.close();
            System.out.println("TCP\t" + port + "\tFree");
        } catch (Exception e) {
            System.out.println("TCP\t" + port + "\tOccupied");
        }

        try {
            DatagramSocket datagramSocket = new DatagramSocket(new InetSocketAddress(port));
            datagramSocket.close();
            System.out.println("UDP\t" + port + "\tFree");
        } catch (Exception e) {
            System.out.println("UDP\t" + port + "\tOccupied");
        }
    }
}
