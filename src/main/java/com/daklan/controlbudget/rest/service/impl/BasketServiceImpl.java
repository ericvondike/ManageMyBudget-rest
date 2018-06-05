package com.daklan.controlbudget.rest.service.impl;


import com.daklan.controlbudget.rest.dto.input.ItemCategoryIn;
import com.daklan.controlbudget.rest.dto.input.ItemIn;
import com.daklan.controlbudget.rest.dto.input.ShoppingListIn;
import com.daklan.controlbudget.rest.dto.output.ItemCategoryOut;
import com.daklan.controlbudget.rest.dto.output.ItemOut;
import com.daklan.controlbudget.rest.dto.output.ShoppingListOut;
import com.daklan.controlbudget.rest.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
public class BasketServiceImpl implements BasketService {
    private ShoppingListIn shoppingListIn;
    private ShoppingListOut shoppingListOut;

    @Autowired
    public BasketServiceImpl(ShoppingListIn shoppingListIn, ShoppingListOut shoppingListOut) {
        this.shoppingListIn = shoppingListIn;
        this.shoppingListOut = shoppingListOut;
    }

    @Override
    public ShoppingListOut BuildBasket(ShoppingListIn shoppingListIn) {

        shoppingListOut.setListTitle(shoppingListIn.getListTitle());
        shoppingListOut.setListPrice(shoppingListIn.getListPrice());

        shoppingListOut.getShoppingCenter().setAddress(shoppingListIn.getShoppingCenter().getAddress());
        shoppingListOut.getShoppingCenter().setCode(shoppingListIn.getShoppingCenter().getCode());
        shoppingListOut.getShoppingCenter().setGivenName(shoppingListIn.getShoppingCenter().getGivenName());
        shoppingListOut.getShoppingCenter().setOfficialname(shoppingListIn.getShoppingCenter().getOfficialname());
        shoppingListOut.getShoppingCenter().setTelNumber(shoppingListIn.getShoppingCenter().getTelNumber());

        List<LocalDate> dates = new ArrayList<>();
        for (LocalDate date : shoppingListIn.getShoppingCenter().getDatesOpen()) {
            dates.add(date);
        }
        shoppingListOut.getShoppingCenter().setDatesOpen(dates);


        List<ItemOut> itemOuts = new ArrayList<>();
        List<ItemCategoryOut> categoryOuts = new ArrayList<>();


        for (int i = 0; i < shoppingListIn.getItemCategoryList().size(); i++) {
            ItemCategoryIn itemCategoryIn =  shoppingListIn.getItemCategoryList().get(i);

            if(itemCategoryIn.getItemCategory() != null) {

                ItemCategoryOut itemCategoryOut = new ItemCategoryOut();

                itemCategoryOut.setItemCategory(itemCategoryIn.getItemCategory());
                itemCategoryOut.setItemCategoryGivenName(itemCategoryIn.getItemCategoryGivenName());
                itemCategoryOut.setItemCategoryPrice(itemCategoryIn.getItemCategoryPrice());
                itemCategoryOut.setNumItem(itemCategoryIn.getNumItem());


                for (int j = 0; j < itemCategoryIn.getItemsList().size(); j++) {
                    ItemIn itemIn = itemCategoryIn.getItemsList().get(j);

                    if(itemIn != null) {

                        ItemOut itemOut = new ItemOut();

                        itemOut.setItemGivenName(itemIn.getItemGivenName());
                        itemOut.setItemCode(itemIn.getItemCode());
                        itemOut.setItemBarcode(itemIn.getItemBarcode());
                        itemOut.setItemDescription(itemIn.getItemDescription());
                        itemOut.setItemPrice(itemIn.getItemPrice());

                        itemOuts.add(itemOut);
                    }
                }

                itemCategoryOut.setItemsList(itemOuts);
                categoryOuts.add(itemCategoryOut);
            }

        }

        shoppingListOut.setItemCategoryList(categoryOuts);


        return shoppingListOut;

    }


}
