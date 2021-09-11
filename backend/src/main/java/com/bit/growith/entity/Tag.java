package com.bit.growith.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    //태그 기본으로 한개 갖고 있게 하기.... 이름은 일반...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    @Column
    private String tagName;

    @Column
    private int tagColor;

    //태그는 걍 delete로 삭제~ //속한 투두리스트도 다 삭제 해버리기

    //memberId 받아옴
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "tag")
    private List<Todolist> todolists = new ArrayList<>();


}
