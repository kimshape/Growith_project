package com.bit.growith.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class RecruitBoards extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitBoardId;

//    @Column(name = "applyId") //식별관계로 해야할듯? (0902형태)
//    private Long applyId;

    @Lob
    private String recruitBoardContent;

    @ColumnDefault("0")
    private int likeCount;

//    @ColumnDefault("0") // 추후에 시간나면 신고도 추가하겠음 (0902형태)
//    private int reportCount;
//@JsonIgnore

//    @JsonManagedReference
    @OneToMany(mappedBy = "recruitBoards", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //mappedBy 연관관계의 주인이 아니다(난FK가아니다) DB에 컬럼만들지마라
    private List<Replies> replies;

//    @OneToMany(mappedBy = "recruitBoards", cascade = CascadeType.ALL)
//    private List<File> files;

//    @OneToMany(mappedBy = "recruitBoards", cascade = CascadeType.ALL)
//    private List<LikeBoards> likeBoards;




//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "teamsId")
//    private Teams teams;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "applyId")
//    private TeamMembers teamMembers;

}
