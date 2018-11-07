package com.crud.tasks.domain;

import javax.persistence.*;

@Entity(name = "tasks")
public class Task {
    private Long id;
    private String title;
    private String content;

    public Task() {
    }

    public Task(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getTitle() {
        return title;
    }

    @Column(name = "DESCRIPTION")
    public String getContent() {
        return content;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setContent(String content) {
        this.content = content;
    }
}
