//package com.bit.growith.dao;
//
//import com.bit.growith.vo.Member;
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface LoginRepository extends JpaRepository<Member, Long> {
//    //select memberEmail from member where exists(select memberEmail from member where id=?)
//    //-> null? !null?
//    Member checkById(String memberEmail);
//
//    Optional<Member> findByMemberEmail(String username, boolean b);
//
//    //소셜 추가 회원 여부 선택해 동장
////    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
////    @Query("select m from Member m where m.fromSocial = :sosial and m.memberEmail = :email")
////    Optional<Member> findByMemberEmail(String email, boolean social);
//    /*
//    public Member findByMemberId(long memberId);
//    public Member save(Member member);
//    public List<Member> findByMemberId(long memberId);
//    public void deleteByMemberId(long memberId);
//     */
//}
