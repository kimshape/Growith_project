//package com.bit.growith.controller;
//
//import com.bit.growith.dao.LoginRepository;
//import com.bit.growith.service.LoginService;
//import com.bit.growith.vo.Member;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/login")
//@RequiredArgsConstructor
//public class LoginController {
//
//    private final LoginService loginService;
//
////    //    인덱스
////    @GetMapping("/")
////    public String index() {
////
////        return "/index";
////    }
////
////    //    로그인
////    //로그인 페이지 전환
////    @GetMapping
////    public String displayLogin() {
////
////        return "";
////    }
////    //아이디 비번 입력 후 로그인 버튼 클릭
////    @PostMapping
////    public String login() {
////
////        return "";
////    }
////    //로그인 성공
////    @RequestMapping
////    public String loginSuccess(){
////
////        return "";
////    }
//    @PostMapping(value = "")
//    public ResponseEntity login(@RequestBody Member member){
//        return new ResponseEntity(loginService.login(member), HttpStatus.OK);
//    }
////
////    //관리자 계정 로그인, 관리자 메인 페이지 전환
////    @GetMapping
////    public String adminMain() {
////
////        return "";
////    }
////
////    //    회원가입
////    //회원가입 페이지 전환
////    @GetMapping
////    public String displayJoin() {
////
////        return "";
////    }
////
//    //회원 정보 입력 후 회원가입 버튼 클릭
//    @PostMapping(value = "")
//    public ResponseEntity join(@RequestBody Member member) {
//        return new ResponseEntity(loginService.join(member), HttpStatus.OK);
//    }
////
////    //    로그아웃
////    public String logoutSuccess() {
////
////        return "";
////    }
////
////    //회원 정보
////    public String memberInfo() {
////
////        return "";
////    }
////
////    //실패 페이지
////    public String displayDenied(){
////
////        return  "";
////    }
//
//}
