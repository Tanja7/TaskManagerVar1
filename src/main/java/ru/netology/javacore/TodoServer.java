package ru.netology.javacore;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TodoServer {
    private static int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {
        TodoServer.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    out.println("Введите информацию о задаче: вид операции и название через tab");
                    String message = in.readLine();
                    System.out.println(message);

                    todos.readMessage(message);
                    out.println(todos.getAllTasks());

                } catch (IOException e) {
                    System.out.println("Не могу стартовать сервер");
                    e.printStackTrace();
                }
            }
        }
    }
}
