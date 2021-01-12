package cs5200.project.cs5200_project.repositories;

import cs5200.project.cs5200_project.models.Guest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.models.Trip;

import javax.websocket.server.PathParam;

public interface TripRepository extends CrudRepository<Trip, Integer> {

  @Query(value = "Select a from Trip a where a.guest = :guest")
  Iterable<Trip> findTripOfGuest(@Param("guest") Guest guest);

  @Query(value = "Select a from Trip a where a.property = :property")
  Iterable<Trip> findPropertyTrips(@Param("property") Property property);

  @Query(value = "Select a from Trip a where a.property in :properties")
  Iterable<Trip> findAllPropertyTrips(@Param("properties") Iterable<Property> properties);
}
