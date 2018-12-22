package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBoardDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;

    public TrelloBoardDto() {

    }

    public TrelloBoardDto(String id, String name, List<TrelloListDto> lists) {
        this.name = name;
        this.id = id;
        this.lists = lists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TrelloListDto> getLists() {
        return lists;
    }

    public void setLists(List<TrelloListDto> lists) {
        this.lists = lists;
    }
}
