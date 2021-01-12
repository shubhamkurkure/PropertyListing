package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Login;
import cs5200.project.cs5200_project.models.Person;
import cs5200.project.cs5200_project.repositories.LoginRepository;
import cs5200.project.cs5200_project.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginService {
  @Autowired
  private LoginRepository loginRepository;

  @Autowired
  private PersonRepository personRepository;

  public Login getLoginForPerson(int id) {
    if (personRepository.findById(id).isPresent()) {
      Person person = personRepository.findById(id).get();
      return loginRepository.findLoginForPerson(person);
    }

    return null;
  }

  public Login createLogin(int id, Login login) {
    if (personRepository.findById(id).isPresent()) {
      Person person = personRepository.findById(id).get();
      login.setPerson(person);
      return loginRepository.save(login);
    }

    return null;
  }

  public boolean findLoginByUsername(Login givenLogin) {
    Login login = loginRepository.findLoginByUsername(givenLogin.getUserName());
    return login.getPassword().equals(givenLogin.getPassword());
  }
}
