package com.daklan.controlbudget.rest.dto.input;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class ItemIn implements Serializable {

    private static final Long serialVersionUID = 42L;

    /**
     * The name Given by the end user to the item. This is a fre text zone without any control, but maybe for security reasons
     */
    @Nullable
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
    @Nullable
    private String itemDescription;

    @NotNull
    private double itemPrice;

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
        if (o == null || getClass() != o.getClass()) return false;
        ItemIn item = (ItemIn) o;
        return Double.compare(item.itemPrice, itemPrice) == 0 &&
                Objects.equals(itemCode, item.itemCode) &&
                Objects.equals(itemBarcode, item.itemBarcode) &&
                Objects.equals(itemDescription, item.itemDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemCode, itemBarcode, itemDescription, itemPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemGivenName='" + itemGivenName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemBarcode='" + itemBarcode + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
