package cs5200.project.cs5200_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property_address")
public class Property_address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "latitude")
  private int latitude;

  @Column(name = "longitude")
  private int longitude;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "country")
  private String country;

  @Column(name = "address")
  private String address;

  @OneToOne
  private Property property;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getLatitude() {
    return latitude;
  }

  public void setLatitude(int latitude) {
    this.latitude = latitude;
  }

  public int getLongitude() {
    return longitude;
  }

  public void setLongitude(int longitude) {
    this.longitude = longitude;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @JsonIgnore
  public Property getProperty() {
    return property;
  }

  public void setProperty(Property property) {
    this.property = property;
    if (property.getProperty_address() != this) {
      property.setProperty_addresses(this);
    }
  }
}
