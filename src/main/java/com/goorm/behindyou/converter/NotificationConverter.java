package com.goorm.behindyou.converter;

import com.goorm.behindyou.domain.notification.Notification;

public class NotificationConverter {

    public static Notification toNotification() {
        return Notification.builder()
                .status(1L)
                .build();
    }
}
