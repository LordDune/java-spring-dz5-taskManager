package ru.ld.dz5TaskManager.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import ru.ld.dz5TaskManager.Model.Task;
import ru.ld.dz5TaskManager.Service.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private TaskService service;

    @PostMapping
    public void addTask(@RequestBody Task task) {
        task.setTaskStatus(Task.TaskStatus.NOT_STARTED);
        task.setCreateDate(LocalDateTime.now());
        service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTask() {
        return service.getAllTask();
    }

    @GetMapping("/{id}")
    public Optional<Task> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable Task.TaskStatus status) {
        return service.findByStatus(status);
    }

    @PutMapping("/{id}/{status}")
    public void updateStatus(@PathVariable Long id, @PathVariable Task.TaskStatus status) {
        service.updateStatus(id, status);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
