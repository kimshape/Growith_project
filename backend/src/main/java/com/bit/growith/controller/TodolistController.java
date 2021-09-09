package com.bit.growith.controller;

import com.bit.growith.service.TodolistService;
import com.bit.growith.vo.Todolist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TodolistController {

    private final TodolistService todolistService;


//    //멤버가 가진 모든 태그 목록 조회 //날짜별로
    @GetMapping(value = "/todolist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Todolist>> displayTagList(String email, LocalDate todolistDate) {

        return new ResponseEntity<>(todolistService.getAllWithMemberAndTodolistDate(email, todolistDate), HttpStatus.OK);
    }

    //투두리스트 추가
    //추가할 투두 정보, 날짜 정보, 회원 정보 -> 생성된 투두 정보
    @PostMapping(value = "")
    public ResponseEntity<Long> createTodolist(@RequestBody Todolist todolist) {
        Long todolistId = todolistService.create(todolist);
        //날짜

        return new ResponseEntity<>(todolistId, HttpStatus.OK);
    }

    //투두 수정(content, 완료여부, 날짜)
    //수정할 태그 정보 -> 수정된 태그 정보
    @PutMapping(value = "/{todolistId}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> modifyTodolist(@RequestBody Todolist todolist) {
        todolistService.modify(todolist);
        return new ResponseEntity<>("modified", HttpStatus.OK);
    }

//삭제... delete할까 save할까?
//    @DeleteMapping(value = "/{todolistId}", produces = MediaType.TEXT_PLAIN_VALUE)
//    public ResponseEntity<String> deleteTodolist(@PathVariable("todolistId") long todolistId) {
//        todolistService.delete(todolistId);
//        return new ResponseEntity<>("deleted", HttpStatus.OK);
//    }
}
