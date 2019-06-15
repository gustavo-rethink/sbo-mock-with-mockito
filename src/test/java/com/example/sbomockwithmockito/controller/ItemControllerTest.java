package com.example.sbomockwithmockito.controller;

import com.example.sbomockwithmockito.business.ItemBusinessServer;
import com.example.sbomockwithmockito.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ItemBusinessServer mockItemBuisinessServer;

    @Test
    public void dummyItem() throws Exception {

        when(mockItemBuisinessServer.retrieveHardCodedItem())
                .thenReturn(new Item(1, "Gustavo", 10, 20));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 1, name: Gustavo, price: 10, quantity: 20}"))
                .andReturn();

    }

}