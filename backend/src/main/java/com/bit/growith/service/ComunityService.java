package com.bit.growith.service;

import com.bit.growith.repository.ComunityRepository;
import com.bit.growith.entity.Comunity;
import com.bit.growith.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComunityService {

    private final ComunityRepository comunityRepository;

    @Transactional
    public Comunity 글쓰기(Comunity comunity, Member member) {
        comunity.setCount(0);
        comunity.setMember(member);
        return comunityRepository.save(comunity);
    }

    @Transactional(readOnly = true)
    public List<Comunity> 글목록(){
        return comunityRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Comunity 글상세보기(Long id) {
        return comunityRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void 글삭제하기(Long id) {
        comunityRepository.deleteById(id);
    }

    @Transactional
    public void 글수정하기(Long id, Comunity requestComunity) {
        Comunity comunity = comunityRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                }); // 영속화 완료
        comunity.setTitle(requestComunity.getTitle());
        comunity.setContent(requestComunity.getContent());
    }
}
