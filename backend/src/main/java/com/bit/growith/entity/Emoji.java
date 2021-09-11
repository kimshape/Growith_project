package com.bit.growith.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emoji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emojiId;

    @Column
    private String emoji;
    //자바에서 enum하는게 나을지? 디비에서 갖고 있는거 쓰는 게 나을지?

    @OneToMany(mappedBy = "emoji")
    private List<TodolistReply> todolistReplies = new ArrayList<>();


}
