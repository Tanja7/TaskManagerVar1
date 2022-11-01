package ru.netology.javacore;

import java.util.*;

public class Todos {
    private final List<String> taskList = new ArrayList<>();
    private final List<Command> commands = new ArrayList<>();

    private int size = 7; // максимальный размер списка

    public Todos() {

    }

    // добавление задачи в список
    public void addTask(String task) {
        if (taskList.size() < size) {
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
        return String.join(" ", taskList);
    }

    @Override
    public String toString() {
        return String.join(" ", taskList);
    }


    public String readMessage(String message) {
        TodoCommand todoCommand = TodoCommand.fromJson(message);
        // извлечение типа операции
        String operation = todoCommand.getType();
        // извлечение задачи
        String task1 = todoCommand.getTask();
        Command c;
        switch (operation) {
            case "ADD": // добавить задачу в список
                c = new AddCommand(this, task1);
                c.execute();
                commands.add(c);
                break;
            case "REMOVE": // удаление задачи из списка
                c = new RemoveCommand(this, task1);
                c.execute();
                commands.add(c);
                break;
            case "RESTORE": // отмена действия последней операции
                if (commands.size() > 0) {
                    c = commands.get(commands.size() - 1);
                    c.unExecute();
                    commands.remove(c);
                }
                break;
            default:
                System.out.println("Введен некорректный ТИП операции!!!");
                break;
        }
        return todoCommand.toString();
    }

}
