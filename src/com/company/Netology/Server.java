package com.company.Netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(23334);
        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String msg;
                while ((msg = in.readLine()) != null) {
                    int n = Integer.parseInt(msg);
                    if (n == 0) {
                        out.println(0);
                    } else {
                        long[] array = new long[n + 1];
                        array[0] = 0;
                        array[1] = 1;
                        for (int i = 2; i <= n; i++) {
                            array[i] = array[i - 2] + array[i - 1];
                        }
                        out.println(array[n]);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

