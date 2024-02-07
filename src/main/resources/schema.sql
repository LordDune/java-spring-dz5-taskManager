create type Status AS ENUM ('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED');
create TABLE task (
                        `id` INT AUTO_INCREMENT PRIMARY KEY,
                        `description` VARCHAR(50),
                        `task_status` Status,
                        `create_date` DATETIME
                        );
