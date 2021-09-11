package com.bit.growith.service;

import com.bit.growith.entity.Todolist;

import java.time.LocalDate;
import java.util.List;

public interface TodolistService {

    Long create(Todolist todolist);
    Todolist get(Long todolistId);
    void modify(Todolist todolist);
    void delete(Long todolistId);
    List<Todolist> getAllWithMemberAndTodolistDate(String memberEmail, LocalDate todolistDate);
}
