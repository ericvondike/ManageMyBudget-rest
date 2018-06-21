package com.daklan.budget.control.rest.service.impl;

import com.daklan.budget.control.rest.dto.input.CategoryIn;
import com.daklan.budget.control.rest.dto.input.ItemIn;
import com.daklan.budget.control.rest.dto.input.ShoppingListIn;
import com.daklan.budget.control.rest.dto.output.ItemCategoryOut;
import com.daklan.budget.control.rest.dto.output.ItemOut;
import com.daklan.budget.control.rest.dto.output.ShoppingCenterOut;
import com.daklan.budget.control.rest.dto.output.ShoppingListOut;
import com.daklan.budget.control.rest.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class BasketServiceImpl implements BasketService {


    private ShoppingListIn shoppingListIn;
    private ShoppingListOut shoppingListOut;
    /**
     *
     * @param shoppingListIn
     * @param shoppingListOut
     */
    @Autowired
    public BasketServiceImpl(ShoppingListIn shoppingListIn, ShoppingListOut shoppingListOut) {
        this.shoppingListIn = shoppingListIn;
        this.shoppingListOut = shoppingListOut;
    }


    /**
     *
     * @param shoppingListIn
     * @return shoppingListOut
     */
    @Override
    public ShoppingListOut BuildBasket(ShoppingListIn shoppingListIn, Model model) {

        shoppingListOut.setListTitle(shoppingListIn.getListTitle());
        shoppingListOut.setShoppingCenter(getShoppingCenter(shoppingListIn));
        shoppingListOut.setItemCategoryList(getItemCategoryList(shoppingListIn));

        return shoppingListOut;
    }


    /**
     *
     * @param shoppingListIn
     * @return dates
     * Returns a list of the days at which the shoppingcenter is open.
     */
    private List<LocalDate> getDatesOpen(ShoppingListIn shoppingListIn) {
        List<LocalDate> dates = new ArrayList<>();
        if(shoppingListIn.getShoppingCenterIn().getDatesOpen() != null) {

            for (String strDate : shoppingListIn.getShoppingCenterIn().getDatesOpen()) {
                LocalDate date = LocalDate.parse(strDate);
                dates.add(date);
            }
        }
        return dates;
    }

    /**
     *
     * @param shoppingListIn
     * @return
     */
    private ShoppingCenterOut getShoppingCenter(ShoppingListIn shoppingListIn) {
        ShoppingCenterOut shoppingCenterOut = new ShoppingCenterOut();

        shoppingCenterOut.setDatesOpen(getDatesOpen(shoppingListIn));
        shoppingCenterOut.setTelNumber(shoppingListIn.getShoppingCenterIn().getTelNumber());
        shoppingCenterOut.setOfficialname(shoppingListIn.getShoppingCenterIn().getOfficialname());
        shoppingCenterOut.setGivenName(shoppingListIn.getShoppingCenterIn().getGivenName());
        shoppingCenterOut.setCode(shoppingListIn.getShoppingCenterIn().getCode());
        shoppingCenterOut.setAddress(shoppingListIn.getShoppingCenterIn().getAddress());

        return shoppingCenterOut;
    }

    /**
     *
     * @param shoppingListIn
     * @return
     */
    private List<ItemCategoryOut> getItemCategoryList(ShoppingListIn shoppingListIn) {
        List<ItemCategoryOut> itemCategoryOuts = new ArrayList<>();
        if(shoppingListIn.getCategoryInList() != null) {
            for(CategoryIn categoryIn : shoppingListIn.getCategoryInList()) {
                ItemCategoryOut itemCategoryOut = new ItemCategoryOut();

                itemCategoryOut.setItemCategoryGivenName(categoryIn.getGivenName());
                itemCategoryOut.setItemCategory(categoryIn.getOfficialName());
                itemCategoryOut.setItemCategoryPrice(categoryIn.getItemCategoryPrice());
                itemCategoryOut.setItemsList(getItemsList(categoryIn));

                itemCategoryOuts.add(itemCategoryOut);
            }

        }

        return itemCategoryOuts;
    }

    /**
     *
     * @param categoryIn
     * @return
     */
    private List<ItemOut> getItemsList(CategoryIn categoryIn) {
        List<ItemOut> itemOuts = new ArrayList<>();

        for (ItemIn itemIn : categoryIn.getItemsList()) {
            ItemOut itemOut = new ItemOut();

            itemOut.setItemBarcode(itemIn.getItemBarcode());
            itemOut.setItemCode(itemIn.getItemCode());
            itemOut.setItemDescription(itemIn.getItemDescription());
            itemOut.setItemGivenName(itemIn.getItemGivenName());
            itemOut.setItemPrice(itemIn.getItemPrice());

            itemOuts.add(itemOut);
        }
        return  itemOuts;
    }
}
