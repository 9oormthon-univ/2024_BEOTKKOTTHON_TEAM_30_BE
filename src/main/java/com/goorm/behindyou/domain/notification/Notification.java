package com.goorm.behindyou.domain.notification;

import com.goorm.behindyou.domain.common.BaseDateTimeEntity;
import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Notification extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    private Long status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    public void setUser(User user) {
        if (this.user != null)
            user.getNotificationList().remove(this);
        this.user = user;
        user.getNotificationList().add(this);
    }

    public void setKeyword(Keyword keyword) {
        if (this.keyword != null)
            keyword.getNotificationList().remove(this);
        this.keyword = keyword;
        keyword.getNotificationList().add(this);
    }
}
