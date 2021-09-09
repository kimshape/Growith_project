package com.bit.growith.vo;

import com.bit.growith.util.Gender;
import com.bit.growith.util.MemberRole;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "members")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private long memberId;

    @Column(length = 30, nullable = false)
    private String memberEmail;
    @Column(length = 16, nullable = false)
    private String memberPw;

    @Column(length = 6, nullable = false)
    private String memberName;
    @Column(length = 50, nullable = false)
    private String memberAddress;
    @Column
    private LocalDate birth;
    @Column(length = 10, nullable = false)
    private String memberNickname;
    @Column(length = 100, nullable = false)
    private String memberComment;

//    @Column
//    private Gender gender;
//    @Column
//    private MemberRole memberRole;
    @Column
    private int isDelete;
    @Column
    private boolean fromSocial;//불린 타입 주의~~

//    enum
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Gender> genderSet = new HashSet<>();

    public void addGender(Gender gender){
        genderSet.add(gender);
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole memberRole){
        roleSet.add(memberRole);
    }

//    onetomany mapping
    @OneToMany(mappedBy = "member")
    private List<Tag> tags = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<Follow> follows = new ArrayList<>();


}
