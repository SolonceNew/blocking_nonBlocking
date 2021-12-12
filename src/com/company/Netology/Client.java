package com.company.Netology;

import java.io.*;

import java.net.Socket;
import java.util.Scanner;

public class Client {

    //использовала blocking поскольку нам важен конечный результат на каждое число,
    // а не промежуточные результаты


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 23334);
        try (BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String msg;
            while (true) {
                System.out.println("Введите целое число (число Фибоначчи) " +
                        "или нажмите \"end\" для завершения программы)");
                msg = scanner.nextLine();
                out.println(msg);
                if (msg.equals("end")) break;
                System.out.println("SERVER: " + msg + "-ое число Фибоначчи равно: "+ in.readLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
