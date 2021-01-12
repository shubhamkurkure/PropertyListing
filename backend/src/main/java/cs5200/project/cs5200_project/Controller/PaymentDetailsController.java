package cs5200.project.cs5200_project.Controller;

import cs5200.project.cs5200_project.models.Payment_detail;
import cs5200.project.cs5200_project.services.PaymentDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PaymentDetailsController {
  @Autowired
  private PaymentDetailsService paymentDetailsService;

  @GetMapping("/api/payment-details")
  public Iterable<Payment_detail> getPaymentDetails() {
    return paymentDetailsService.getPaymentDetails();
  }

  @PostMapping("api/trip/{id}/payment-detail")
  public Payment_detail createPaymentDetails(@PathVariable("id") int id,
                                             @RequestBody Payment_detail payment_detail) {
    return paymentDetailsService.createPayment(id, payment_detail);
  }

  @GetMapping("/api/trip/{id}/payment-details")
  public Payment_detail getPaymentDetails(@PathVariable("id") int id) {
    return paymentDetailsService.getPaymentDetailForTrip(id);
  }

  @DeleteMapping("/api/trip/{id}/payment-details")
  public Integer deletePaymentDetails(@PathVariable("id") int id) {
    return paymentDetailsService.deletePaymentDetails(id);
  }
}
