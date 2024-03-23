package com.goorm.behindyou.service.UserService;

import com.goorm.behindyou.domain.user.User;

public interface UserQueryService {

    boolean isExistUser(Long userId);

    User findUserById(Long userId);
}
