package main;

import main.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static HashMap<Integer, Task> tasks = new HashMap<>();
    private static int currentId = 1;

    public static synchronized int add(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static synchronized Task getTask(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }
        return null;
    }

    public static synchronized boolean update(int id, String text) {
        if (tasks.containsKey(id)) {
            Task task = tasks.get(id);
            task.setContent(text);
            tasks.put(id, task);
            return true;
        }
        return false;
    }

    public static synchronized void clearTaskList() {
        tasks.clear();
    }

    public static synchronized boolean delete(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return true;
        }
        return false;
    }

    public static synchronized List<Task> getAllTask() {
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.addAll(tasks.values());
        return taskList;
    }
}
