package com.crud.tasks.controller;


import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {
    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {
       List<Optional<TrelloBoardDto>> trelloBoards = trelloClient.getTrelloBoards();
       /*
       trelloBoards.forEach(t -> {
                   if (t.getName().contains("Kodilla")) {
                       System.out.println(t.getName() + " " + t.getId());
                   }
               });
            */
       trelloBoards.forEach(t -> t.ifPresent( v -> {
           if (v.getName().contains("Kodilla")) {
               System.out.println(v.getName() + " " + v.getId());
           }
       }));
        /*
        trelloBoards.ifPresent(v -> v.forEach(t -> {
            if (t.getName().contains("Kodilla")) {
                System.out.println(t.getName() + " " + t.getId());
            }
        }));
        */
    }
}
