package cs5200.project.cs5200_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cs5200.project.cs5200_project.models.Review;
import cs5200.project.cs5200_project.services.ReviewService;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {

  @Autowired
  ReviewService reviewService;

  @PostMapping("/api/host/trip/{id}/review")
  public Review createHostReview(@PathVariable("id") int id, @RequestBody Review review) {
    return reviewService.setHostReview(id, review, "Host");
  }

  @PostMapping("/api/guest/trip/{id}/review")
  public Review createGuestReview(@PathVariable("id") int id, @RequestBody Review review) {
    return reviewService.setHostReview(id, review, "Guest");
  }

  @GetMapping("/api/guest/{id}/review")
  public Iterable<Review> getGuestReviews(@PathVariable("id") int id) {
    return reviewService.getReviewGuest(id);
  }

  @GetMapping("/api/host/{id}/review")
  public Iterable<Review> getHostReviews(@PathVariable("id") int id) {
    return reviewService.getReviewHost(id);
  }

  @GetMapping("/api/trip/{id}/review")
  public Iterable<Review> getTripReviews(@PathVariable("id") int id) {
    return reviewService.getReviewTrip(id);
  }
}
