package com.example.sbomockwithmockito.controller;

import com.example.sbomockwithmockito.business.ItemBusinessServer;
import com.example.sbomockwithmockito.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	ItemBusinessServer itemBusinessServer;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return itemBusinessServer.retrieveHardCodedItem();
	}
	
}
