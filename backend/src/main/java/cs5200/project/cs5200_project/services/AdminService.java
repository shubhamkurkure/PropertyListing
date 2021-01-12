package cs5200.project.cs5200_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs5200.project.cs5200_project.models.Admin;
import cs5200.project.cs5200_project.models.Login;
import cs5200.project.cs5200_project.repositories.AdminRepository;
import cs5200.project.cs5200_project.repositories.LoginRepository;

@Service
public class AdminService {

  @Autowired
  AdminRepository adminRepository;

  @Autowired
  LoginRepository loginRepository;

  public Admin checkLogin(Login newLogin) {
    Login login = loginRepository.findLoginByUsername(newLogin.getUserName());
    if (login != null) {
      if (newLogin.getPassword().equals(login.getPassword())) {
        return adminRepository.findByUsername(login.getUserName());
      }
      return null;
    }

    return null;
  }

  public Admin createAdmin(Admin admin) {
    return adminRepository.save(admin);
  }

  public Admin getAdmin(int id) {
    if (adminRepository.findById(id).isPresent()) {
      return adminRepository.findById(id).get();
    }

    return null;
  }

  public Admin updateAdmin(int id, Admin newAdmin) {
    if (adminRepository.findById(id).isPresent()) {
      Admin admin = adminRepository.findById(id).get();
      admin.set(newAdmin);
      return adminRepository.save(admin);
    }

    return null;
  }

  public Admin findAdminByUname(String uname) {
    return adminRepository.findByUsername(uname);
  }
}
