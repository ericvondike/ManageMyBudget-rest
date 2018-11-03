package com.daklan.controlbudget.rest.model.dto.input;

import com.daklan.controlbudget.rest.model.dto.enums.WeekDays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ShoppingCenterIn implements Serializable {

    private static final Long serialVersionUID = -45744158454644L;


    @NotNull
    private String code;
    @NotNull
    private String officialname;

    @Autowired
    public ShoppingCenterIn() {
    }

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



    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }
    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }


    /**
     *
     * @return
     */
    public String getOfficialname() {
        return officialname;
    }
    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    /**
     *
     * @return
     */
    public String getGivenName() {
        return givenName;
    }
    /**
     *
     * @param givenName
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }


    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }
    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     *
     * @return
     */
    public List<WeekDays> getWeekDays() {
        return weekDays;
    }
    /**
     *
     * @param weekDays
     */
    public void setWeekDays(List<WeekDays> weekDays) {
        this.weekDays = weekDays;
    }


    /**
     *
     * @return
     */
    public List<LocalDate> getDatesOpen() {
        return datesOpen;
    }
    /**
     *
     * @param datesOpen
     */
    public void setDatesOpen(List<LocalDate> datesOpen) {
        this.datesOpen = datesOpen;
    }


    /**
     *
     * @return
     */
    public String getTelNumber() {
        return telNumber;
    }

    /**
     *
     * @param telNumber
     */
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
