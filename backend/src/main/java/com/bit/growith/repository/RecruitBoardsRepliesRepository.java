package com.bit.growith.repository;

import com.bit.growith.entity.Replies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitBoardsRepliesRepository extends JpaRepository<Replies,Long> {
}
