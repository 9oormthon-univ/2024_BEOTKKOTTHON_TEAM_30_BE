package com.goorm.behindyou.service.UserService;

import com.goorm.behindyou.domain.user.User;
import com.goorm.behindyou.web.dto.UserRequestDTO;

public interface UserCommandService {

    public void updateUser(Long userId);

    public User joinUser(UserRequestDTO.joinUserDTO request);
}
