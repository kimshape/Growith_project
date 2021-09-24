package com.bit.growith.service;

import com.bit.growith.entity.Member;

import com.bit.growith.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// 스프링이 컴포넌트 스캔을 통해 빈에등록
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Member saveMember(Member member) {
       return memberRepository.save(member);
    }
    @Transactional(readOnly = true) // select 할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성 유지)
    public Member login(Member member){
        return memberRepository.findByUsernameAndPassword(member.getUsername(),member.getPassword());
    }
    @org.springframework.transaction.annotation.Transactional
    public Member modifyMember(Long memberId, Member member) {
        // update
        Member memberEntity = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("id를 똑바로 확인하시오.")); //영속화 (member 오브젝트)->영속성 context 보관
        memberEntity.setEmail(member.getEmail());
        memberEntity.setPassword(member.getPassword());
        memberEntity.setUsername(member.getUsername());
        return memberEntity;
    } //함수종료 => 트랜잭션 종료 => 영속화 되어있는 데이터를 DB로 갱신(flush) => commit ==> 더티체킹

    @org.springframework.transaction.annotation.Transactional(readOnly = true) // JPA 변경감지라는 내부 기능 -> 활성화X, update시의 정합성을 유지, insert의 유령데이터현상 못막음.
    public Member viewMember(Long memberId) { //상세보기
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("id를 똑바로 확인하시오."));

    }

    public List<Member> listMember() {
        return memberRepository.findAll();
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
        return "OK";
    }
}


