package com.sparta.springproject2.service;

import com.sparta.springproject2.dto.UserRequestDto;
import com.sparta.springproject2.dto.UserResponseDto;
import com.sparta.springproject2.entity.User;
import com.sparta.springproject2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserRequestDto requestDto) {
        // RequestDto -> Entity
        User user = new User(requestDto);

        // db 저장
        User saveUser = userRepository.save(user);

        // Entity -> ResponseDto
        UserResponseDto userResponseDto = new UserResponseDto(saveUser);

        return userResponseDto;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
