package com.lcwd.electronic.store.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryDto {

    private String categoryId;
    @NotBlank
//    @Min(value=4,message = "Title must be of minimum 4 characters") not working
    @Size(min = 4,message = "Title must be of minimum 4 characters ")
    private String title;
    @NotBlank(message = "Description required ! ")
    private String description;
//    @NotBlank(message = "Cover image required ! ")
    private String coverImage;


}
