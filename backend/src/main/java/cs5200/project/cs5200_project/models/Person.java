package cs5200.project.cs5200_project.models;

import javax.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  @Column(name = "first_name")
  protected String firstName;

  @Column(name = "last_name")
  protected String lastName;

  @Column(name = "gender")
  protected String gender;

  @Column(name = "email")
  protected String email;

  @Column(name = "dob")
  protected Date dob;

  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
  protected Collection<Phone> phones;

  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
  protected Collection<Address> addresses;

  @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
  protected Login login;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public Collection<Phone> getPhones() {
    return phones;
  }

  public void setPhones(Collection<Phone> phones) {
    this.phones = phones;
  }

  public Collection<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Collection<Address> addresses) {
    this.addresses = addresses;
  }

  public Login getLogin() {
    return login;
  }

  public void setLogin(Login login) {
    this.login = login;
    if(login.getPerson() != this){
      login.setPerson(this);
    }
  }
}
