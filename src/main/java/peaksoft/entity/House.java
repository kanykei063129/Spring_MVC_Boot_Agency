package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Country;
import peaksoft.enums.HouseType;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_gen")
    @SequenceGenerator(name = "house_gen", sequenceName = "house_seq", allocationSize = 1)
    private Long id;
    @Column(name = "house_type")
    private HouseType houseType;
    private String address;
    private int price;
    private int room;
    private Country country;
    private String description;
    private Boolean isBooked;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private Agency agency;
    @OneToOne(mappedBy = "house", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private Booking booking;

    public House(HouseType houseType, String address, int price, int room, Country country, String description, Boolean isBooked, Agency agency, Booking booking) {
        this.houseType = houseType;
        this.address = address;
        this.price = price;
        this.room = room;
        this.country = country;
        this.description = description;
        this.isBooked = isBooked;
        this.agency = agency;
        this.booking = booking;
    }
}
