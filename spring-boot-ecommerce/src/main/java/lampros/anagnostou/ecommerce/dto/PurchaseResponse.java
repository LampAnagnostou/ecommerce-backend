package lampros.anagnostou.ecommerce.dto;


import lombok.Data;

//using this class to send back a Java object as JSON
@Data
public class PurchaseResponse {

    private final String orderTrackingNumber;

}
