package com.bit.growith.repository;

import com.bit.growith.entity.RecruitBoards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitBoardsRepository extends JpaRepository<RecruitBoards,Long> {
}
