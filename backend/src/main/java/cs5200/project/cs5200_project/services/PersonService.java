package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Guest;
import cs5200.project.cs5200_project.models.GuestCreate;
import cs5200.project.cs5200_project.models.Host;
import cs5200.project.cs5200_project.models.HostCreate;
import cs5200.project.cs5200_project.models.Person;
import cs5200.project.cs5200_project.models.PersonCreate;
import cs5200.project.cs5200_project.repositories.AddressRepository;
import cs5200.project.cs5200_project.repositories.GuestRepository;
import cs5200.project.cs5200_project.repositories.HostRepository;
import cs5200.project.cs5200_project.repositories.LoginRepository;
import cs5200.project.cs5200_project.repositories.PersonRepository;
import cs5200.project.cs5200_project.repositories.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private HostRepository hostRepository;

  @Autowired
  private GuestRepository guestRepository;

  @Autowired
  private PhoneService phoneService;

  @Autowired
  private LoginService loginService;

  @Autowired
  private AddressService addressService;

  public Iterable<Person> findAllPerson() {
    return personRepository.findAll();
  }

  public Person findPersonById(int id) {
    if (personRepository.findById(id).isPresent()) {
      return personRepository.findById(id).get();
    }
    return null;
  }

  public Person createPerson(PersonCreate person) {
    Person person1 = new Person();
    person1.setFirstName(person.getFirstName());
    person1.setLastName(person.getLastName());
    person1.setGender(person.getGender());
    person1.setDob(person.getDob());
    person1.setEmail(person.getEmail());
    personRepository.save(person1);
    phoneService.createPhoneNoOfPerson(person1.getId(), person.getPhone());
    addressService.createAddress(person1.getId(), person.getAddress());
    loginService.createLogin(person1.getId(), person.getLogin());
    return person1;
  }

  public int deletePersonById(int id) {
    if (personRepository.findById(id).isPresent()) {
      personRepository.deleteById(id);
      return 1;
    }
    return 0;
  }

  public Host createHost(HostCreate host) {
    Host host1 = new Host();
    host1.setFirstName(host.getFirstName());
    host1.setSuperHost(host.getSuperHost());
    host1.setType("Host");
    host1.setLastName(host.getLastName());
    host1.setGender(host.getGender());
    host1.setDob(host.getDob());
    host1.setEmail(host.getEmail());
    hostRepository.save(host1);
    phoneService.createPhoneNoOfPerson(host1.getId(), host.getPhone());
    addressService.createAddress(host1.getId(), host.getAddress());
    loginService.createLogin(host1.getId(), host.getLogin());
    return hostRepository.save(host1);
  }

  public Guest createGuest(GuestCreate guest) {
    Guest guest1 = new Guest();
    guest1.setFirstName(guest.getFirstName());
    guest1.setVerified(guest.getVerified());
    guest1.setType("Guest");
    guest1.setLastName(guest.getLastName());
    guest1.setGender(guest.getGender());
    guest1.setDob(guest.getDob());
    guest1.setEmail(guest.getEmail());
    guestRepository.save(guest1);
    phoneService.createPhoneNoOfPerson(guest1.getId(), guest.getPhone());
    addressService.createAddress(guest1.getId(), guest.getAddress());
    loginService.createLogin(guest1.getId(), guest.getLogin());
    return guestRepository.save(guest1);
  }

  public Iterable<Host> findAllHosts() {
    return hostRepository.findAll();
  }

  public Iterable<Guest> findAllGuests() {
    return guestRepository.findAll();
  }

  public Guest findGuestByUsername(String name) {
    Guest guest = guestRepository.findByUsername(name);
    if (guest != null) {
      return guest;
    }

    return new Guest();
  }

  public Host findHostByUsername(String name) {
    return hostRepository.findByUsername(name);
  }

  public Host updateHost(int id, Host newHost) {
    if (hostRepository.findById(id).isPresent()) {
      Host host = hostRepository.findById(id).get();
      host.set(newHost);
      return hostRepository.save(host);
    }

    return null;
  }

  public Guest updateGuest(int id, Guest newGuest) {
    if (guestRepository.findById(id).isPresent()) {
      Guest guest = guestRepository.findById(id).get();
      guest.set(newGuest);
      return guestRepository.save(guest);
    }

    return null;
  }

  public int deleteHost(int id) {
    if (hostRepository.findById(id).isPresent()) {
      Host host = hostRepository.findById(id).get();
      hostRepository.delete(host);
      return 1;
    }

    return 0;
  }

  public int deleteGuest(int id) {
    if (guestRepository.findById(id).isPresent()) {
      Guest guest = guestRepository.findById(id).get();
      guestRepository.delete(guest);
      return 1;
    }

    return 0;
  }

  public Host getHost(int id) {
    if (hostRepository.findById(id).isPresent()) {
      return hostRepository.findById(id).get();
    }

    return null;
  }

  public Guest getGuest(int id) {
    if (guestRepository.findById(id).isPresent()) {
      return guestRepository.findById(id).get();
    }

    return null;
  }
}
