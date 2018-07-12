package com.daklan.budget.control.rest.dto.input.enums;

public enum WorldFood {
    CHINESE("Chinese"),
    INDIAN("Indian"),
    ITALIAN("Italian"),
    JAPANESE("JApanese"),
    MEXICAN("Mexican"),
    THAI("Thai"),
    OTHER("Other");

    public static final WorldFood[] ALL = {CHINESE, INDIAN, ITALIAN, JAPANESE, MEXICAN, THAI, OTHER};
    private String  name;

    public static WorldFood forName(final String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null for FoodDrinkShelf");
        }
        String upperName = name.toUpperCase();
        switch (upperName) {
            case "CHINESE":
                return CHINESE;
            case "INDIAN":
                return INDIAN;
            case "ITALIAN":
                return ITALIAN;
            case "JAPANESE":
                return JAPANESE;
            case "MEXICAN":
                return MEXICAN;
            case "THAI":
                return THAI;
            case "OTHER":
                return OTHER;
            default:
                throw new IllegalArgumentException("FoodDrinkShelf \"" + name +"\"does not correspond to any existing category");
        }
    }

    WorldFood(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
