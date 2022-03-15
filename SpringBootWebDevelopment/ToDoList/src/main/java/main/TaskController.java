package main;

import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import main.model.Task;

import java.util.List;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }


    @GetMapping("/")
    public String tasksListPage(Model model) {
        List<Task> taskList = (List<Task>) taskRepository.findAll();
        model.addAttribute("taskList", taskList);
        return "index"; //из templates
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteProductById(@PathVariable("id") int id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addTaskForm(Model model){
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @PostMapping("/add")
    public String taskAddSubmit(@ModelAttribute Task task, Model model) {
        model.addAttribute("task", task);
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Integer id) {
        Task selectedTask = taskRepository.findById(id).get();
        model.addAttribute("task", selectedTask);
        return "details"; //из templates
    }
}
