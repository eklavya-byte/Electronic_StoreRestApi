package com.lcwd.electronic.store.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    @OneToOne
    @JoinColumn(name ="product_id" )
    private Product product;

    private int quantity;

    private double totalPrice ;


    // mapping cart (to find out from which cart this belongs )

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
