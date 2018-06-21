package com.daklan.budget.control.rest.dto.output;


import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

//@Repository
public class ItemCategoryOut implements Serializable {

    private static final Long serialVersionUID = 451L;

    /**
     * The free text zone entered by the customer.
     */
    @Nullable
    private String itemCategoryGivenName;

    /**
     * The classification made by the category.
     */
    @NotNull
    private String itemCategory;

    /**
     * The list of the items in the category.
     */
    @NotNull
    List<ItemOut> itemsList;

    /**
     * Number of items in the category.
     */
    @NotNull
    private int numItem;

    /**
     * Total price of the items in the category
     */
    @NotNull
    private double itemCategoryPrice;

    public String getItemCategoryGivenName() {
        return itemCategoryGivenName;
    }

    public void setItemCategoryGivenName(String itemCategoryGivenName) {
        this.itemCategoryGivenName = itemCategoryGivenName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public List<ItemOut> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemOut> itemsList) {
        this.itemsList = itemsList;
    }

    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public double getItemCategoryPrice() {
        return itemCategoryPrice;
    }

    public void setItemCategoryPrice(double itemCategoryPrice) {
        this.itemCategoryPrice = itemCategoryPrice;
    }
}