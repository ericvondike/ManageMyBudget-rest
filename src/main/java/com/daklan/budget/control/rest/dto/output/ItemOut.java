package com.daklan.budget.control.rest.dto.output;

import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

//@Repository
public class ItemOut implements Serializable {
    public static final Long serialVersionUID = 451L;

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

    public static Long getSerialVersionUID() {
        return serialVersionUID;
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
}
