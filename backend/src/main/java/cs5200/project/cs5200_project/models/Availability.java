package cs5200.project.cs5200_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "availabilities")
public class Availability {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "d_from")
  Date from;

  @Column(name = "d_to")
  Date to;

  @ManyToOne
  Property property;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getFrom() {
    return from;
  }

  public void setFrom(Date from) {
    this.from = from;
  }

  public Date getTo() {
    return to;
  }

  public void setTo(Date to) {
    this.to = to;
  }

  @JsonIgnore
  public Property getProperty() {
    return property;
  }

  public void setProperty(Property property) {
    this.property = property;
    if (!property.getAvailabilities().contains(this)) {
      property.setAvailabilities(this);
    }
  }
}
