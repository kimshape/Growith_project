package com.bit.growith.controller.api;


import com.bit.growith.dto.ResponseDto;
import com.bit.growith.entity.Member;
import com.bit.growith.entity.Member;
import com.bit.growith.entity.RoleType;
import com.bit.growith.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin // 다른 포트에서 자원을 공유하기 위해
@RequiredArgsConstructor
@RestController
public class MemberApiController {


    private final MemberService memberService;

    @CrossOrigin
    @PostMapping("/member")
    public ResponseEntity<?> save(@RequestBody Member member){
        System.out.println("MemberApiController : save 호출");
        member.setRole(RoleType.Member);
    return new ResponseEntity<>(memberService.saveMember(member), HttpStatus.CREATED);
    }

    @PutMapping("/member/{memberId}")
    public ResponseEntity<?> update(@PathVariable Long memberId, @RequestBody Member member) {
        System.out.println("//////////"+memberId+"PUT/////////");
        return new ResponseEntity<>(memberService.modifyMember(memberId, member), HttpStatus.OK); //200

    }


    @CrossOrigin
    @GetMapping("/member")
    public ResponseEntity<?> findAll() {
        System.out.println("///////////"+"findAll()"+"//////////");
        return new ResponseEntity<>(memberService.listMember(), HttpStatus.OK);

    }
    @GetMapping("/member/{memberId}")
    public ResponseEntity<?> findById(@PathVariable Long memberId) {
        System.out.println("///////"+memberId+"///////");
        return new ResponseEntity<>(memberService.viewMember(memberId), HttpStatus.CREATED); //200

    }



    @DeleteMapping("/member/{memberId}")
    public ResponseEntity<?> deleteById(@PathVariable Long memberId) {
        System.out.println("///////"+memberId+"///////");
        return new ResponseEntity<>(memberService.deleteMember(memberId), HttpStatus.OK); //200

    }
}
