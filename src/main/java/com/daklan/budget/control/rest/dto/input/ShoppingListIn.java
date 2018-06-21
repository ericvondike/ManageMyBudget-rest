package com.daklan.budget.control.rest.dto.input;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ShoppingListIn implements Serializable {
    private static final long serialVersionUID = 4517865641481565634L;

    /**
     * The free title given to a list by the customer
     */
    @NotNull
    private String listTitle;
    @NotNull
    private LocalDate dateShopped;

    /**
     * The list of the item classes in here
     */
    @NotNull
    private List<CategoryIn> categoryInList = new ArrayList<CategoryIn>();


    /**
     * The shopping center from which the list has been bought.
     */
    @NotNull
    private ShoppingCenterIn shoppingCenterIn;

    @NotNull
    private ShoppingCenter shoppingCenter;

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public LocalDate getDateShopped() {
        return dateShopped;
    }

    public void setDateShopped(LocalDate dateShopped) {
        this.dateShopped = dateShopped;
    }

    public List<CategoryIn> getCategoryInList() {
        return categoryInList;
    }

    public void setCategoryInList(List<CategoryIn> categoryInList) {
        this.categoryInList = categoryInList;
    }

    public ShoppingCenterIn getShoppingCenterIn() {
        return shoppingCenterIn;
    }

    public void setShoppingCenterIn(ShoppingCenterIn shoppingCenterIn) {
        this.shoppingCenterIn = shoppingCenterIn;
    }

    public ShoppingCenter getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(ShoppingCenter shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ShoppingListIn)) return false;

        ShoppingListIn that = (ShoppingListIn) o;

        return new EqualsBuilder()
                .append(listTitle, that.listTitle)
                .append(dateShopped, that.dateShopped)
                .append(categoryInList, that.categoryInList)
                .append(shoppingCenterIn, that.shoppingCenterIn)
                .append(shoppingCenter, that.shoppingCenter)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(listTitle)
                .append(dateShopped)
                .append(categoryInList)
                .append(shoppingCenterIn)
                .append(shoppingCenter)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("listTitle", listTitle)
                .append("dateShopped", dateShopped)
                .append("categoryInList", categoryInList)
                .append("shoppingCenterIn", shoppingCenterIn)
                .append("shoppingCenter", shoppingCenter)
                .toString();
    }
}
