package com.goorm.behindyou.service.UserService;

import com.goorm.behindyou.apiPayload.code.status.ErrorStatus;
import com.goorm.behindyou.apiPayload.exception.handler.UserHandler;
import com.goorm.behindyou.converter.UserConverter;
import com.goorm.behindyou.domain.user.User;
import com.goorm.behindyou.repository.UserRepository;
import com.goorm.behindyou.web.dto.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void updateUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        user.updateStatus();
    }

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.joinUserDTO request) {

        User user = UserConverter.toJoinUserDTO(request);
        userRepository.save(user);

        return user;
    }
}
