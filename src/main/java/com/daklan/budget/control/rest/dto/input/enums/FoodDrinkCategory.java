package com.daklan.budget.control.rest.dto.input.enums;

public enum FoodDrinkCategory {
    BAKERY("Bakery"),
    GROCERY("Grocery"),
    DELI("Deli"),
    WINE("Wine"),
    FRUITVEGETABLES("Fruit and Vegetables"),
    MEATPOULTRY("Mean and Poultry"),
    FISHSEAFOOD("Fish and Seafood"),
    DAIRY("Dairy"),
    MILK("Milk"),
    EGGS("Eggs"),
    FROZENFOOD("Frozen Food"),
    DRINKS("Drinks"),
    BEER("Beer"),
    TEA("Tea"),
    COFFEE("Coffee"),
    HOTDRINKS("Hot Drinks"),
    CHILLEDFOOD("Chilled Food"),
    CEREALS("Cereals"),
    ;



    public static final FoodDrinkCategory[] ALL = {FOOD, CLOTHES, HYGIENE, SOFTDRINK, ALCOHOLICDRINK};
    private String  name;

    public static FoodDrinkCategory forName(final String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null for FoodDrinkCategory");
        }
        String upperName = name.toUpperCase();
        switch (upperName) {
            case "BAKERY":
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
                throw new IllegalArgumentException("FoodDrinkCategory \"" + name +"\"does not correspond to any existing category");
        }
    }

    FoodDrinkCategory(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
