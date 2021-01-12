package cs5200.project.cs5200_project.repositories;

import cs5200.project.cs5200_project.models.Address;
import cs5200.project.cs5200_project.models.Person;
import cs5200.project.cs5200_project.models.Property;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Property_address;

import javax.websocket.server.PathParam;

public interface PropertyAddressRepository extends CrudRepository<Property_address, Integer> {

  @Query(value = "Select a from Property_address a where a.property = :property")
  Property_address findAddressOfProperty(@Param("property") Property property);

}
