package DelegationService.Model;

import DelegationService.Other.AutoCapacity;
import DelegationService.Other.TransportType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "\"Delegation\"")
@Getter
@Setter
public class Delegation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "idDelegation")
    private Integer idDelegation;

    @Column(name = "description")
    private String description;

    @Column(name = "dateTimeStart", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTimeStart;

    @Column(name = "dateTimeStop", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTimeStop;

    @Column(name = "travelDietAmount")
    private Integer travelDietAmount = 30;

    @Column(name = "breakfastNumber")
    private Integer breakfastNumber = 0;

    @Column(name = "dinnerNumber")
    private Integer dinnerNumber = 0;

    @Column(name = "supperNumber")
    private Integer supperNumber = 0;

    @Column(name = "transportType")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    @Column(name = "ticketPrice")
    private Float ticketPrice;

    @Column(name = "autoCapacity")
    @Enumerated(EnumType.STRING)
    private AutoCapacity autoCapacity;

    @Column(name = "km")
    private Float km;

    @Column(name = "accomodationPrice")
    private Float accomodationPrice;

    @Column(name = "otherticketsPrice")
    private Float otherTicketsPrice;

    @Column(name = "otherOutlayDesc")
    private String otherOutlayDesc;

    @Column(name = "otherOutlayPrice")
    private Float otherOutlayPrice;

    public Delegation(){}

    public Delegation(String description, Date dateTimeStart, Date dateTimeStop){
        this.description = description;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeStop = dateTimeStop;
    }

}
