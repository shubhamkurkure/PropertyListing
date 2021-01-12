package cs5200.project.cs5200_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "address")
  private String address;

  @Column(name = "city")
  private String city;

  @Column(name = "zip")
  private int zip;

  @Column(name = "state")
  private String state;

  @Column(name = "country")
  private String country;

  @Column(name = "is_primary")
  private Boolean primary;

  @ManyToOne
  private Person person;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip = zip;
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

  public Boolean getPrimary() {
    return primary;
  }

  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }

  @JsonIgnore
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
