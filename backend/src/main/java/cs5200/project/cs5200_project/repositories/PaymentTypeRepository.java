package cs5200.project.cs5200_project.repositories;

import org.springframework.data.repository.CrudRepository;

import cs5200.project.cs5200_project.models.Payment_type;

public interface PaymentTypeRepository extends CrudRepository<Payment_type, Integer> {
}
