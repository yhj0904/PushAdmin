package com.nanwe.push.service;

import com.nanwe.push.dto.JoinDTO;
import com.nanwe.push.entity.UserEntity;
import com.nanwe.push.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO) {

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();
        String role = joinDTO.getRole();

        if (username == null || password == null || role == null) {
            throw new IllegalArgumentException("필수 값이 누락되었습니다.");
        }

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {

            throw new IllegalStateException("이미 존재하는 사용자입니다.");
        }

        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_" + joinDTO.getRole()); // 예: "USER" → "ROLE_USER"

        userRepository.save(data);
    }
}