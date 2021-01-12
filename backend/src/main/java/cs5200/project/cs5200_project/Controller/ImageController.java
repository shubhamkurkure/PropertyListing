package cs5200.project.cs5200_project.Controller;

import cs5200.project.cs5200_project.models.Image;
import cs5200.project.cs5200_project.services.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ImageController {

  @Autowired
  private ImageService imageService;

  @PostMapping("/api/property/{id}/image")
  public Image createImage(@PathVariable int id, @RequestBody Image image) {
    return imageService.createImage(id, image);
  }

  @GetMapping("/api/property/{id}/image")
  public Iterable<Image> getImagesOfProperty(@PathVariable int id) {
    return imageService.getImagesOfProperty(id);
  }

}
