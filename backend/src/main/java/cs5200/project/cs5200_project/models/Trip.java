package cs5200.project.cs5200_project.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "trips")
public class Trip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "start")
  private Date start;

  @Column(name = "end")
  private Date end;

  @OneToOne(mappedBy = "trip")
  private Payment_detail payment_detail;

  @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
  private Collection<Review> review;

  @ManyToOne
  private Property property;

  @ManyToOne
  private Guest guest;

  @ManyToMany
  @JoinTable(name = "invitees",
          joinColumns = @JoinColumn(name = "trip_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "invitee_id", referencedColumnName = "id"))
  private Collection<Guest> guests;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public Payment_detail getPayment_detail() {
    return payment_detail;
  }

  public void setPayment_detail(Payment_detail payment_detail) {
    this.payment_detail = payment_detail;
    if (payment_detail.getTrip() != this) {
      payment_detail.setTrip(this);
    }
  }

  public Collection<Review> getReview() {
    return review;
  }

  public void setReview(Review review) {
    this.review.add(review);
    if (review.getTrip() != this) {
      review.setTrip(this);
    }
  }

  @JsonIgnore
  public Property getProperty() {
    return property;
  }

  public void setProperty(Property property) {
    this.property = property;
    if (!property.getTrips().contains(this)) {
      property.setTrips(this);
    }
  }

  @JsonIgnore
  public Guest getGuest() {
    return guest;
  }

  public void setGuest(Guest guest) {
    this.guest = guest;
    if (!guest.getTrips().contains(this)) {
      guest.setTrips(this);
    }
  }


  public Collection<Guest> getGuests() {
    return guests;
  }

  public void setGuests(Guest guest) {
    this.guests.add(guest);
    if (!guest.getCoTrip().contains(this)) {
      guest.setCoTrip(this);
    }
  }

  public void set(Trip newTrip) {
    if (newTrip.getEnd() != null) {
      this.end = newTrip.end;
    }
    if (newTrip.getStart() != null) {
      this.start = Date.valueOf(newTrip.getStart().toLocalDate().plusDays(1));
    }
  }
}
