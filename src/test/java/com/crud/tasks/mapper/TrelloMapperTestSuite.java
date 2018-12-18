package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoards() {
        //Given
        List<TrelloBoardDto> listDto = new ArrayList<>();
        List<TrelloBoard> expected = new ArrayList<>();
        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(listDto);
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void mapToBoardsDto() {
        //Given
        List<TrelloBoardDto> expected = new ArrayList<>();
        List<TrelloBoard> list = new ArrayList<>();
        //When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(list);
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void mapToList() {
        //Given
        List<TrelloList> expected = new ArrayList<>();
        List<TrelloListDto> listDto = new ArrayList<>();
        //When
        List<TrelloList> result = trelloMapper.mapToList(listDto);
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void mapToListDto() {
        //Given
        List<TrelloList> list = new ArrayList<>();
        List<TrelloListDto> expected = new ArrayList<>();
        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(list);
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void mapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard();
        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(card);
        //Then
        assertNotEquals(card, result);
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto();
        //When
        TrelloCard result = trelloMapper.mapToCard(cardDto);
        //Then
        assertNotEquals(cardDto, result);

    }
}