package com.example.edu.services;

import com.example.edu.models.Task;
import com.example.edu.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements IBaseServices<Task> {
    private final TaskRepository taskRepository;

    private final UserService userService;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByString(String keyword) {
        return taskRepository.findByString(keyword);
    }

    @Override
    public Task createData(Task newTask) {
//        lấy ra user id task mới vừa được tạo
//        ném cho userService.findById nếu user có tồn tại thì trả về user đó
//        tiếp tục gọi đến taskRepository.createData để thêm task mới
//        nếu user không tồn tại thì được null và return null luôn
        int UserId = newTask.getAssignedTo();
        if (userService.findByID(UserId) == null) {
            return null;
        }
        return taskRepository.createData(newTask);
    }

    @Override
    public Task findByID(int id) {
        return null;
    }
}
