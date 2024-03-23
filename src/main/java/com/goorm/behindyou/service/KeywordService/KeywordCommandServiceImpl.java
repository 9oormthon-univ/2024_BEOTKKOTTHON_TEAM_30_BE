package com.goorm.behindyou.service.KeywordService;

import com.goorm.behindyou.apiPayload.code.status.ErrorStatus;
import com.goorm.behindyou.apiPayload.exception.handler.KeywordHandler;
import com.goorm.behindyou.apiPayload.exception.handler.UserHandler;
import com.goorm.behindyou.converter.KeywordConverter;
import com.goorm.behindyou.converter.NotificationConverter;
import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.domain.notification.Notification;
import com.goorm.behindyou.domain.user.User;
import com.goorm.behindyou.repository.KeywordRepository;
import com.goorm.behindyou.repository.NotificationRepository;
import com.goorm.behindyou.repository.UserRepository;
import com.goorm.behindyou.web.dto.KeywordRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KeywordCommandServiceImpl implements KeywordCommandService {

    private final UserRepository userRepository;
    private final KeywordRepository keywordRepository;
    private final NotificationRepository notificationRepository;

    @Override
    @Transactional
    public Keyword uploadKeyword(Long userId, KeywordRequestDTO.UploadKeywordDTO request) {

        Keyword newKeyword = KeywordConverter.toKeyword(request);

        User newUser = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        newKeyword.setUser(newUser);
        keywordRepository.save(newKeyword);

        Notification newNotification = NotificationConverter.toNotification();
        notificationRepository.save(newNotification);
        newNotification.setUser(newUser);
        newNotification.setKeyword(newKeyword);

        return newKeyword;
    }

    @Override
    @Transactional
    public void deleteKeyword(Long keywordId) {
        Keyword keyword = keywordRepository.findById(keywordId).orElseThrow(() -> new KeywordHandler(ErrorStatus.KEYWORD_NOT_FOUND));
        Notification notification = notificationRepository.findByKeyword(keyword);
        notificationRepository.delete(notification);
        keywordRepository.delete(keyword);
    }

    @Override
    @Transactional
    public void updateNotification(Long keywordId) {
        Keyword keyword = keywordRepository.findById(keywordId).orElseThrow(() -> new KeywordHandler(ErrorStatus.KEYWORD_NOT_FOUND));
        Notification notification = notificationRepository.findByKeyword(keyword);
        notification.updateStatus();
    }
}
