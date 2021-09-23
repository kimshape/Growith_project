package com.bit.growith.repository;

import com.bit.growith.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO
//자동으로 Bean등록됨
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
