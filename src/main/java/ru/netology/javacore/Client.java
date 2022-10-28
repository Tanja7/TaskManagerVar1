package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 8989);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.println(in.readLine());
            TodoCommand todoCommand = new TodoCommand();
            out.println(todoCommand.toJson());
            System.out.println(in.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
