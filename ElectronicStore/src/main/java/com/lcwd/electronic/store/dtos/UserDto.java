package com.lcwd.electronic.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDto {
    private String userId;
    @Size(min = 3,max = 17,message = "invalid name")
    private String name;
//  @Email(message = "Invalid user Email !!")
    @Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Invalid Email")
    @NotBlank(message = "Email is required ! ")
    private String email;
    @NotBlank(message = "Password is required !!")
    private String password;
    @Size(min = 4,max = 6,message = "Invalid gender")
    private String gender;
    @NotBlank(message = "Write something about yourself.")
    private String about;
    private String imageName;

    //@Pattern  and @Custom validator !
}
