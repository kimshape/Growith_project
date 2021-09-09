package com.bit.growith.vo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "follows")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Follow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long followId;
    //memberId 받아옴1

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member follower;

    //followingId2
    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member following;

    //힘들면 Id 하나로 만들고 테스트 다 한다음 복합키로 바꿔도 ㄱㅊ

}
