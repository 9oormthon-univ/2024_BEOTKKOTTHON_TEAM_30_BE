package com.goorm.behindyou.domain.keyword;

import com.goorm.behindyou.domain.common.BaseDateTimeEntity;
import com.goorm.behindyou.domain.notification.Notification;
import com.goorm.behindyou.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Keyword extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_word_id")
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(columnDefinition = "VARCHAR(50)")
    private String type;

    @Column(columnDefinition = "VARCHAR(50)")
    private String alertInfo;

    @Column(nullable = false)
    private Long urgency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL)
    private List<Notification> notificationList = new ArrayList<>();
}
