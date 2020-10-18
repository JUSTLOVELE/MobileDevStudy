package com.java8.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {

        try {
            ServerSocket s = new ServerSocket(8189);
            Socket incoming = s.accept();
            InputStream inputStream = incoming.getInputStream();
            OutputStream outputStream = incoming.getOutputStream();
            Scanner in = new Scanner(inputStream, "UTF-8");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            out.println("Hello! Enter BYE to exit.");
            boolean done = false;
            while(!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo:" + line);
                if(line.trim().equals("BYE")) done = true;
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
