package cs5200.project.cs5200_project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends Person {

  @Column(name = "type")
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void set(Admin newAdmin) {
    if (newAdmin.getFirstName() != null) {
      this.firstName = newAdmin.getFirstName();
    }
    if (newAdmin.getLastName() != null) {
      this.lastName = newAdmin.getLastName();
    }
    if (newAdmin.email != null) {
      this.email = newAdmin.getEmail();
    }
    if (newAdmin.getGender() != null) {
      this.gender = newAdmin.getGender();
    }
  }
}
