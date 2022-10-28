package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class TodoCommand {
    private String type;
    private String task;

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    @Override
    public String toString() {
        return type + ": " + task;
    }

    public String toJson() throws IOException {

        TodoCommand todoCommand = new TodoCommand();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String[] parts = message.split("\t");
        todoCommand.type = parts[0];
        todoCommand.task = parts[1];
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        var str = gson.toJson(todoCommand);
        return str;
    }
    public static TodoCommand fromJson(String json) {
        //   код для преобразования JSON в Java
        ObjectMapper mapper = new ObjectMapper();
        TodoCommand todoCommand;
        try {
            todoCommand = mapper.readValue(json, TodoCommand.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return todoCommand;

    }
}
