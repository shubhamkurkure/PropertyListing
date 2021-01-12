package cs5200.project.cs5200_project.models;


import javax.persistence.*;

@Entity
@Table(name = "payment_types")
public class Payment_type {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "type")
  private String type;

  @OneToOne(mappedBy = "payment_type")
  private Payment_detail payment_detail;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Payment_detail getPayment_detail() {
    return payment_detail;
  }

  public void setPayment_detail(Payment_detail payment_detail) {
    this.payment_detail = payment_detail;
  }
}
