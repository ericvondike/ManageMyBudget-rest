package com.daklan.budget.control.rest.dto.input;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CategoryIn implements Serializable {

    private static final Long serialVersionUID = 42L;

    @NotNull
    private Category category;
    /**
     * The free text zone entered by the customer.
     */
    private String givenName;

    /**
     * The classification made by the category.
     */
    @NotNull
    private String officialName;

    /**
     * The list of the items in the category.
     */
    @NotNull
    List<ItemIn> itemsList = new ArrayList<ItemIn>();


    /**
     * Total price of the items in the category
     */
    @NotNull
    private double itemCategoryPrice;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public List<ItemIn> getItemsList() {
        return this.itemsList;
    }

    public void setItemsList(List<ItemIn> itemsList) {
        this.itemsList = itemsList;
    }

    public double getItemCategoryPrice() {
        return itemCategoryPrice;
    }

    public void setItemCategoryPrice(double itemCategoryPrice) {
        this.itemCategoryPrice = itemCategoryPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CategoryIn)) return false;

        CategoryIn that = (CategoryIn) o;

        return new EqualsBuilder()
                .append(itemCategoryPrice, that.itemCategoryPrice)
                .append(givenName, that.givenName)
                .append(officialName, that.officialName)
                .append(itemsList, that.itemsList)
                .append(category, that.category)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(givenName)
                .append(officialName)
                .append(itemsList)
                .append(itemCategoryPrice)
                .append(category)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("givenName", givenName)
                .append("officialName", officialName)
                .append("itemsList", itemsList)
                .append("itemCategoryPrice", itemCategoryPrice)
                .append("category", category)
                .toString();
    }
}