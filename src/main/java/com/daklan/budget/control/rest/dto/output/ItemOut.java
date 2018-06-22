package com.daklan.budget.control.rest.dto.output;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ItemOut implements Serializable {
    private static final long serialVersionUID = 4217934862473914572L;

    /**
     * The name Given by the end user to the item. This is a fre text zone without any control, but maybe for security reasons
     */
    private String itemGivenName;

    /**
     * The code given to the item by the shopping center.
     */
    private String itemCode;

    /**
     * This is the barcode of the item
     */
    private String itemBarcode;

    /**
     * This is a free text zone to be filled in for any reason.
     */
    private String itemDescription;

    private BigDecimal itemPrice;

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

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ItemOut)) return false;

        ItemOut itemOut = (ItemOut) o;

        return new EqualsBuilder()
                .append(itemGivenName, itemOut.itemGivenName)
                .append(itemCode, itemOut.itemCode)
                .append(itemBarcode, itemOut.itemBarcode)
                .append(itemDescription, itemOut.itemDescription)
                .append(itemPrice, itemOut.itemPrice)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(itemGivenName)
                .append(itemCode)
                .append(itemBarcode)
                .append(itemDescription)
                .append(itemPrice)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("itemGivenName", itemGivenName)
                .append("itemCode", itemCode)
                .append("itemBarcode", itemBarcode)
                .append("itemDescription", itemDescription)
                .append("itemPrice", itemPrice)
                .toString();
    }
}
