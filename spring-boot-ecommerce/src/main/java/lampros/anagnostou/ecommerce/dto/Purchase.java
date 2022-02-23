package lampros.anagnostou.ecommerce.dto;

import lampros.anagnostou.ecommerce.entity.Address;
import lampros.anagnostou.ecommerce.entity.Customer;
import lampros.anagnostou.ecommerce.entity.Order;
import lampros.anagnostou.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
