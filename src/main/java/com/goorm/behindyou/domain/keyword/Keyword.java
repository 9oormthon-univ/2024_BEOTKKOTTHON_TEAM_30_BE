package com.goorm.behindyou.domain.keyword;

import com.goorm.behindyou.domain.common.BaseDateTimeEntity;
import com.goorm.behindyou.domain.notification.Notification;
import com.goorm.behindyou.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Keyword extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(columnDefinition = "VARCHAR(50)")
    private String type;

    @Column(columnDefinition = "text")
    private String alertMessage;

    private Long urgency;

    private Long callingCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL)
    private List<Notification> notificationList = new ArrayList<>();

    public Keyword updateCallingCount() {
        this.callingCount += 1;
        return this;
    }

    public void setUser(User user) {
        if (this.user != null)
            user.getKeyWordList().remove(this);
        this.user = user;
        user.getKeyWordList().add(this);
    }
}
