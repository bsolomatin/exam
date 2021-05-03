package com.bsolomatin.bookingshotel.domain;

import org.joda.time.DateMidnight;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import javax.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.StringJoiner;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@Column(name="Id", unique = true, nullable = false)
    private Long Id;
    boolean isConfirm;
    LocalDate checkIn;
    LocalDate checkOut;
    Interval interval;
//    @ManyToOne
//    private Room room;
//    @ManyToOne
//    private User user;

    public Booking() { } //For JPA Entity;

    public Booking(LocalDate checkIn, LocalDate checkOut, boolean isConfirm) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.isConfirm = isConfirm;
        interval = new Interval(new DateMidnight(checkIn), new DateMidnight(checkOut));
    }

    public void setId(Long id) {
        this.Id = id;
    }

    @Id
    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|", "Booking [", "]");
        joiner.add("Id =" + Id).add("Check in date = " + checkIn).add("Check out date = "+checkOut).add("Confirm = " + isConfirm);
        return joiner.toString();
    }
}
