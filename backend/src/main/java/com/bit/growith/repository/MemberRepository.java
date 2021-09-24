package com.bit.growith.repository;

import com.bit.growith.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO
//자동으로 Bean등록됨
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    //SELECT * FROM user WHERE username = ?1 AND password = ?2;
Member findByUsernameAndPassword(String username, String password);

//==>같은말임, @Query(value = "SELECT * FROM member WHERE username = ?1 AND password = ?2", nativeQuery = true)
//Member login(String username, String password);
}
