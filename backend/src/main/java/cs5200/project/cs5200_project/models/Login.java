package cs5200.project.cs5200_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "username")
  private String userName;
  @Column(name = "password")
  private String password;

  @OneToOne
  private Person person;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @JsonIgnore
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
    if(person.getLogin() != this){
      person.setLogin(this);
    }
  }
}
