package cs5200.project.cs5200_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import cs5200.project.cs5200_project.models.Availability;
import cs5200.project.cs5200_project.models.Property;

public interface AvailabilityRepository extends CrudRepository<Availability, Integer> {

  @Query(value = "select a from Availability a where a.property =:property")
  Iterable<Availability> findAvailability(@Param("property") Property property);


}
