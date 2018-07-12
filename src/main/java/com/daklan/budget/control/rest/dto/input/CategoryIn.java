package com.daklan.budget.control.rest.dto.input;

import com.daklan.budget.control.rest.dto.input.enums.FoodDrinkShelf;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CategoryIn implements Serializable {

    private static final long serialVersionUID = 42L;

    @NotNull
    private FoodDrinkShelf category;
    /**
     * The free text zone entered by the customer.
     */
    private String givenName;


    /**
     * The list of the items in the category.
     */
    @NotNull
    List<ItemIn> itemsList = new ArrayList<ItemIn>();


    public FoodDrinkShelf getCategory() {
        return category;
    }

    public void setCategory(FoodDrinkShelf foodDrinkShelf) {
        this.category = foodDrinkShelf;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public List<ItemIn> getItemsList() {
        return this.itemsList;
    }

    public void setItemsList(List<ItemIn> itemsList) {
        this.itemsList = itemsList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CategoryIn)) return false;

        CategoryIn that = (CategoryIn) o;

        return new EqualsBuilder()
                .append(givenName, that.givenName)
                .append(itemsList, that.itemsList)
                .append(category, that.category)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(givenName)
                .append(itemsList)
                .append(category)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("givenName", givenName)
                .append("itemsList", itemsList)
                .append("category", category)
                .toString();
    }
}