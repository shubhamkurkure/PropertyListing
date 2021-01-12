package cs5200.project.cs5200_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Admin;
import cs5200.project.cs5200_project.models.Login;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

  @Query(value = "select a from Admin a where a.id = " +
          "(select p.id from Person p, Login l where p.login = l.person and l.userName =:username)")
  Admin findByUsername(@Param("username") String username);
}
