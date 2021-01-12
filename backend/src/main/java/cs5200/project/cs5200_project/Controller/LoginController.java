package cs5200.project.cs5200_project.Controller;

import cs5200.project.cs5200_project.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cs5200.project.cs5200_project.models.Login;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

  @Autowired
  private LoginService loginService;


  @GetMapping("/api/person/{id}/login")
  public Login getLoginForPerson(@PathVariable int id) {
    return loginService.getLoginForPerson(id);
  }

  @PostMapping("/api/person/{id}/login")
  public Login createLogin(@PathVariable int id, @RequestBody Login login) {
    return loginService.createLogin(id, login);
  }

  @PostMapping("/api/login/check")
  public boolean checkLogin(@RequestBody Login givenLogin) {
    return loginService.findLoginByUsername(givenLogin);
  }

}
