package Model;

import Other.AutoCapacity;
import Other.TransportType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Delegation {

    @Id
    @GeneratedValue
    @Column(name = "idDelegation")
    private Integer idDelegation;
    @Column(name = "description")
    private String description;
    @Column(name = "dateTimeStart")
    private Date dateTimeStart;
    @Column(name = "dateTimeStop")
    private Date dateTimeStop;
    @Column(name = "travelDietAmount")
    private int travelDietAmount = 30;
    @Column(name = "breakfastNumber")
    private int breakfastNumber = 0;
    @Column(name = "dinnerNumber")
    private int dinnerNumber = 0;
    @Column(name = "supperNumber")
    private int supperNumber = 0;
    @Column(name = "transportType")
    private TransportType transportType;
    @Column(name = "autoCapacity")
    private AutoCapacity autoCapacity;
    @Column(name = "km")
    private int km;
    @Column(name = "accommodationPrice")
    private int accommodationPrice;
    @Column(name = "ticketsPrice")
    private int TicketsPrice;
    @Column(name = "otherOutlayDesc")
    private String otherOutlayDesc;
    @Column(name = "otherOutlayPrice")
    private int otherOutlayPrice;

}
