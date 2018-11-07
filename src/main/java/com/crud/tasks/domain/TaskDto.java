package com.crud.tasks.domain;

public class TaskDto {
    private Long id;
    private String title;
    private String content;

    public TaskDto() {

    }
    public TaskDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

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
