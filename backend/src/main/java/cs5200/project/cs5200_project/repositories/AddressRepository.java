package cs5200.project.cs5200_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.websocket.server.PathParam;

import cs5200.project.cs5200_project.models.Address;
import cs5200.project.cs5200_project.models.Person;

public interface AddressRepository extends CrudRepository<Address, Integer> {

  @Query(value = "Select a from Address a where a.person = :person")
  Iterable<Address> findAddressOfPerson(@PathParam("person") Person person);
}
