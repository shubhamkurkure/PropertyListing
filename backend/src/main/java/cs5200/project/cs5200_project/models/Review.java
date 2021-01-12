package cs5200.project.cs5200_project.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "guest_review")
  private String guest_review;

  @Column(name = "property_review")
  private String property_review;

  @Column(name = "host_review")
  private String host_review;

  @Column(name = "host_rating")
  private int host_rating;

  @Column(name = "guest_rating")
  private int guest_rating;

  @Column(name = "property_rating")
  private int property_rating;

  @ManyToOne
  private Trip trip;

  @ManyToOne
  private Guest guest;

  @ManyToOne
  private Host host;

  @Column(name = "given_by")
  private String given_by;

  public String getGiven_by() {
    return given_by;
  }

  public void setGiven_by(String given_by) {
    this.given_by = given_by;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGuest_review() {
    return guest_review;
  }

  public void setGuest_review(String guest_review) {
    this.guest_review = guest_review;
  }

  public String getProperty_review() {
    return property_review;
  }

  public void setProperty_review(String property_review) {
    this.property_review = property_review;
  }

  public String getHost_review() {
    return host_review;
  }

  public void setHost_review(String host_review) {
    this.host_review = host_review;
  }

  public int getHost_rating() {
    return host_rating;
  }

  public void setHost_rating(int host_rating) {
    this.host_rating = host_rating;
  }

  public int getGuest_rating() {
    return guest_rating;
  }

  public void setGuest_rating(int guest_rating) {
    this.guest_rating = guest_rating;
  }

  public int getProperty_rating() {
    return property_rating;
  }

  public void setProperty_rating(int property_rating) {
    this.property_rating = property_rating;
  }

  @JsonIgnore
  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip_id) {
    this.trip = trip_id;
    if (!trip.getReview().contains(this)) {
      trip.setReview(this);
    }
  }

  @JsonIgnore
  public Guest getGuest() {
    return guest;
  }

  public void setGuest(Guest guest) {
    this.guest = guest;
    if (!guest.getReviews().contains(this)) {
      guest.setReviews(this);
    }
  }

  @JsonIgnore
  public Host getHost() {
    return host;
  }

  public void setHost(Host host) {
    this.host = host;
    if (!host.getReviews().contains(this)) {
      host.setReviews(this);
    }
  }
}
