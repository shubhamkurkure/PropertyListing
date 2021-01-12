package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.models.Property_address;
import cs5200.project.cs5200_project.repositories.PropertyAddressRepository;
import cs5200.project.cs5200_project.repositories.PropertyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyAddressService {

  @Autowired
  private PropertyAddressRepository propertyAddressRepository;

  @Autowired
  private PropertyRepository propertyRepository;

  public Property_address createPropertyAddress(int id, Property_address property_address) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      property.setProperty_addresses(property_address);
      propertyRepository.save(property);
      return property_address;
    }

    return null;
  }


  public Property_address getAddressOfProperty(int id) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      return propertyAddressRepository.findAddressOfProperty(property);
    }

    return null;
  }


}
