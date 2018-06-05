package com.daklan.controlbudget.rest.controllers;



import com.daklan.controlbudget.rest.dto.output.ShoppingListOut;
import com.daklan.controlbudget.rest.dto.input.ShoppingListIn;
import com.daklan.controlbudget.rest.service.BasketService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Basket"}, description = "APIs for testing the basket")
@RestController
@RequestMapping(value = "/manage/basket")
public class BasketController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasketController.class);

    private BasketService service;

    @Autowired
    public BasketController(BasketService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShoppingListOut> buildBasket(@RequestBody ShoppingListIn shoppingListIn) {
        ShoppingListOut shoppingListOut = service.BuildBasket(shoppingListIn);
        return ResponseEntity.ok(shoppingListOut);
    }
}
