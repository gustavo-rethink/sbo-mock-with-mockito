package com.example.sbomockwithmockito.data;

import com.example.sbomockwithmockito.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
