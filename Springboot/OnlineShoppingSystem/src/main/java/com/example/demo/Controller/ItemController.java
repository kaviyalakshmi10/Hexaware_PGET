package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Item;
import com.example.demo.Service.ItemService;


@RestController
public class ItemController {

    @Autowired
    ItemService ser;

    @PostMapping("/saveItem")
    public Item saveItem(@RequestBody Item item) {
        return ser.saveItem(item);
        
    }

    @GetMapping("/getItemById/{code}")
	public Item getItembyCode(@PathVariable String code) {
		return ser.getItemByCode(code);
	}

    @PutMapping("/items/{code}/{price}")
    public String updatePrice(@PathVariable String code, @PathVariable double price) {
        return ser.updatePrice(code, price);
    }

    @PostMapping("/bill/{code}/{qty}")
    public String generateBill(@PathVariable String code, @PathVariable int qty) {
        return ser.generateBill(code, qty);
    }
 


   
   
}
