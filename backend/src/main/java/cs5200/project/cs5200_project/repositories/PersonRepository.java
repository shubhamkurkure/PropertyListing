package cs5200.project.cs5200_project.repositories;

import org.springframework.data.repository.CrudRepository;

import cs5200.project.cs5200_project.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
