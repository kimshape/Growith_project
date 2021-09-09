//package com.bit.growith.service;
//
//import com.bit.growith.dao.LoginRepository;
//import com.bit.growith.vo.Member;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class LoginServiceImpl implements LoginService {
//
//    private final LoginRepository loginRepository;
//    private final PasswordEncoder passwordEncoder;
////https://devlog-wjdrbs96.tistory.com/182
//    @Override
//    public Member login(Member member) {
////        member = loginRepository.checkById(member.getMemberEmail());
////
////        if(member == null) { //아이디 틀리면
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //LOGIN_FAIL 상태 이넘으로
////        }
////        //비번 체크
////        boolean checkPassword = passwordEncoder.matches(member.getMemberPw(), member.getMemberPw());
////        //매개변수????
////        if(checkPassword) {
////            return new ResponseEntity<>(HttpStatus.OK); //LOGIN_SUCCESS 상태 추가
////        }
//        return null;
//    }
//
//    @Override
//    public Member join(Member member) {
//        //아이디중복체크
////        member = loginRepository.checkById(member.getMemberEmail());
////        if(member!=null) { //이미 유저 존재
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//ALREADY_MEMBER 이미 있다는 상태
////        }
////        //비밀번호 암호화
////        String encodePassword = passwordEncoder.encode(member.getMemberPw());
////        member.setMemberPw(encodePassword);
////        loginRepository.save(member);
////        return new ResponseEntity<>(HttpStatus.OK); //JOIN_SUCCESS??
//        return null;
//    }
//}
