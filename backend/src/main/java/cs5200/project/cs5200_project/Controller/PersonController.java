package cs5200.project.cs5200_project.Controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import cs5200.project.cs5200_project.models.Guest;
import cs5200.project.cs5200_project.models.GuestCreate;
import cs5200.project.cs5200_project.models.HostCreate;
import cs5200.project.cs5200_project.models.PersonCreate;
import cs5200.project.cs5200_project.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cs5200.project.cs5200_project.models.Host;
import cs5200.project.cs5200_project.models.Person;

@RestController
@CrossOrigin(origins = "*")
public class PersonController {

  @Autowired
  private PersonService personService;


  @GetMapping("/person")
  public Iterable<Person> findAllPerson() {
    return personService.findAllPerson();
  }

  @PostMapping("/person")
  public Person createPerson(@RequestBody PersonCreate person) {
    return personService.createPerson(person);
  }

  @GetMapping("/person/{id}")
  public Person findPersonById(@PathVariable int id) {
    return personService.findPersonById(id);
  }

  @DeleteMapping("/person/{id}")
  public int deletePersonById(@PathVariable int id) {
    return personService.deletePersonById(id);
  }

  @PostMapping("/api/host")
  public Host createHost(@RequestBody HostCreate host) {
    return personService.createHost(host);
  }

  @PostMapping("/api/guest")
  public Guest createGuest(@RequestBody GuestCreate guest) {
    return personService.createGuest(guest);
  }

  @GetMapping("/api/host")
  public Iterable<Host> getHosts() {
    return personService.findAllHosts();
  }

  @GetMapping("/api/guest")
  public Iterable<Guest> getGuests() {
    return personService.findAllGuests();
  }

  @GetMapping("/api/guest/{name}")
  public Guest findGuestByUsername(@PathVariable("name") String name) {
    return personService.findGuestByUsername(name);
  }

  @GetMapping("/api/host/{name}")
  public Host findHostByUsername(@PathVariable("name") String name) {
    return personService.findHostByUsername(name);
  }

  @PutMapping("/api/host/{id}")
  public Host updateHost(@PathVariable int id, @RequestBody Host host) {
    return personService.updateHost(id, host);
  }

  @PutMapping("/api/guest/{id}")
  public Guest updateGuest(@PathVariable int id, @RequestBody Guest guest) {
    return personService.updateGuest(id, guest);
  }

  @DeleteMapping("/api/host/{id}")
  public int deleteHost(@PathVariable int id) {
    return personService.deleteHost(id);
  }

  @DeleteMapping("/api/guest/{id}")
  public int deleteGuest(@PathVariable int id) {
    return personService.deleteGuest(id);
  }

  @GetMapping("/api/host/id/{id}")
  public Host getHostbyId(@PathVariable int id) {
    return personService.getHost(id);
  }

  @GetMapping("/api/guest/id/{id}")
  public Guest getGuestbyId(@PathVariable int id) {
    return personService.getGuest(id);
  }
}
