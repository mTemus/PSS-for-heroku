package Model;

import Other.AutoCapacity;
import Other.TransportType;

import java.sql.Date;

public class Delegation {
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

}
