package cs5200.project.cs5200_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;

import cs5200.project.cs5200_project.models.Login;
import cs5200.project.cs5200_project.models.Person;

public interface LoginRepository extends CrudRepository<Login, Integer> {

  @Query(value = "select l from Login l where l.person = :person")
  Login findLoginForPerson(@PathParam("person") Person person);

  @Query(value = "select l from Login l where l.userName =:username")
  Login findLoginByUsername(@Param("username") String username);
}
