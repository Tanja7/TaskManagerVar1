package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private final List<String> taskList = new ArrayList<>();

    public Todos() {

    }

    // добавление задачи в список
    public void addTask(String task) {
        if (taskList.size() < 7){
        taskList.add(task);
        }
                       }

    // удаление задачи из списка
    public void removeTask(String task) {
        taskList.remove(task);
    }

    // получение всех актуальных задач
    public String getAllTasks() {
        Collections.sort(taskList);
        for (String task : taskList) {
            System.out.print(task + " ");
        }
        System.out.println("");
        return taskList.toString();
    }
    @Override
    public String toString() {
        return taskList.toString();
    }


    public String readMessage(String message) {
        TodoCommand todoCommand = TodoCommand.fromJson(message);
        // извлечение типа операции
        String operation = todoCommand.getType();
        // извлечение задачи
        String task1 = todoCommand.getTask();
        switch (operation) {
            case "ADD": // добавить задачу в список
                addTask(task1);
                break;
            case "REMOVE": // удаление задачи из списка
                removeTask(task1);
                break;
            default:
                System.out.println("Введен некорректный ТИП операции!!!");
                break;
        }
        return todoCommand.toString();
    }
}
