package com.daklan.controlbudget.rest.service;


import com.daklan.controlbudget.rest.model.dto.input.ShoppingListIn;
import com.daklan.controlbudget.rest.model.dto.output.ShoppingListOut;

public interface BasketService {
        ShoppingListOut BuildBasket(ShoppingListIn shoppingListIn);
}
