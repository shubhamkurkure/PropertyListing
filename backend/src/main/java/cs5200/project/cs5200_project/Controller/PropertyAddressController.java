package cs5200.project.cs5200_project.Controller;

import cs5200.project.cs5200_project.models.Property_address;
import cs5200.project.cs5200_project.services.PropertyAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PropertyAddressController {

  @Autowired
  private PropertyAddressService propertyAddressService;

  @PostMapping("/api/property/{id}/address")
  public Property_address createAddress(@PathVariable int id, @RequestBody Property_address property_address) {
    return propertyAddressService.createPropertyAddress(id, property_address);
  }

  @GetMapping("/api/property/{id}/address")
  public Property_address getAddressOfProperty(@PathVariable int id) {
    return propertyAddressService.getAddressOfProperty(id);
  }
}
