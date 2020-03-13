package Model;

import Other.AutoCapacity;
import Other.TransportType;

import java.sql.Date;

public class Delegation {

    public Delegation() {
    }
    private String description;
    private Date dateTimeStart;
    private Date dateTimeStop;
    private int travelDietAmount = 30;
    private int breakfastNumber = 0;
    private int dinnerNumber = 0;
    private int supperNumber = 0;
    private TransportType transportType;
    private AutoCapacity autoCapacity;
    private int km;
    private int accommodationPrice;
    private int TicketsPrice;
    private String otherOutlayDesc;
    private int otherOutlayPrice;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(Date dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public Date getDateTimeStop() {
        return dateTimeStop;
    }

    public void setDateTimeStop(Date dateTimeStop) {
        this.dateTimeStop = dateTimeStop;
    }

    public int getTravelDietAmount() {
        return travelDietAmount;
    }

    public void setTravelDietAmount(int travelDietAmount) {
        this.travelDietAmount = travelDietAmount;
    }

    public int getBreakfastNumber() {
        return breakfastNumber;
    }

    public void setBreakfastNumber(int breakfastNumber) {
        this.breakfastNumber = breakfastNumber;
    }

    public int getDinnerNumber() {
        return dinnerNumber;
    }

    public void setDinnerNumber(int dinnerNumber) {
        this.dinnerNumber = dinnerNumber;
    }

    public int getSupperNumber() {
        return supperNumber;
    }

    public void setSupperNumber(int supperNumber) {
        this.supperNumber = supperNumber;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public AutoCapacity getAutoCapacity() {
        return autoCapacity;
    }

    public void setAutoCapacity(AutoCapacity autoCapacity) {
        this.autoCapacity = autoCapacity;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getAccommodationPrice() {
        return accommodationPrice;
    }

    public void setAccommodationPrice(int accommodationPrice) {
        this.accommodationPrice = accommodationPrice;
    }

    public int getTicketsPrice() {
        return TicketsPrice;
    }

    public void setTicketsPrice(int ticketsPrice) {
        TicketsPrice = ticketsPrice;
    }

    public String getOtherOutlayDesc() {
        return otherOutlayDesc;
    }

    public void setOtherOutlayDesc(String otherOutlayDesc) {
        this.otherOutlayDesc = otherOutlayDesc;
    }

    public int getOtherOutlayPrice() {
        return otherOutlayPrice;
    }

    public void setOtherOutlayPrice(int otherOutlayPrice) {
        this.otherOutlayPrice = otherOutlayPrice;
    }
}
