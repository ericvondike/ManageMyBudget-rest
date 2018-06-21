package com.daklan.budget.control.rest.dto.input;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
//import java.util.Objects;

public class ItemIn implements Serializable {

    private static final Long serialVersionUID = 42L;

    /**
     * The name Given by the end user to the item. This is a fre text zone without any control, but maybe for security reasons
     */

    private String itemGivenName;

    /**
     * The code given to the item by the shopping center.
     */
    @NotNull
    private String itemCode;

    /**
     * This is the barcode of the item
     */
    @NotNull
    private String itemBarcode;

    /**
     * This is a free text zone to be filled in for any reason.
     */
    private String itemDescription;

    @NotNull
    private Integer numItem;

    @NotNull
    private double itemPrice;

    public Integer getNumItem() {
        return numItem;
    }

    public void setNumItem(Integer numItem) {
        this.numItem = numItem;
    }

    public String getItemGivenName() {
        return itemGivenName;
    }

    public void setItemGivenName(String itemGivenName) {
        this.itemGivenName = itemGivenName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ItemIn)) return false;

        ItemIn itemIn = (ItemIn) o;

        return new EqualsBuilder()
                .append(itemPrice, itemIn.itemPrice)
                .append(itemGivenName, itemIn.itemGivenName)
                .append(itemCode, itemIn.itemCode)
                .append(itemBarcode, itemIn.itemBarcode)
                .append(itemDescription, itemIn.itemDescription)
                .append(numItem, itemIn.numItem)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(itemGivenName)
                .append(itemCode)
                .append(itemBarcode)
                .append(itemDescription)
                .append(numItem)
                .append(itemPrice)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemGivenName='" + itemGivenName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemBarcode='" + itemBarcode + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemPrice=" + itemPrice + '\'' +
                ", numItem" + numItem +
                '}';
    }
}

