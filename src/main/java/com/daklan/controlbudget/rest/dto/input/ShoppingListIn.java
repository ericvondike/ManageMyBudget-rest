package com.daklan.controlbudget.rest.dto.input;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Repository
public class ShoppingListIn implements Serializable {
    private static final Long serialVersionUID = 451L;

    /**
     * The free title given to a list by the customer
     */
    @NotNull
    private String listTitle;

    /**
     * The list of the item classes in here
     */
    @NotNull
    private List<ItemCategoryIn> itemCategoryList;

    /**
     * The total price of the list
     */
    @NotNull
    private double listPrice;

    /**
     * The shopping center from which the list has been bought.
     */
    @NotNull
    private ShoppingCenterIn shoppingCenter;

    public ShoppingListIn() {
    }

    public ShoppingListIn(@NotNull ShoppingCenterIn shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public List<ItemCategoryIn> getItemCategoryList() {
        return itemCategoryList;
    }

    public void setItemCategoryList(List<ItemCategoryIn> itemCategoryListIn) {
        this.itemCategoryList = itemCategoryListIn;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public ShoppingCenterIn getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(ShoppingCenterIn shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }
}
