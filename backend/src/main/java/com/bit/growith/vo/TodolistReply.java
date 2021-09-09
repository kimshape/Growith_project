package com.bit.growith.vo;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodolistReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long todolistReplyId;

    //todolistId
    @ManyToOne
    @JoinColumn(name = "TODOLIST_ID")
    private Todolist todolist;

    //emotionaId
    @ManyToOne
    @JoinColumn(name = "EMOJI_ID")
    private Emoji emoji;

    //followId 받아옴
    //복합키 받아오기
}
