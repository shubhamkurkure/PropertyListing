package cs5200.project.cs5200_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Guest;
import cs5200.project.cs5200_project.models.Host;
import cs5200.project.cs5200_project.models.Review;
import cs5200.project.cs5200_project.models.Trip;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

  @Query(value = "select r from Review r where r.guest=:guest and r.given_by='Guest'")
  Iterable<Review> findGuestReviews(@Param("guest") Guest guest);

  @Query(value = "select r from Review r where r.trip=:trip")
  Iterable<Review> findTripReviews(@Param("trip") Trip trip);

  @Query(value = "select r from Review r where r.host=:host and r.given_by='Host'")
  Iterable<Review> findHostReviews(@Param("host") Host host);
}
