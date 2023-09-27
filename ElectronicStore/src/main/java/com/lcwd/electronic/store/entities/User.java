package com.lcwd.electronic.store.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.*;

//This will be done automatically by lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email",unique = true)
    private String email;
    @Column(name = "user_password",length = 500)
    private String password;
    private String gender;
    @Column(length = 1000)
    private String about;
    @Column(name = "user_image_name")
    private String imageName;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Order> orders = new ArrayList<>();
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<Role> roles = new HashSet<>();


    @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE)
    private  Cart cart;



    //Spring security method
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.email;
//    }
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
