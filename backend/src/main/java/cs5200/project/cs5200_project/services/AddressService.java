package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Address;
import cs5200.project.cs5200_project.models.Person;
import cs5200.project.cs5200_project.repositories.AddressRepository;
import cs5200.project.cs5200_project.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AddressService {
  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private PersonRepository personRepository;


  public Iterable<Address> getAddress() {
    return addressRepository.findAll();
  }

  public Address createAddress(int id, Address address) {
    if (personRepository.findById(id).isPresent()) {
      Person person = personRepository.findById(id).get();
      address.setPerson(person);
      return addressRepository.save(address);
    }
    return null;
  }

  public Iterable<Address> getAddressOfPerson(int id) {
    if (personRepository.findById(id).isPresent()) {
      Person person = personRepository.findById(id).get();
      return addressRepository.findAddressOfPerson(person);
    }
    return null;
  }
}
