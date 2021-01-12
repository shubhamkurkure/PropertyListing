package cs5200.project.cs5200_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cs5200.project.cs5200_project.models.Availability;
import cs5200.project.cs5200_project.services.AvailabilityService;

@RestController
@CrossOrigin(origins = "*")
public class AvailabilityController {

  @Autowired
  AvailabilityService availabilityService;

  @GetMapping("/api/property/{id}/availability")
  public Iterable<Availability> getAvailabilities(@PathVariable("id") int id) {
    return availabilityService.getAvailabilities(id);
  }

  @PostMapping("/api/property/{id}/availability")
  public Availability createAvailabilities(@PathVariable("id") int id,
                                           @RequestBody Availability availability) {
    return availabilityService.createAvailabilities(id, availability);
  }
}
