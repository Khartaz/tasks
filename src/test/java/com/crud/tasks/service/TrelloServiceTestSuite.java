package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {
    @InjectMocks
    private TrelloService trelloService;
    @Mock
    private SimpleEmailService simpleEmailService;
    @Mock
    private AdminConfig adminConfig;
    @Mock
    private TrelloClient trelloClient;

    @Test
    public void shouldFetchCreateTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test", "test", "test", "test");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("TestId", "Test", "testUrl");

        when(trelloService.createTrelloCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto newCard = trelloService.createTrelloCard(trelloCardDto);
        //Then
        assertNotNull(newCard);
        assertEquals("Test", newCard.getName());
    }
}