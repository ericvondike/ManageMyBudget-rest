package com.daklan.budget.control.rest.dto.input.enums;

public enum KitchenShlef {
    BAKEWARE("Bakeware"),
    COOKWARE("Cookware"),
    DRINKWARE("Drinkware"),
    KITCHENTOOLS("KITCHENTOOLS"),
    DINNERWARE("Dinnerware");

    public static final KitchenShlef[] ALL = {BAKEWARE, COOKWARE, DRINKWARE, KITCHENTOOLS, DINNERWARE};
    private String  name;

    public static KitchenShlef forName(final String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null for KitchenShlef");
        }
        String upperName = name.toUpperCase();
        switch (upperName) {
            case "BAKEWARE":
                return BAKEWARE;
            case "COOKWARE":
                return COOKWARE;
            case "DRINKWARE":
                return DRINKWARE;
            case "KITCHENTOOLS":
                return KITCHENTOOLS;
            case "DINNERWARE":
                return DINNERWARE;
            default:
                throw new IllegalArgumentException("KitchenShlef \" " + name +" \"does not correspond to any existing category");
        }
    }

    KitchenShlef(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
