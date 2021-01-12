package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Address;
import cs5200.project.cs5200_project.models.Guest;
import cs5200.project.cs5200_project.models.Host;
import cs5200.project.cs5200_project.models.Person;
import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.models.Trip;
import cs5200.project.cs5200_project.repositories.GuestRepository;
import cs5200.project.cs5200_project.repositories.HostRepository;
import cs5200.project.cs5200_project.repositories.PersonRepository;
import cs5200.project.cs5200_project.repositories.PropertyRepository;
import cs5200.project.cs5200_project.repositories.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TripService {

  @Autowired
  private TripRepository tripRepository;

  @Autowired
  private GuestRepository guestRepository;

  @Autowired
  private HostRepository hostRepository;

  @Autowired
  private PropertyRepository propertyRepository;

  public Iterable<Trip> getTrips() {
    return tripRepository.findAll();
  }

  public Trip createTrip(int gid, int pid, Trip trip) {
    if (guestRepository.findById(gid).isPresent() && propertyRepository.findById(pid).isPresent()) {
      Guest guest = guestRepository.findById(gid).get();
      Property property = propertyRepository.findById(pid).get();
      trip.setGuest(guest);
      trip.setProperty(property);
      return tripRepository.save(trip);
    }
    return null;
  }

  public Iterable<Trip> getTripOfGuest(int id) {
    if (guestRepository.findById(id).isPresent()) {
      Guest guest = guestRepository.findById(id).get();
      return tripRepository.findTripOfGuest(guest);
    }
    return null;
  }

  public Iterable<Trip> getTripOfProperty(int id) {
    if (propertyRepository.findById(id).isPresent()) {
      Property property = propertyRepository.findById(id).get();
      return tripRepository.findPropertyTrips(property);
    }
    return null;
  }

  public int deleteTrip(int id) {
    if (tripRepository.findById(id).isPresent()) {
      tripRepository.deleteById(id);
      return 1;
    }

    return 0;
  }

  public Trip updateTrip(int id, Trip newTrip) {
    if (tripRepository.findById(id).isPresent()) {
      Trip trip = tripRepository.findById(id).get();
      trip.set(newTrip);
      return tripRepository.save(trip);
    }

    return null;
  }

  public Iterable<Trip> findHostTrip(int id) {
    if (hostRepository.findById(id).isPresent()) {
      Host host = hostRepository.findById(id).get();
      Iterable<Property> properties = propertyRepository.findPropertyByHost(host);
      return tripRepository.findAllPropertyTrips(properties);
    }

    return null;
  }

  public Iterable<Trip> findGuestNameTrip(String name) {
    Guest guest = guestRepository.findByUsername(name);
    if (guest != null) {
      return tripRepository.findTripOfGuest(guest);
    }
    return null;
  }

  public Iterable<Trip> findHostNameTrip(String name) {
    Host host = hostRepository.findByUsername(name);
    if (host != null) {
      Iterable<Property> properties = propertyRepository.findPropertyByHost(host);
      return tripRepository.findAllPropertyTrips(properties);
    }

    return null;
  }

  public Guest findTripForGuest(int id) {
    if (tripRepository.findById(id).isPresent()) {
      return tripRepository.findById(id).get().getGuest();
    }
    return null;
  }

  public Trip setCoGuest(int id, int cid) {
    if (tripRepository.findById(id).isPresent() && guestRepository.findById(cid).isPresent()) {
      Trip trip = tripRepository.findById(id).get();
      Guest guest = guestRepository.findById(cid).get();
      trip.setGuests(guest);
      return tripRepository.save(trip);
    }

    return null;
  }

    public Property getPropertyofTrip(int id) {
    if(tripRepository.findById(id).isPresent()){
      Trip trip = tripRepository.findById(id).get();
      return propertyRepository.findPropertyByTrip(trip);
    }

    return null;
    }

    public Trip findById(int id) {
    if(tripRepository.findById(id).isPresent()){
      return tripRepository.findById(id).get();
    }
    return null;
    }
}
