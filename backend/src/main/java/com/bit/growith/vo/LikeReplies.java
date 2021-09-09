package com.bit.growith.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeReplies extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeReplyId;

    @ManyToOne
    @JoinColumn(name = "replyId")
    private Replies replies;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
}
