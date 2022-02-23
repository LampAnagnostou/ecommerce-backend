package lampros.anagnostou.ecommerce.controller;

import lampros.anagnostou.ecommerce.dto.PaymentInfo;
import lampros.anagnostou.ecommerce.dto.Purchase;
import lampros.anagnostou.ecommerce.dto.PurchaseResponse;
import lampros.anagnostou.ecommerce.service.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkOutService;

    private Logger logger = Logger.getLogger(getClass().getName());

    public CheckoutController(CheckoutService checkOutService){
        this.checkOutService = checkOutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        PurchaseResponse purchaseResponse = checkOutService.placeOrder(purchase);
        return purchaseResponse;
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {

        logger.info("paymentInfo.amount: " + paymentInfo.getAmount());
        PaymentIntent paymentIntent = checkOutService.createPaymentIntent(paymentInfo);
        String paymentStr = paymentIntent.toJson();

        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}
