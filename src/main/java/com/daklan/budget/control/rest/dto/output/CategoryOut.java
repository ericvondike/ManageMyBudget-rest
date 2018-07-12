package com.daklan.budget.control.rest.dto.output;


import com.daklan.budget.control.rest.dto.input.enums.FoodDrinkShelf;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CategoryOut implements Serializable {

    private static final long serialVersionUID = 4517541621693621478L;

    /**
     * The free text zone entered by the customer.
     */
    @Nullable
    private String itemCategoryGivenName;

    /**
     * The classification made by the category.
     */
    @NotNull
    private FoodDrinkShelf itemCategory;

    /**
     * The list of the items in the category.
     */
    @NotNull
    List<ItemOut> itemOuts;
    /**
     * Total price of the items in the category
     */
    @NotNull
    private BigDecimal categoryPrice;

    public String getItemCategoryGivenName() {
        return itemCategoryGivenName;
    }

    public void setItemCategoryGivenName(String itemCategoryGivenName) {
        this.itemCategoryGivenName = itemCategoryGivenName;
    }

    public FoodDrinkShelf getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(FoodDrinkShelf itemCategory) {
        this.itemCategory = itemCategory;
    }

    public List<ItemOut> getItemOuts() {
        return itemOuts;
    }

    public void setItemOuts(List<ItemOut> itemOuts) {
        this.itemOuts = itemOuts;
    }

    public BigDecimal getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(BigDecimal categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CategoryOut)) return false;

        CategoryOut that = (CategoryOut) o;

        return new EqualsBuilder()
                .append(itemCategoryGivenName, that.itemCategoryGivenName)
                .append(itemCategory, that.itemCategory)
                .append(itemOuts, that.itemOuts)
                .append(categoryPrice, that.categoryPrice)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(itemCategoryGivenName)
                .append(itemCategory)
                .append(itemOuts)
                .append(categoryPrice)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("itemCategoryGivenName", itemCategoryGivenName)
                .append("itemCategory", itemCategory)
                .append("itemOuts", itemOuts)
                .append("categoryPrice", categoryPrice)
                .toString();
    }
}