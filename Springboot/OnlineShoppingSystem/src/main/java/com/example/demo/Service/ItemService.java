package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Item;
import com.example.demo.Repository.ItemRepo;


@Service
public class ItemService {

    @Autowired
    ItemRepo repo;

    public Item saveItem(Item item) {
        return repo.save(item);
    }
    
    
    
    
    public Item getItemByCode(String n) {
		return repo.findById(n).orElse(null);

	}
    
    public String updatePrice(String code, double newPrice) {
        Item item = repo.findById(code).orElse(null);
        if (item == null) {
            return "Item not found" + code;
        }
        item.setPrice(newPrice);
        repo.save(item);
        return "updated price is" + newPrice + " for item " + code;
    }

    public String generateBill(String code, int qty) {
        Item item = repo.findById(code).orElse(null);

        if (item == null) {
            return "Item not found: " + code;
        }

        if (item.getQuantity() < qty) {
            return "Insufficient quantity for item: " + code;
        }

        item.setQuantity(item.getQuantity() - qty);
        repo.save(item);

        double total = item.getPrice() * qty;
        return "Bill Generated : Item: " + item.getName() +
               ", Qty: " + qty + ", Total: " + total;
    }



   
    }

