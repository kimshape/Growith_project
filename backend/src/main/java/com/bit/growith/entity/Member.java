package com.bit.growith.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private Long memberId; //시퀀스 auto_increment
    @Column(nullable = false, length = 30)
    private String username;
    @Column(nullable = false, length = 100) // length를 길게잡은 이유? => 123456... =>해쉬 (비밀번호 암호화)
    private String password;
    @Column(nullable = false, length = 50)
    private String email;

    // @ColumnDefault("'user'")
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum을 쓰는게 좋다. // admin,user,manager

//    @OneToMany(mappedBy = "member")
//    private List<LikeReplies> likeReplies;

//    @JsonManagedReference
    @OneToMany(mappedBy = "member")
    private List<Replies> replies;
//    @OneToMany(mappedBy = "member")
//    private List<LikeBoards> likeBoards;

}
