package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Image;
import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.repositories.ImagesRepository;
import cs5200.project.cs5200_project.repositories.PropertyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

  @Autowired
  private ImagesRepository imagesRepository;

  @Autowired
  private PropertyRepository propertyRepository;

  public Image createImage(int id, Image image) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      property.setImages(image);
      propertyRepository.save(property);
      return image;
    }

    return null;
  }


  public Iterable<Image> getImagesOfProperty(int id) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      return imagesRepository.findImagesOfProperty(property);
    }
    return null;
  }
}
