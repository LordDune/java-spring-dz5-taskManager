package ru.ld.dz5TaskManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "task")
public class Task {

    public enum TaskStatus {
        NOT_USED,
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(name = "task_status")
    private TaskStatus taskStatus;
    @Column(name = "create_date")
    private LocalDateTime createDate;
}
