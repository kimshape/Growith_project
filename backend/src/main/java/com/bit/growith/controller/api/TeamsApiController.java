//package com.bit.growith.controller.api;
//
//import com.bit.growith.dto.ResponseDto;
//import com.bit.growith.service.TeamsService;
//import com.bit.growith.vo.Teams;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class TeamsApiController {
//
//    @Autowired
//    private TeamsService teamsService;
//
//    @PostMapping("/api/board")
//    public ResponseDto<Integer> save(@RequestBody Teams teams, @AuthenticationPrincipal PrincipalDeteil principal) {
//        teamsService.팀생성(teams, principal.get());
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
//
//    @DeleteMapping("/api/board/{id}")
//    public ResponseDto<Integer> deleteById(@PathVariable Long id){
//        teamsService.팀삭제하기(id);
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
//
//    @PutMapping("/api/board/{id}")
//    public ResponseDto<Integer> update(@PathVariable Long id, @RequestBody Teams teams){
//        System.out.println("BoardApiController : update : id : "+id);
//        System.out.println("BoardApiController : update : board : "+board.getTitle());
//        System.out.println("BoardApiController : update : board : "+board.getContent());
//        teamsService.팀수정하기(id, teams);
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
//}
