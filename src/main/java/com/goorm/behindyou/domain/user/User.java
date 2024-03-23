package com.goorm.behindyou.domain.user;

import com.goorm.behindyou.domain.common.BaseDateTimeEntity;
import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.domain.notification.Notification;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String nickName;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    private Long alarmStatus;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Keyword> keyWordList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notificationList = new ArrayList<>();

    public void updateStatus() {
        if (this.alarmStatus == 0L) {
            this.alarmStatus = 1L;
        } else if (this.alarmStatus == 1L) {
            this.alarmStatus = 0L;
        }
    }
}
