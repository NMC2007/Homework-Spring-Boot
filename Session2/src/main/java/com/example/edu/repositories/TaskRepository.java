package com.example.edu.repositories;

import com.example.edu.enums.PriorityTask;
import com.example.edu.models.Task;
import com.example.edu.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository implements IBaseRepository<Task> {
    private final List<Task> tasksList = new ArrayList<>();

    public TaskRepository() {
        tasksList.add(new Task(1, 1, "Fix bug login", "Fix lỗi không đăng nhập được", PriorityTask.HIGH));
        tasksList.add(new Task(2, 2, "Update UI", "Cập nhật giao diện trang chủ", PriorityTask.MEDIUM));
        tasksList.add(new Task(3, 3, "Write API", "Viết API cho module user", PriorityTask.HIGH));
        tasksList.add(new Task(4, 4, "Test system", "Kiểm thử hệ thống", PriorityTask.LOW));
        tasksList.add(new Task(5, 5, "Optimize DB", "Tối ưu truy vấn database", PriorityTask.HIGH));

        tasksList.add(new Task(6, 1, "Add feature", "Thêm chức năng thanh toán", PriorityTask.MEDIUM));
        tasksList.add(new Task(7, 2, "Fix CSS", "Sửa lỗi CSS mobile", PriorityTask.LOW));
        tasksList.add(new Task(8, 3, "Deploy app", "Deploy lên server", PriorityTask.HIGH));
        tasksList.add(new Task(9, 4, "Write docs", "Viết tài liệu API", PriorityTask.MEDIUM));
        tasksList.add(new Task(10, 5, "Refactor code", "Tối ưu lại code", PriorityTask.LOW));
    }

    @Override
    public List<Task> findAll() {
        return tasksList;
    }

    @Override
    public Task findById(int id) {
        return null;
    }

    @Override
    public List<Task> findByString(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of();
        }

        String searchKey = keyword.trim().toLowerCase();

        return tasksList.stream()
                .filter(t -> t.getTitle() != null &&
                        t.getTitle().toLowerCase().contains(searchKey))
                .toList();
    }

    @Override
    public Task createData(Task newTask) {
        tasksList.add(newTask);
        return newTask;
    }
}
