package com.daklan.budget.control.rest.dto.output;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ShoppingListOut implements Serializable {
    private static final long serialVersionUID = 451L;

    /**
     * The free title given to a list by the customer
     */
    private String listTitle;

    /**
     * The list of the item classes in here
     */
    private List<CategoryOut> categoryOuts;

    /**
     * The total price of the list
     */
    private BigDecimal listPrice;
    /**
     * The date the list has been shopped
     */
    private LocalDate dateShopped;


    /**
     * The shopping center from which the list has been bought.
     */
    private ShoppingCenterOut shoppingCenterOut;


    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public List<CategoryOut> getCategoryOuts() {
        return categoryOuts;
    }

    public void setCategoryOuts(List<CategoryOut> categoryOuts) {
        this.categoryOuts = categoryOuts;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public LocalDate getDateShopped() {
        return dateShopped;
    }

    public void setDateShopped(LocalDate dateShopped) {
        this.dateShopped = dateShopped;
    }

    public ShoppingCenterOut getShoppingCenterOut() {
        return shoppingCenterOut;
    }

    public void setShoppingCenterOut(ShoppingCenterOut shoppingCenterOut) {
        this.shoppingCenterOut = shoppingCenterOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ShoppingListOut)) return false;

        ShoppingListOut that = (ShoppingListOut) o;

        return new EqualsBuilder()
                .append(listTitle, that.listTitle)
                .append(categoryOuts, that.categoryOuts)
                .append(listPrice, that.listPrice)
                .append(dateShopped, that.dateShopped)
                .append(shoppingCenterOut, that.shoppingCenterOut)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(listTitle)
                .append(categoryOuts)
                .append(listPrice)
                .append(dateShopped)
                .append(shoppingCenterOut)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("listTitle", listTitle)
                .append("categoryOuts", categoryOuts)
                .append("listPrice", listPrice)
                .append("dateShopped", dateShopped)
                .append("shoppingCenterOut", shoppingCenterOut)
                .toString();
    }
}
