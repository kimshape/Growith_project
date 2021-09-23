//package com.bit.growith.repository;
//
//import com.bit.growith.entity.Tag;
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface TagRepository extends JpaRepository<Tag, Long> {
//
//    @EntityGraph(attributePaths = "memberId", type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select t from Tag t where t.tagId = :tagId")
//    Optional<Tag> getWithMember(Long tagId);
//
//    @EntityGraph(attributePaths = {"memberId"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select t from Tag t where t.member.memberEmail = :email")
//    List<Tag> getList(String email);
//}
