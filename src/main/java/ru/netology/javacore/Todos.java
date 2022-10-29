package ru.netology.javacore;

import java.util.*;

public class Todos {
    private final List<String> taskList = new ArrayList<>();
    private final List<Command> commands = new ArrayList<>();

    public Todos() {

    }

    // добавление задачи в список
    public void addTask(String task) {
        if (taskList.size() < 7) {
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
