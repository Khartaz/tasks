package com.crud.tasks.controller;


import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {
    @Autowired
    private TrelloService trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
       return trelloService.fetchTrelloBoards();

       /*
       List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
       trelloBoards.forEach(t ->  {
           if (t.getName().contains("Kodilla")) {
               System.out.println(t.getName() + " " + t.getId());

               System.out.println("This board contains lists: ");

               t.getLists().forEach(x ->
                       System.out.println(x.getName() + " - " + x.getId() + " - " + x.isClosed()));
           }
       });
       */
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createTrelloCard(trelloCardDto);
    }
}