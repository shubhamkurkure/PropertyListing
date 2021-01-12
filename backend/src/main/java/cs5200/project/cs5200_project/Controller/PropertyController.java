package cs5200.project.cs5200_project.Controller;

import cs5200.project.cs5200_project.models.Host;
import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.services.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PropertyController {

  @Autowired
  private PropertyService propertyService;

  @GetMapping("/property")
  public Iterable<Property> findAllProperty() {
    return propertyService.findAllProperty();
  }

  @PostMapping("/person/{id}/property")
  public Property createProperty(@PathVariable int id, @RequestBody Property property) {
    return propertyService.createProperty(id, property);
  }

  @GetMapping("/property/{id}")
  public Property findPropertyById(@PathVariable int id) {
    return propertyService.findPropertyById(id);
  }

  @DeleteMapping("/property/{id}")
  public int deletePropertyById(@PathVariable int id) {
    return propertyService.deletePropertyById(id);
  }

  @PutMapping("/property/{id}")
  public Property updateProperty(@PathVariable int id, @RequestBody Property property) {
    return propertyService.updateProperty(id, property);
  }

  @GetMapping("/person/{id}/property")
  public Iterable<Property> findPersonProperty(@PathVariable int id) {
    return propertyService.findPersonProperty(id);
  }

  @GetMapping("/person/name/{name}/property")
  public Iterable<Property> findPersonPropertyByName(@PathVariable String name) {
    return propertyService.findPersonPropertyByName(name);
  }

  @GetMapping("/api/property/{location}/propertyAddress")
  public Iterable<Property> findPropertyByLocation(@PathVariable String location) {
    return propertyService.findPropertyByLocation(location);
  }

  @GetMapping("/api/property/{id}/host")
  public Host findHostByProperty(@PathVariable("id") int id) {
    return propertyService.findHostByProperty(id);
  }

  @PostMapping("/api/property/{id}/subproperty")
  public Property createSubProperty(@PathVariable int id, @RequestBody Property subProperty) {
    return propertyService.createSubProperty(id, subProperty);
  }

  @PutMapping("/api/property/{pid}/subproperty/{sid}")
  public Property assignSubProperty(@PathVariable int pid, @PathVariable int sid) {
    return propertyService.assignSubProperty(pid, sid);
  }

}
