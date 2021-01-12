package cs5200.project.cs5200_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
public class Property {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "price")
  private int price;

  @Column(name = "name")
  private String name;

  @OneToOne
  private Property_type property_type;

  @Column(name = "no_of_rooms")
  private int noOfRooms;

  @Column(name = "verified")
  private boolean verified;

  @Column(name = "max_no_of_person")
  private int maxNoOfPerson;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
  private Collection<Image> images;

  @OneToOne(mappedBy = "property", cascade = CascadeType.ALL)
  private Property_address property_address;

  @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
  private Collection<Availability> availabilities;

  @OneToMany(mappedBy = "sub_property", cascade = CascadeType.ALL)
  private Collection<Property> sub_properties;

  @ManyToOne
  private Property sub_property;

  @ManyToOne
  private Host host;

  @OneToMany(mappedBy = "property")
  private Collection<Trip> trips;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Property_type getProperty_type() {
    return property_type;
  }

  public void setProperty_type(Property_type property_type) {
    this.property_type = property_type;
  }

  public int getNoOfRooms() {
    return noOfRooms;
  }

  public void setNoOfRooms(int noOfRooms) {
    this.noOfRooms = noOfRooms;
  }

  public boolean isVerified() {
    return verified;
  }

  public void setVerified(boolean verified) {
    this.verified = verified;
  }

  public int getMaxNoOfPerson() {
    return maxNoOfPerson;
  }

  public void setMaxNoOfPerson(int maxNoOfPerson) {
    this.maxNoOfPerson = maxNoOfPerson;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @JsonIgnore
  public Collection<Image> getImages() {
    return images;
  }

  public void setImages(Image image) {
    this.images.add(image);
    if (image.getProperty() != this) {
      image.setProperty(this);
    }
  }

  @JsonIgnore
  public Property_address getProperty_address() {
    return property_address;
  }

  public void setProperty_addresses(Property_address property_address) {
    this.property_address = property_address;
    if (property_address.getProperty() != this) {
      property_address.setProperty(this);
    }
  }

  @JsonIgnore
  public Collection<Availability> getAvailabilities() {
    return availabilities;
  }

  public void setAvailabilities(Availability availability) {
    this.availabilities.add(availability);
    if (availability.getProperty() != this) {
      availability.setProperty(this);
    }
  }

  public Collection<Property> getSub_properties() {
    return sub_properties;
  }

  public void setSub_properties(Property sub_property) {
    this.sub_properties.add(sub_property);
    if (sub_property.getSub_property() != this) {
      sub_property.setSub_property(this);
    }
  }

  @JsonIgnore
  public Property getSub_property() {
    return sub_property;
  }

  public void setSub_property(Property sub_property) {
    this.sub_property = sub_property;
    if (!sub_property.getSub_properties().contains(this)) {
      sub_property.setSub_properties(this);
    }
  }

  @JsonIgnore
  public Host getHost() {
    return host;
  }

  public void setHost(Host host) {
    this.host = host;
    if (!host.getProperties().contains(this)) {
      host.setProperties(this);
    }
  }

  @JsonIgnore
  public Collection<Trip> getTrips() {
    return trips;
  }

  public void setTrips(Trip trip) {
    this.trips.add(trip);
    if (trip.getProperty() != this) {
      trip.setProperty(this);
    }
  }

  public void set(Property newProperty) {
    if (newProperty.description != null) {
      this.description = newProperty.getDescription();
    }
    if (newProperty.price != 0) {
      this.price = newProperty.price;
    }
    if (newProperty.name != null) {
      this.name = newProperty.getName();
    }
  }
}
