package cs5200.project.cs5200_project.Controller;

import cs5200.project.cs5200_project.services.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cs5200.project.cs5200_project.models.Phone;

@RestController
@CrossOrigin(origins = "*")
public class PhoneController {

  @Autowired
  private PhoneService phoneService;


  @GetMapping("/api/phone")
  public Iterable<Phone> findPhoneNos() {
    return phoneService.findPhoneNos();
  }

  @PostMapping("/api/person/{id}/phone")
  public Phone createPhoneNoOfPerson(@PathVariable int id, @RequestBody Phone phone) {
    return phoneService.createPhoneNoOfPerson(id, phone);
  }

  @GetMapping("/api/person/{id}/phone")
  public Iterable<Phone> findPhoneNoOfPerson(@PathVariable int id) {
    return phoneService.findPhoneNoOfPerson(id);
  }

}
