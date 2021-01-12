package cs5200.project.cs5200_project.Controller;

import cs5200.project.cs5200_project.services.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cs5200.project.cs5200_project.models.Address;

@RestController
@CrossOrigin(origins = "*")
public class AddressController {

  @Autowired
  private AddressService addressService;

  @GetMapping("/api/address")
  public Iterable<Address> getAddress() {
    return addressService.getAddress();
  }

  @PostMapping("/api/person/{id}/address")
  public Address createAddress(@PathVariable int id, @RequestBody Address address) {
    return addressService.createAddress(id, address);
  }

  @GetMapping("/api/person/{id}/address")
  public Iterable<Address> getAddressOfPerson(@PathVariable int id) {
    return addressService.getAddressOfPerson(id);
  }
}
