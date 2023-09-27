package com.lcwd.electronic.store.services;

import com.lcwd.electronic.store.dtos.AddItemToCartRequest;
import com.lcwd.electronic.store.dtos.CartDto;

public interface CartService {

    //add items to card:

    //case1 :
    CartDto addItemToCart(String userId, AddItemToCartRequest addItemToCartRequest);

    //remove item from cart
    void removeItemFromCart(String userId,int cartItem );

    //remove all items from cart
    void clearCart(String userId);

    CartDto getCartByUser(String userId);


}
