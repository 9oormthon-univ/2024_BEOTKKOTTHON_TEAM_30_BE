package com.goorm.behindyou.service.UserService;

import com.goorm.behindyou.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {

    private UserRepository userRepository;

    @Override
    public boolean isExistUser(Long userId) {
        return userRepository.existsById(userId);
    }
}
