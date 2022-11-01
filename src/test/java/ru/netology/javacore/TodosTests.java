package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("Тестирование: Todos")
public class TodosTests {

    private Todos todos = new Todos();

    @Test
    @DisplayName("Тестирование метода добавления задачи в список")
    void addTaskTest() {
        todos.addTask("Учеба");
        todos.addTask("Прогулка");
        todos.addTask("Занятие");
        todos.addTask("Попить кофе");
        todos.addTask("Идти на работу");
        todos.addTask("Приготовить еду");
        todos.addTask("Уборка");
        todos.addTask("Помыть посуду");
        List<String> expected = Arrays.asList("Учеба", "Прогулка", "Занятие", "Попить кофе",
                "Идти на работу", "Приготовить еду", "Уборка");
        Assertions.assertEquals(expected.toString().join(" ", expected), todos.toString());
    }

    @Test
    @DisplayName("Тестирование метода удаления задачи из списка")
    void removeTaskTest() {
        todos.addTask("Учеба");
        todos.addTask("Прогулка");
        todos.addTask("Занятие");
        todos.removeTask("Прогулка");
        List<String> expected = Arrays.asList("Учеба", "Занятие");
        Assertions.assertEquals(expected.toString().join(" ", expected), todos.toString());
    }

    @Test
    @DisplayName("Тестирование метода получения всех актуальных задач")
    void getAllTask() {
        todos.addTask("Учеба");
        todos.addTask("Выпечка");
        todos.addTask("Прогулка");
        todos.addTask("Отдых");
        todos.addTask("Чтение");
        todos.removeTask("Выпечка");
        todos.removeTask("Отдых");
        List<String> expected = Arrays.asList("Прогулка", "Учеба", "Чтение");
        Assertions.assertEquals(expected.toString().join(" ", expected), todos.getAllTasks());
    }
}
