package com.daklan.budget.control.rest.dto.input.enums;

public enum Aisle {
    FOODDRINK("Food and Drinks"),
    HOUSEHOLD("Household"),
    KITCHEN("Kitchen"),
    PET("pet"),
    HEALTHBEAUTY("Health and Beauty"),
    BABY("Baby"),
    OUTDOORSPOSRTS("Outdoor and Sports"),
    OFFICESCHOOL("Office and School"),
    FLOWERS("Flowers"),
    ELECTRONICS("Electronics"),
    TOYS("Toys"),
    CLEARANCE("Clearance"),
    SPECIALOFFERS("Special Offers");

    public static final Aisle[] ALL = {FOODDRINK, HOUSEHOLD, KITCHEN, PET, HEALTHBEAUTY, BABY, OUTDOORSPOSRTS, OFFICESCHOOL, FLOWERS, ELECTRONICS, TOYS, CLEARANCE, SPECIALOFFERS};
    private String  name;

    public static Aisle forName(final String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null for aisle");
        }
        String upperName = name.toUpperCase();
        switch (upperName) {
            case "FOODDRINK":
                return FOODDRINK;
            case "HOUSEHOLD":
                return HOUSEHOLD;
            case "KITCHEN":
                return KITCHEN;
            case "HEALTHBEAUTY":
                return HEALTHBEAUTY;
            case "BABY":
                return BABY;
            case "OUTDOORSPOSRTS":
                return OUTDOORSPOSRTS;
            case "OFFICESCHOOL":
                return OFFICESCHOOL;
            case "FLOWERS":
                return FLOWERS;
            case "ELECTRONICS":
                return ELECTRONICS;
            case "TOYS":
                return TOYS;
            case "CLEARANCE":
                return CLEARANCE;
            case "SPECIALOFFERS":
                return SPECIALOFFERS;
            default:
                throw new IllegalArgumentException("Aisle \"" + name +"\"does not correspond to any existing shelf");
        }
    }

    Aisle(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
