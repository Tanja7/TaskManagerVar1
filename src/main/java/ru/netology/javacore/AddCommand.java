package ru.netology.javacore;

public class AddCommand implements Command {
    private Todos todos;
    private String task;

    public AddCommand(Todos todos, String task) {
        this.todos = todos;
        this.task = task;
    }

    @Override
    public void execute() {
        todos.addTask(task);
    }

    @Override
    public void unExecute() {
        todos.removeTask(task);
    }
}
