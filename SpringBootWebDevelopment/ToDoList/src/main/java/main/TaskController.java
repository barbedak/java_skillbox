package main;

import main.model.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import main.model.Task;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks/")//+
    public List<Task> list(){
        Iterable<Task> taskIterable = taskRepository.findAll();
        List<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @GetMapping("/tasks/{id}") //+
    public ResponseEntity<String> detailsTask(@PathVariable("id") Integer id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task task = optionalTask.get();
        return new ResponseEntity(task.getName() + " - " + task.getContent(), HttpStatus.OK);
    }

    @PostMapping("/tasks/add/{task}")
    public ResponseEntity add(Task task) {
        Integer taskId = taskRepository.save(task).getId();
        if (taskId == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return new ResponseEntity(taskId, HttpStatus.CREATED);
    }

    @PostMapping("/tasks/add/")
    public ResponseEntity addIdNameContent(@RequestParam String name, @RequestParam String content) {
        Task task = new Task();
        task.setName(name);
        task.setContent(content);
        Integer taskId = taskRepository.save(task).getId();
        if (taskId == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return new ResponseEntity(taskId, HttpStatus.CREATED);
    }

    @PutMapping("/tasks/") //+
    public ResponseEntity updateTask(@RequestParam int id, @RequestParam String text) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setContent(text);
            taskRepository.save(task);
            return new ResponseEntity("Task update", HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
    }

    @DeleteMapping("/tasks/delete/{id}") //+
    public ResponseEntity deleteTaskById(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id);
            return new ResponseEntity("Task remove", HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
    }

    @PostMapping("/tasks/clear/")
    public ResponseEntity deleteAllTasks() {
        taskRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
