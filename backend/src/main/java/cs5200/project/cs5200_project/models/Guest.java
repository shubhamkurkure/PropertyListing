package cs5200.project.cs5200_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "guests")
public class Guest extends Person {
  @Column(name = "verified")
  private Boolean verified;

  @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
  private List<Trip> trips;

  @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
  private List<Review> reviews;

  @Column(name = "type")
  private String type;

  @ManyToMany(mappedBy = "guests")
  private List<Trip> coTrip;

  @JsonIgnore
  public List<Trip> getCoTrip() {
    return coTrip;
  }

  public void setCoTrip(Trip coTrip) {
    this.coTrip.add(coTrip);
    if (!coTrip.getGuests().contains(this)) {
      coTrip.setGuests(this);
    }
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getVerified() {
    return verified;
  }

  public void setVerified(Boolean verified) {
    this.verified = verified;
  }

  @JsonIgnore
  public List<Trip> getTrips() {
    return trips;
  }

  public void setTrips(Trip trip) {
    this.trips.add(trip);
    if (trip.getGuest() != this) {
      trip.setGuest(this);
    }
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(Review review) {
    this.reviews.add(review);
    if (review.getGuest() != this) {
      review.setGuest(this);
    }
  }

  public void set(Guest newGuest) {
    if (newGuest.getFirstName() != null) {
      this.firstName = newGuest.getFirstName();
    }
    if (newGuest.getLastName() != null) {
      this.lastName = newGuest.getLastName();
    }
    if (newGuest.email != null) {
      this.email = newGuest.getEmail();
    }
    if (newGuest.getGender() != null) {
      this.gender = newGuest.getGender();
    }
    if (newGuest.getVerified() != this.verified) {
      this.verified = newGuest.getVerified();
    }
  }

}
