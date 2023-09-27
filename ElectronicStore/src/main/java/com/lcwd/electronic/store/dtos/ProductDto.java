package com.lcwd.electronic.store.dtos;


import com.lcwd.electronic.store.entities.Category;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class ProductDto {

    private String productId;

    private String title;

    private String description;

    private double price;

    private double discountedPrice;

    private int quantity;

    private Date addedDate;

    private boolean live;

    private boolean stock;

    private String productImageName;

    private CategoryDto category;
}
