package org.example.module13_3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
