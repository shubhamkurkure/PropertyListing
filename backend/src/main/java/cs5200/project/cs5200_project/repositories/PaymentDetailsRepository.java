package cs5200.project.cs5200_project.repositories;

import cs5200.project.cs5200_project.models.Payment_detail;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Property_address;
import cs5200.project.cs5200_project.models.Trip;

public interface PaymentDetailsRepository extends CrudRepository<Payment_detail, Integer> {

  @Query(value = "select pd from Payment_detail pd where pd.trip =:trip")
  Payment_detail getPaymentDetails(@Param("trip") Trip trip);
}
