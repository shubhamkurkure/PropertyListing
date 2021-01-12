package cs5200.project.cs5200_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "url")
  String url;

  @Column(name = "type")
  String type;

  @ManyToOne
  Property property;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @JsonIgnore
  public Property getProperty() {
    return property;
  }

  public void setProperty(Property property) {
    this.property = property;
    if (!property.getImages().contains(this)) {
      property.setImages(this);
    }
  }
}
