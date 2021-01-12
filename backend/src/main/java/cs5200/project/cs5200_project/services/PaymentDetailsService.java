package cs5200.project.cs5200_project.services;

import cs5200.project.cs5200_project.models.Payment_detail;
import cs5200.project.cs5200_project.models.Trip;
import cs5200.project.cs5200_project.repositories.PaymentDetailsRepository;
import cs5200.project.cs5200_project.repositories.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsService {
  @Autowired
  private PaymentDetailsRepository paymentDetailsRepository;

  @Autowired
  private TripRepository tripRepository;

  public Iterable<Payment_detail> getPaymentDetails() {
    return paymentDetailsRepository.findAll();
  }

  public Payment_detail createPayment(int id, Payment_detail payment_detail) {
    if (tripRepository.findById(id).isPresent()) {
      Trip trip = tripRepository.findById(id).get();
      payment_detail.setTrip(trip);
      return paymentDetailsRepository.save(payment_detail);
    }
    return null;
  }

  public Payment_detail getPaymentDetailForTrip(int id) {
    if (tripRepository.findById(id).isPresent()) {
      Trip trip = tripRepository.findById(id).get();
      return paymentDetailsRepository.getPaymentDetails(trip);
    }
    return null;
  }


  public Integer deletePaymentDetails(int tripId) {
    if (tripRepository.findById(tripId).isPresent()) {
      Trip trip = tripRepository.findById(tripId).get();
      Payment_detail payment_detail= paymentDetailsRepository.getPaymentDetails(trip);
      paymentDetailsRepository.deleteById(payment_detail.getId());
      return 1;
    }

    return 0;
  }

}
