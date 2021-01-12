package cs5200.project.cs5200_project.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "hosts")
public class Host extends Person {
  @Column(name = "superhost")
  private Boolean superHost;

  @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
  private Collection<Property> properties;

  @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
  private List<Review> reviews;

  @Column(name = "type")
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getSuperHost() {
    return superHost;
  }

  public void setSuperHost(Boolean superHost) {
    this.superHost = superHost;
  }

  public Collection<Property> getProperties() {
    return properties;
  }

  public void setProperties(Property property) {
    this.properties.add(property);
    if (property.getHost() != this) {
      property.setHost(this);
    }
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(Review review) {
    this.reviews.add(review);
    if (review.getHost() != this) {
      review.setHost(this);
    }
  }

  public void set(Host newHost) {
    if (newHost.getFirstName() != null) {
      this.firstName = newHost.getFirstName();
    }
    if (newHost.getLastName() != null) {
      this.lastName = newHost.getLastName();
    }
    if (newHost.email != null) {
      this.email = newHost.getEmail();
    }
    if (newHost.getGender() != null) {
      this.gender = newHost.getGender();
    }
    if (newHost.getSuperHost() != this.superHost) {
      this.superHost = newHost.getSuperHost();
    }
  }
}
