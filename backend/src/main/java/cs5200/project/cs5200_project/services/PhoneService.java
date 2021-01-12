package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Person;
import cs5200.project.cs5200_project.models.Phone;
import cs5200.project.cs5200_project.repositories.PersonRepository;
import cs5200.project.cs5200_project.repositories.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PhoneService {
  @Autowired
  private PhoneRepository phoneRepository;

  @Autowired
  private PersonRepository personRepository;


  public Iterable<Phone> findPhoneNos() {
    return phoneRepository.findAll();
  }

  public Phone createPhoneNoOfPerson(int id, Phone phone) {
    if (personRepository.findById(id).isPresent()) {
      Person person = personRepository.findById(id).get();
      phone.setPerson(person);
      return phoneRepository.save(phone);
    }

    return null;
  }

  public Iterable<Phone> findPhoneNoOfPerson(int id) {
    if (personRepository.findById(id).isPresent()) {
      Person person = personRepository.findById(id).get();
      return phoneRepository.findPhoneNoOfPerson(person);
    }

    return null;
  }


}
