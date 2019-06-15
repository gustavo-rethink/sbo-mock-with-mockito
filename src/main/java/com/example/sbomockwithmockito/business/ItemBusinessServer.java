package com.example.sbomockwithmockito.business;

import com.example.sbomockwithmockito.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessServer {
    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
