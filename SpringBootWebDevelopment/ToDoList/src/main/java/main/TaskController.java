package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.Task;

import java.util.List;

@RestController
public class TaskController {

    @GetMapping("/tasks/")
    public ResponseEntity list() {
        List<Task> tasks = Storage.getAllTask();
        if (tasks == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return new ResponseEntity(tasks, HttpStatus.OK);
    }

    @PostMapping("/tasks/add/{task}")
    public ResponseEntity add(Task task) {
        Integer taskId = Storage.add(task);
        if (taskId == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return new ResponseEntity(taskId, HttpStatus.CREATED);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Task task = Storage.getTask(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @PutMapping("/tasks/")
    public ResponseEntity updateTask(@RequestParam int id, @RequestParam String text) {
        boolean isUpdated = Storage.update(id, text);
        if (isUpdated) {
            return new ResponseEntity("Task update", HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable int id) {
        boolean isDeleted = Storage.delete(id);
        if (isDeleted) {
            return new ResponseEntity("Task remove", HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
    }

    @PostMapping("/tasks/clear/")
    public ResponseEntity clear() {
        Storage.clearTaskList();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
