package cs5200.project.cs5200_project.Controller;

import cs5200.project.cs5200_project.models.Address;
import cs5200.project.cs5200_project.models.Guest;
import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.models.Trip;
import cs5200.project.cs5200_project.services.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TripController {

  @Autowired
  TripService tripService;

  @GetMapping("/api/trips")
  public Iterable<Trip> getTrips() {
    return tripService.getTrips();
  }

  @PostMapping("/api/guest/{gid}/property/{pid}/trips")
  public Trip createGuestTrip(@PathVariable int gid, @PathVariable int pid, @RequestBody Trip trip) {
    return tripService.createTrip(gid, pid, trip);
  }

  @GetMapping("/api/guest/id/{id}/trip")
  public Iterable<Trip> getTripOfGuest(@PathVariable int id) {
    return tripService.getTripOfGuest(id);
  }

  @GetMapping("/api/property/{id}/trip")
  public Iterable<Trip> getTripsOfProperty(@PathVariable int id) {
    return tripService.getTripOfProperty(id);
  }

  @DeleteMapping("/api/trip/{id}")
  public int deleteTrip(@PathVariable int id) {
    return tripService.deleteTrip(id);
  }

  @PutMapping("/api/trip/{id}")
  public Trip updateTrip(@PathVariable int id, @RequestBody Trip trip) {
    return tripService.updateTrip(id, trip);
  }

  @GetMapping("/api/host/id/{id}/trip")
  public Iterable<Trip> getHostTrip(@PathVariable int id) {
    return tripService.findHostTrip(id);
  }

  @GetMapping("/api/host/name/{name}/trip")
  public Iterable<Trip> getHostNameTrip(@PathVariable String name) {
    return tripService.findHostNameTrip(name);
  }

  @GetMapping("/api/guest/name/{name}/trip")
  public Iterable<Trip> getGuestNameTrip(@PathVariable String name) {
    return tripService.findGuestNameTrip(name);
  }

  @GetMapping("/api/trip/{id}/guest")
  public Guest getGuestForTrip(@PathVariable int id) {
    return tripService.findTripForGuest(id);
  }

  @PostMapping("/api/trip/{id}/coGuestId/{cid}")
  public Trip setTripCoGuest(@PathVariable("id") int id, @PathVariable int cid) {
    return tripService.setCoGuest(id, cid);
  }

  @GetMapping("/api/trip/{id}/property")
  public Property propertyByTrip(@PathVariable int id){
    return tripService.getPropertyofTrip(id);
  }

  @GetMapping("/api/trip/{id}")
  public Trip tripById(@PathVariable int id){
    return tripService.findById(id);
  }
}
