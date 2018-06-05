package com.daklan.controlbudget.rest.service;


import com.daklan.controlbudget.rest.dto.input.ShoppingListIn;
import com.daklan.controlbudget.rest.dto.output.ShoppingListOut;

public interface BasketService {
        ShoppingListOut BuildBasket(ShoppingListIn shoppingListIn);
}
