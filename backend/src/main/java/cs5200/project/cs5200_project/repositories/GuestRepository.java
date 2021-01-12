package cs5200.project.cs5200_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Guest;

public interface GuestRepository extends CrudRepository<Guest, Integer> {

  @Query(value = "select g from Guest g where g.id = " +
          "(select p.id from Person p, Login l where p.login = l.person and l.userName =:name)")
  Guest findByUsername(@Param("name") String name);
}
