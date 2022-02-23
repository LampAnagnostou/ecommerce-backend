package lampros.anagnostou.ecommerce.service;

import lampros.anagnostou.ecommerce.dto.PaymentInfo;
import lampros.anagnostou.ecommerce.dto.Purchase;
import lampros.anagnostou.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
