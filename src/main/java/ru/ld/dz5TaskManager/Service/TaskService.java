package ru.ld.dz5TaskManager.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.ld.dz5TaskManager.Model.Task;
import ru.ld.dz5TaskManager.Repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class TaskService {
    private TaskRepository repository;

    public void addTask(Task task) {
        repository.save(task);
        }

    public List<Task> getAllTask() {
        return repository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

    public List<Task> findByStatus(Task.TaskStatus status) {
        return repository.findAll().stream().filter(task -> task.getTaskStatus().equals(status)).collect(Collectors.toList());
    }

    public void updateStatus(Long id, Task.TaskStatus status) {
        Task task = repository.findById(id).get();
        task.setTaskStatus(status);
        repository.save(task);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
