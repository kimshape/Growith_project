package com.bit.growith.dao;

import com.bit.growith.vo.Replies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitBoardsRepliesRepository extends JpaRepository<Replies,Long> {
}
