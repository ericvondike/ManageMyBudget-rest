package com.daklan.budget.control.rest.dto.input;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ItemIn implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * The name Given by the end user to the item. This is a fre text zone without any control, but maybe for security reasons
     */
    @NotNull
    private String itemName;

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
     * Number of a specific item in the basket
     */
    @NotNull
    private Integer numItem;

    /**
     * The price of an individual item
     */
    @NotNull
    private BigDecimal itemPrice;

    /**
     * The orgin of the item. This field can be null.
     */
    private String origin;

    public Integer getNumItem() {
        return numItem;
    }

    public void setNumItem(Integer numItem) {
        this.numItem = numItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemGivenName) {
        this.itemName = itemGivenName;
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

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ItemIn)) return false;

        ItemIn itemIn = (ItemIn) o;

        return new EqualsBuilder()
                .append(itemName, itemIn.itemName)
                .append(itemCode, itemIn.itemCode)
                .append(itemBarcode, itemIn.itemBarcode)
                .append(numItem, itemIn.numItem)
                .append(itemPrice, itemIn.itemPrice)
                .append(origin, itemIn.origin)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(itemName)
                .append(itemCode)
                .append(itemBarcode)
                .append(numItem)
                .append(itemPrice)
                .append(origin)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("itemName", itemName)
                .append("itemCode", itemCode)
                .append("itemBarcode", itemBarcode)
                .append("numItem", numItem)
                .append("itemPrice", itemPrice)
                .append("origin", origin)
                .toString();
    }
}

