package com.lcwd.electronic.store.dtos;

import com.lcwd.electronic.store.entities.Order;
import com.lcwd.electronic.store.entities.Product;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class OrderItemDto {

    private int orderItemId;
    private int totalPrice;
    private int quantity;
    private ProductDto product;
//    private Order order;


}
