package com.daklan.controlbudget.rest.model.dto.output;

import com.daklan.controlbudget.rest.model.dto.enums.WeekDays;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ShoppingCenterOut implements Serializable {
    private static final Long serialVersionUID = 451L;

    @NotNull
    private String code;
    @NotNull
    private String officialname;
    /**
     * The given name of the shopping center given by user.
     */
    @Nullable
    private String givenName;
    @Nullable
    private String address;
    @Nullable
    private List<WeekDays> weekDays;
    @Nullable
    private List<LocalDate> datesOpen;
    @Nullable
    private String telNumber;

    public ShoppingCenterOut() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOfficialname() {
        return officialname;
    }

    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<WeekDays> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<WeekDays> weekDays) {
        this.weekDays = weekDays;
    }

    public List<LocalDate> getDatesOpen() {
        return datesOpen;
    }

    public void setDatesOpen(List<LocalDate> datesOpen) {
        this.datesOpen = datesOpen;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
