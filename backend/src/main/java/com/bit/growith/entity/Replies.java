package com.bit.growith.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Replies extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(nullable = false,length = 200)
    private String replyContent;

//    @Column // 지우는게 맞는 것 같음 (지운 기록을 남길 필요가 없으니까.. 0903형태)
//    private int isDelete;

    @ColumnDefault("0")
    private int likeCount;

//    @ColumnDefault("0")
//    private int reportCount;

//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruitBoardId")

    private RecruitBoards recruitBoards;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

//    @OneToMany(mappedBy = "replies", cascade = CascadeType.ALL)
//    private List<LikeReplies> likeReplies;

}
