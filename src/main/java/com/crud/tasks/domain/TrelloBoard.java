package com.crud.tasks.domain;

import java.util.List;

public class TrelloBoard {
    private String id;
    private String name;
    private List<TrelloList> lists;

    public TrelloBoard() {

    }

    public TrelloBoard(String id, String name, List<TrelloList> lists) {
        this.id = id;
        this.name = name;
        this.lists = lists;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TrelloList> getLists() {
        return lists;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLists(List<TrelloList> lists) {
        this.lists = lists;
    }
}
