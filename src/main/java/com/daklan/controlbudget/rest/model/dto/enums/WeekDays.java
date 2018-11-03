package com.daklan.controlbudget.rest.model.dto.enums;

public enum WeekDays {
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),
    SUN("Sunday");

    private String day;

    WeekDays(String day) {
        this.day = day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
