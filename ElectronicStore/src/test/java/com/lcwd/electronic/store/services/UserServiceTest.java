//package com.lcwd.electronic.store.services;
//
//import com.lcwd.electronic.store.dtos.UserDto;
//import com.lcwd.electronic.store.entities.User;
//import com.lcwd.electronic.store.repositories.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//@SpringBootTest
//public class UserServiceTest {
//
//    @Autowired// to use we have to use spring boot test to get annotation context
//    private UserService userService;
//
//    @Mock
//    @Autowired
//    private UserRepository userRepository;
//
//    User user;
//
//    String Id ;
//
//    @Autowired
//    private ModelMapper modelMapper;
//    @BeforeEach
//    public void init(){
//        user = User.builder().name("Prem").email("prem@gmail.com").about("this is testing create method ").gender("male")
//                .imageName("abc.png").password("lcwd").build();
//
//    }
//
//    @Test
//    public void createUserTest(){
//        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
//
//        UserDto user1 = userService.createUser(modelMapper.map(user, UserDto.class));
//        System.out.println(user1.getName());
//        Assertions.assertNotNull(user);
//    }
//
//    @Test
//    public void updateUserTest(){
//
//        String userid = "sdfsfs";
//        UserDto userDto = UserDto.builder()
//                .name("Prem").email("prem@gmail.com").about("this is testing create method ").gender("male")
//                .imageName("abc.png").password("lcwd")
//                .build();
//
//        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(user));
//        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
//        UserDto userDto1 = userService.updateUser(userDto, userid);
//        System.out.println(userDto1.getName());
//        Assertions.assertNotNull(userDto);
//    }
//
//}