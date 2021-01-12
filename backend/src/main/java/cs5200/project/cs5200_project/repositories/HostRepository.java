package cs5200.project.cs5200_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Guest;
import cs5200.project.cs5200_project.models.Host;

public interface HostRepository extends CrudRepository<Host, Integer> {

  @Query(value = "select h from Host h where h.id = " +
          "(select p.id from Person p, Login l where p.login = l.person and l.userName =:name)")
  Host findByUsername(@Param("name") String name);
}
