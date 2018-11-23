package com.crud.tasks.domain;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
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
    @GeneratedValue
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
