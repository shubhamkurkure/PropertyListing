package cs5200.project.cs5200_project.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "payment_details")
public class Payment_detail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne
  private Payment_type payment_type;

  @Column(name = "payment_date")
  private Date payment_date;

  @Column(name = "amount")
  private int amount;

  @OneToOne
  private Trip trip;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Payment_type getPayment_type() {
    return payment_type;
  }

  public void setPayment_type(Payment_type payment_type) {
    this.payment_type = payment_type;
  }

  public Date getPayment_date() {
    return payment_date;
  }

  public void setPayment_date(Date payment_date) {
    this.payment_date = payment_date;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @JsonIgnore
  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
    if (trip.getPayment_detail() != this) {
      trip.setPayment_detail(this);
    }
  }
}
