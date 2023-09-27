package com.lcwd.electronic.store.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString


public class CreateOrderRequest {
    @NotBlank(message = "Id required ! ")
    private String cartId;
    @NotBlank(message = "Id required ! ")
    private String userId;
    private String orderStatus="PENDING";
    private String paymentStatus="NOTPAID";
    @NotBlank(message = "Address is Required.!  ")
    private String billingAddress;
    @NotBlank(message = "Phone number is Required.!  ")
    private String billingPhone;
    @NotBlank(message = "Billing name is required is Required.!  ")
    private String billingName;


}
