package com.daklan.budget.control.rest.dto;

public enum Category {
    FOOD("Food"),
    CLOTHES("Clothes"),
    HYGIENE("Hygiene"),
    SOFTDRINK("Soft drink"),
    ALCOHOLICDRINK("AlcoholicDrink");

    public static final Category[] ALL = {FOOD, CLOTHES, HYGIENE, SOFTDRINK, ALCOHOLICDRINK};
    private String  name;

    public static Category forName(final String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null for shoppingCenter");
        }
        String upperName = name.toUpperCase();
        switch (upperName) {
            case "FOOD":
                return FOOD;
            case "CLOTHES":
                return CLOTHES;
            case "HYGIENE":
                return HYGIENE;
            case "SOFTDRINK":
                return SOFTDRINK;
            case "ALCOHOLICS":
                return ALCOHOLICDRINK;
            default:
                throw new IllegalArgumentException("ShoppingCenter \"" + name +"\"does not correspond to any existing aategory");
        }
    }

    Category(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
