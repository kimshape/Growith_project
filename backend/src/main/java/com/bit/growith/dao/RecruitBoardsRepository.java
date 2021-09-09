package com.bit.growith.dao;

import com.bit.growith.vo.RecruitBoards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitBoardsRepository extends JpaRepository<RecruitBoards,Long> {
}
