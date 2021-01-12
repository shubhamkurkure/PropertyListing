package cs5200.project.cs5200_project.repositories;

import cs5200.project.cs5200_project.models.Property;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cs5200.project.cs5200_project.models.Image;

import javax.websocket.server.PathParam;

public interface ImagesRepository extends CrudRepository<Image, Integer> {

  @Query(value = "Select a from Image a where a.property = :property")
  Iterable<Image> findImagesOfProperty(@Param("property") Property property);
}
