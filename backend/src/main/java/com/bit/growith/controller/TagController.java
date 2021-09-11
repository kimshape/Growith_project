package com.bit.growith.controller;

import com.bit.growith.service.TagServiceImpl;
import com.bit.growith.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags/")
@RequiredArgsConstructor
public class TagController {

    private final TagServiceImpl tagService;

    //멤버가 가진 모든 태그 목록 조회
    @GetMapping(value = "/tag", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tag>> displayTagList(String email) {

        return new ResponseEntity<>(tagService.getAllWithMember(email), HttpStatus.OK);
    }

    //태그 생성 폼 이동
    @GetMapping("/createTagForm")
    public String createTagForm() {
        return "createTagForm";
    }

    //태그 수정 폼 이동
    @GetMapping("/modifyTagForm")
    public String modifyTagForm() {
        return "modifyTagForm";
    }

    //태그 생성
    //생성할 태그 정보, 회원 정보 -> 생성된 태그 정보
    @PostMapping(value = "")
    public ResponseEntity<Long> createTag(@RequestBody Tag tag) {
        //1. 태그 이름 중복인지 체크한 뒤
        //2. 생성 or 중복 메시지
        Long tagId = tagService.create(tag);
        //입력한 값 저장~해서 서비스로 넘김
        //특히 태그 네임

//        if(tagName = 이미 있으면) {
        //createTag(tag); save하고
//            tag에 담아 리턴
//        } else {
//            태그이름 중복 아니면
//                    중복 메시지
//        }

        return new ResponseEntity<>(tagId, HttpStatus.OK);
    }

    //태그 수정
    //수정할 태그 정보 -> 수정된 태그 정보
    @PutMapping(value = "/{tagId}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> modifyTag(@RequestBody Tag tag) {
        tagService.modify(tag);
        return new ResponseEntity<>("modified", HttpStatus.OK);
    }

    //태그 삭제
    //삭제할 태그 id -> null..?
    @DeleteMapping(value = "/{tagId}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteTag(@PathVariable("tagId") long tagId) {
        tagService.delete(tagId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}

