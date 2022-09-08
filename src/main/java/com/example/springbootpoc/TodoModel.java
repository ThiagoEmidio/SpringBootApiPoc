package com.example.springbootpoc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoModel {
    private @Id @GeneratedValue Long id;
    private String content;

    TodoModel() {}

    TodoModel(String content) {
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }
    public void setId(Long id) {
       this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
