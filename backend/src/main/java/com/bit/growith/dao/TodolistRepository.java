package com.bit.growith.dao;

import com.bit.growith.vo.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodolistRepository extends JpaRepository<Todolist, Long> {
}
