package com.bit.growith.vo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todolist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long todolistId;

    @Column
    private String todolistContent;

    @Column
    private LocalDate todolistDate;

    @Column
    private int isCheck;

    @Column
    private int isDelete;

    //tagId 받아옴
    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    @OneToMany(mappedBy = "todolist")
    private List<TodolistReply> todolistReplies = new ArrayList<>();
}
