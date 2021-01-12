package cs5200.project.cs5200_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs5200.project.cs5200_project.models.Availability;
import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.repositories.AvailabilityRepository;
import cs5200.project.cs5200_project.repositories.PropertyRepository;

@Service
public class AvailabilityService {

  @Autowired
  AvailabilityRepository availabilityRepository;

  @Autowired
  PropertyRepository propertyRepository;

  public Iterable<Availability> getAvailabilities(int id) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      return availabilityRepository.findAvailability(property);
    }

    return null;
  }


  public Availability createAvailabilities(int id, Availability availability) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      availability.setProperty(property);
      return availabilityRepository.save(availability);
    }

    return null;
  }
}
