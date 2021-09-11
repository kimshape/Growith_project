package com.bit.growith.entity;

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
public class LikeBoards extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeBoardId;

    @ManyToOne
    @JoinColumn(name = "recruitBoardId")
    private RecruitBoards recruitBoards;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
}
