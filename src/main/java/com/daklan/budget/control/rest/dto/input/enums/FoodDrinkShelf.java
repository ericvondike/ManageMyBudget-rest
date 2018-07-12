package com.daklan.budget.control.rest.dto.input.enums;

public enum FoodDrinkShelf {
    BAKERY("Bakery"),
    GROCERY("Grocery"),
    DELI("Deli"),
    WINE("Wine"),
    FRUITVEGETABLES("Fruit and Vegetables"),
    MEATPOULTRY("Meat and Poultry"),
    FISHSEAFOOD("Fish and Seafood"),
    DAIRY("Dairy"),
    FROZENFOOD("Frozen Food"),
    DRINKS("Drinks"),
    BEER("Beer"),
    TEA("Tea"),
    COFFEE("Coffee"),
    HOTDRINKS("Hot Drinks"),
    CHILLEDFOOD("Chilled Food"),
    CEREALS("Cereals"),
    PREPAREDFOOD("PREPAREDFOOD");



    public static final FoodDrinkShelf[] ALL = {BAKERY, GROCERY, DELI, WINE, FRUITVEGETABLES, MEATPOULTRY,
            DAIRY, FROZENFOOD, DRINKS, TEA, COFFEE, HOTDRINKS, CHILLEDFOOD, CEREALS};
    private String  name;

    public static FoodDrinkShelf forName(final String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null for FoodDrinkShelf");
        }
        String upperName = name.toUpperCase();
        switch (upperName) {
            case "BAKERY":
                return BAKERY;
            case "GROCERY":
                return GROCERY;
            case "DELI":
                return DELI;
            case "WINE":
                return WINE;
            case "FRUITVEGETABLES":
                return FRUITVEGETABLES;
            case "MEATPOULTRY":
                return MEATPOULTRY;
            case "FISHSEAFOOD":
                return FISHSEAFOOD;
            case "DAIRY":
                return DAIRY;
            case "FROZENFOOD":
                return FROZENFOOD;
            case "DRINKS":
                return DRINKS;
            case "BEER":
                return BEER;
            case "TEA":
                return TEA;
            case "COFFEE":
                return COFFEE;
            case "HOTDRINKS":
                return HOTDRINKS;
            case "CHILLEDFOOD":
                return CHILLEDFOOD;
            case "CEREALS":
                return CEREALS;
            case "PREPAREDFOOD":
                return PREPAREDFOOD;
            default:
                throw new IllegalArgumentException("FoodDrinkShelf \" " + name +" \"does not correspond to any existing category");
        }
    }

    FoodDrinkShelf(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
