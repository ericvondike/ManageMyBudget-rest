package com.daklan.budget.control.rest.service;

import com.daklan.budget.control.rest.dto.input.ShoppingListIn;
import com.daklan.budget.control.rest.dto.output.ShoppingListOut;
//import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

public interface BasketService {
    ShoppingListOut BuildBasket(ShoppingListIn shoppingListIn, Model model);
}