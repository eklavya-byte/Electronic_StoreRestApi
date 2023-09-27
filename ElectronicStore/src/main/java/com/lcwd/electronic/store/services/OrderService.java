package com.lcwd.electronic.store.services;

import com.lcwd.electronic.store.dtos.CreateOrderRequest;
import com.lcwd.electronic.store.dtos.OrderDto;
import com.lcwd.electronic.store.dtos.PagebleResponse;

import java.util.List;

public interface OrderService {

        //createOrder

    OrderDto createOrder (CreateOrderRequest orderDto);
        // remove order
    void removeOrder(String orderId);

        // get orders of user
    List<OrderDto> getOrdersOfUser(String userId);

        //get orders (admin can see all )
    PagebleResponse<OrderDto> getOrders(int pageNumber,int pageSize,String sortBy, String sortDir);

        // order method(logic) related to order
}
