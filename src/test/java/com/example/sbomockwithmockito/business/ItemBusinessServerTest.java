package com.example.sbomockwithmockito.business;

import com.example.sbomockwithmockito.data.ItemRepository;
import com.example.sbomockwithmockito.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServerTest {

    @InjectMocks
    private ItemBusinessServer itemBusinessServer;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retrieveHardCodedItem() {
        Item item = itemBusinessServer.retrieveHardCodedItem();

        assertEquals(new Item(1, "Ball", 10, 100), item);
    }

    @Test
    public void retrieveAllItems() {
        List<Item> itemsMock = Arrays.asList(
                new Item(1, "item1", 10, 20),
                new Item(2, "item2", 30, 40),
                new Item(3, "item3", 50, 60)
        );

        when(itemRepository.findAll()).thenReturn(itemsMock);

        List<Item> items = itemBusinessServer.retrieveAllItems();

        assertEquals(3, items.size());
    }
}