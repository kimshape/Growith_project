package com.bit.growith.controller;

import com.bit.growith.service.TeamsService;
import com.bit.growith.entity.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TeamsController {

    @Autowired
    private TeamsService teamsService;

    @PostMapping("/teams")
    public ResponseEntity<?> save(@RequestBody Teams teams) {
        System.out.println("////////팀생성//////////");
        return new ResponseEntity<>(teamsService.팀생성(teams), HttpStatus.CREATED);
    }

    @GetMapping("/teams")
    public ResponseEntity<?> findAll() {
        System.out.println("///////////"+"findAll()"+"//////////");
        return new ResponseEntity<>(teamsService.팀목록(), HttpStatus.OK);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(teamsService.팀상세보기(id), HttpStatus.OK);
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Teams teams) {
        return new ResponseEntity<>(teamsService.팀수정하기(id, teams), HttpStatus.OK);
    }
    @DeleteMapping("/teams/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(teamsService.팀삭제하기(id), HttpStatus.OK);
    }
}


