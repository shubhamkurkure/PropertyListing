package cs5200.project.cs5200_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs5200.project.cs5200_project.models.Guest;
import cs5200.project.cs5200_project.models.Host;
import cs5200.project.cs5200_project.models.Property;
import cs5200.project.cs5200_project.models.Review;
import cs5200.project.cs5200_project.models.Trip;
import cs5200.project.cs5200_project.repositories.GuestRepository;
import cs5200.project.cs5200_project.repositories.HostRepository;
import cs5200.project.cs5200_project.repositories.ReviewRepository;
import cs5200.project.cs5200_project.repositories.TripRepository;

@Service
public class ReviewService {

  @Autowired
  ReviewRepository reviewRepository;

  @Autowired
  GuestRepository guestRepository;

  @Autowired
  HostRepository hostRepository;

  @Autowired
  TripRepository tripRepository;


  public Review setHostReview(int tid, Review review, String given_by) {
    if (tripRepository.findById(tid).isPresent()) {
      Trip trip = tripRepository.findById(tid).get();
      Property property = trip.getProperty();
      Host host = property.getHost();
      Guest guest = trip.getGuest();
      review.setGuest(guest);
      review.setTrip(trip);
      review.setHost(host);
      review.setGiven_by(given_by);
      return reviewRepository.save(review);
    }

    return null;
  }

  public Iterable<Review> getReviewGuest(int id) {
    if (guestRepository.findById(id).isPresent()) {
      Guest guest = guestRepository.findById(id).get();
      return reviewRepository.findGuestReviews(guest);
    }

    return null;
  }

  public Iterable<Review> getReviewTrip(int id) {
    if (tripRepository.findById(id).isPresent()) {
      Trip trip = tripRepository.findById(id).get();
      return reviewRepository.findTripReviews(trip);
    }

    return null;
  }

  public Iterable<Review> getReviewHost(int id) {
    if (hostRepository.findById(id).isPresent()) {
      Host host = hostRepository.findById(id).get();
      return reviewRepository.findHostReviews(host);
    }

    return null;
  }
}
