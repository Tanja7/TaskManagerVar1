package ru.netology.javacore;

public class RemoveCommand implements Command {
    private Todos todos;
    private String task;

    public RemoveCommand(Todos todos, String task) {
        this.todos = todos;
        this.task = task;
    }

    @Override
    public void execute() {
        todos.removeTask(task);
    }

    @Override
    public void unExecute() {
        todos.addTask(task);
    }
}
