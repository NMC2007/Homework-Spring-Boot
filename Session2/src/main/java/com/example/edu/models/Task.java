package com.example.edu.models;

import com.example.edu.enums.PriorityTask;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
    private int id;
    private int assignedTo;
    private String title;
    private String description;
    private PriorityTask priority;
}
