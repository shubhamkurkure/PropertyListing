package cs5200.project.cs5200_project.repositories;

import cs5200.project.cs5200_project.models.Host;
import cs5200.project.cs5200_project.models.Property_address;

import cs5200.project.cs5200_project.models.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Property;

public interface PropertyRepository extends CrudRepository<Property, Integer> {

  @Query(value = "select p from Property p where p.host =:host")
  Iterable<Property> findPropertyByHost(@Param("host") Host host);

  @Query(value = "select p from Property p where p.property_address in " +
          "(select padd from Property_address padd where padd.city =:location )")
  Iterable<Property> findPropertyByLocation(@Param("location") String location);

    @Query(value ="select t.property from Trip t where t =:trip")
    Property findPropertyByTrip(Trip trip);
}