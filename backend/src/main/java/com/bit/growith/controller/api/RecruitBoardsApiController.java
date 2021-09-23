package com.bit.growith.controller.api;

import com.bit.growith.service.RecruitBoardsService;
import com.bit.growith.entity.RecruitBoards;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//security (라이브러리적용) -> CORS 정책을 가지고 있어 해제해야함
@CrossOrigin // 다른 포트에서 자원을 공유하기 위해
@RequiredArgsConstructor
@RestController
public class RecruitBoardsApiController {

    private final RecruitBoardsService recruitBoardsService;

    @CrossOrigin
    @PostMapping("/recruitBoard")
    public ResponseEntity<?> save(@RequestBody RecruitBoards recruitBoards) {
        System.out.println("//////////POST/////////");
       return new ResponseEntity<>(recruitBoardsService.saveBoard(recruitBoards), HttpStatus.CREATED); //201
    }
    @PutMapping("/recruitBoard/{recruitBoardId}")
    public ResponseEntity<?> update(@PathVariable Long recruitBoardId, @RequestBody RecruitBoards recruitBoards) {
        System.out.println("//////////"+recruitBoardId+"PUT/////////");
        return new ResponseEntity<>(recruitBoardsService.modifyBoard(recruitBoardId, recruitBoards), HttpStatus.OK); //200

    }


    @CrossOrigin
    @GetMapping("/recruitBoard")
    public ResponseEntity<?> findAll() {
        System.out.println("///////////"+"findAll()"+"//////////");
        return new ResponseEntity<>(recruitBoardsService.listBoard(), HttpStatus.OK);

    }
    @GetMapping("/recruitBoard/{recruitBoardId}")
    public ResponseEntity<?> findById(@PathVariable Long recruitBoardId) {
        System.out.println("///////"+recruitBoardId+"///////");
        return new ResponseEntity<>(recruitBoardsService.viewBoard(recruitBoardId), HttpStatus.OK); //200

    }



    @DeleteMapping("/recruitBoard/{recruitBoardId}")
    public ResponseEntity<?> deleteById(@PathVariable Long recruitBoardId) {
        System.out.println("///////"+recruitBoardId+"///////");
        return new ResponseEntity<>(recruitBoardsService.deleteBoard(recruitBoardId), HttpStatus.OK); //200

    }
}
