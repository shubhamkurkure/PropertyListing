package cs5200.project.cs5200_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Person;
import cs5200.project.cs5200_project.models.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

  @Query(value = "select phone from Phone phone where phone.person = :person")
  public Iterable<Phone> findPhoneNoOfPerson(@Param("person") Person person);
}
