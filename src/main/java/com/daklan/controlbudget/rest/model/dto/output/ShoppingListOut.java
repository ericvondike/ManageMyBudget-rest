package com.daklan.controlbudget.rest.model.dto.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Repository
public class ShoppingListOut implements Serializable {
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
    private List<ItemCategoryOut> itemCategoryList;
    /**
     * The total price of the list
     */
    @NotNull
    private double listPrice;

    public ShoppingListOut() {
    }

    @Autowired
    public ShoppingListOut(@NotNull ShoppingCenterOut shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    /**
     * The shopping center from which the list has been bought.
     */
    @NotNull
    private ShoppingCenterOut shoppingCenter;

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public List<ItemCategoryOut> getItemCategoryList() {
        return itemCategoryList;
    }

    public void setItemCategoryList(List<ItemCategoryOut> itemCategoryList) {
        this.itemCategoryList = itemCategoryList;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public ShoppingCenterOut getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(ShoppingCenterOut shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }
}
