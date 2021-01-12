package cs5200.project.cs5200_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cs5200.project.cs5200_project.models.Admin;
import cs5200.project.cs5200_project.models.Login;
import cs5200.project.cs5200_project.services.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

  @Autowired
  AdminService adminService;

  @GetMapping("api/admin/login")
  public Admin checkLogin(@RequestBody Login login) {
    return adminService.checkLogin(login);
  }

  @PostMapping("api/admin/")
  public Admin createAdmin(@RequestBody Admin admin) {
    return adminService.createAdmin(admin);
  }

  @GetMapping("api/admin/{id}")
  public Admin getAdmin(@PathVariable int id) {
    return adminService.getAdmin(id);
  }

  @PutMapping("api/admin/{id}")
  public Admin updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
    return adminService.updateAdmin(id, admin);
  }

  @GetMapping("/api/admin/uname/{uname}")
  public Admin getAdminByUname(@PathVariable String uname) {
    return adminService.findAdminByUname(uname);
  }

}
