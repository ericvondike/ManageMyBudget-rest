package com.daklan.budget.control.rest.repositories;

import com.daklan.budget.control.rest.dto.input.ShoppingListIn;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BasketRepository {
    private final List<ShoppingListIn> shoppingListIns = new ArrayList<ShoppingListIn>();

    public BasketRepository() {
        super();
    }

    public List<ShoppingListIn> findAll() {
        return new ArrayList<ShoppingListIn>(this.shoppingListIns);
    }

    public void add(final ShoppingListIn shoppingListIn) {
        this.shoppingListIns.add(shoppingListIn);
    }
}
