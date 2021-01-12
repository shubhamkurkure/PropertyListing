package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Host;
import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.repositories.HostRepository;
import cs5200.project.cs5200_project.repositories.PropertyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Service
public class PropertyService {

  @Autowired
  private PropertyRepository propertyRepository;

  @Autowired
  private HostRepository hostRepository;


  public Iterable<Property> findAllProperty() {
    return propertyRepository.findAll();
  }


  public Property createProperty(int id, Property property) {
    //System.out.println("_________________________________________"+hostRepository.findById(id).isPresent());
    if (hostRepository.findById(id).isPresent()) {
      Host host = hostRepository.findById(id).get();
      property.setHost(host);
      return propertyRepository.save(property);
    }

    return null;
  }


  public Property findPropertyById(int id) {
    if (propertyRepository.findById(id).isPresent()) {
      return propertyRepository.findById(id).get();
    }
    return null;
  }


  public int deletePropertyById(int id) {
    if (propertyRepository.findById(id).isPresent()) {
      propertyRepository.deleteById(id);
      return 1;
    }
    return 0;
  }

  public Property updateProperty(int id, Property newProperty) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      property.set(newProperty);
      return propertyRepository.save(property);
    }

    return null;
  }

  public Iterable<Property> findPersonProperty(int id) {
    if (hostRepository.findById(id).isPresent()) {
      Host host = hostRepository.findById(id).get();
      return propertyRepository.findPropertyByHost(host);
    }

    return null;
  }

  public Iterable<Property> findPersonPropertyByName(String name) {
    Host host = hostRepository.findByUsername(name);
    if (host != null) {
      return propertyRepository.findPropertyByHost(host);
    }
    return new ArrayList<>();
  }

  public Iterable<Property> findPropertyByLocation(String location) {
    return propertyRepository.findPropertyByLocation(location);
  }

  public Host findHostByProperty(int id) {
    if (propertyRepository.findById(id).isPresent()) {
      return propertyRepository.findById(id).get().getHost();
    }

    return null;
  }

  public Property createSubProperty(int id, Property subProperty) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      subProperty.setSub_property(property);
      return propertyRepository.save(subProperty);
    }

    return null;
  }

  public Property assignSubProperty(int pid, int sid) {
    if (propertyRepository.findById(pid).isPresent() && propertyRepository.findById(sid).isPresent()) {
      Property property = propertyRepository.findById(pid).get();
      Property subProperty = propertyRepository.findById(sid).get();
      subProperty.setSub_property(property);
      return propertyRepository.save(subProperty);
    }

    return null;
  }
}
