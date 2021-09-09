package com.bit.growith.service;

import com.bit.growith.dao.RecruitBoardsRepository;
import com.bit.growith.vo.RecruitBoards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecruitBoardsService {

    @Autowired
    private RecruitBoardsRepository recruitBoardsRepositoty;

    @Transactional // 서비스 함수가 종료될 떄 commit할지 롤백할지 트랜잭션관리
    public RecruitBoards saveBoard(RecruitBoards recruitBoards) { //저장하기
        return recruitBoardsRepositoty.save(recruitBoards);
    }

    @Transactional(readOnly = true) // JPA 변경감지라는 내부 기능 -> 활성화X, update시의 정합성을 유지, insert의 유령데이터현상 못막음.
    public RecruitBoards viewBoard(Long recruitBoardId) { //상세보기
        return recruitBoardsRepositoty.findById(recruitBoardId)
                .orElseThrow(() -> new IllegalArgumentException("id를 똑바로 확인하시오."));

    }

    public List<RecruitBoards> listBoard() {
        return recruitBoardsRepositoty.findAll();
    }

    @Transactional
    public RecruitBoards modifyBoard(Long recruitBoardId, RecruitBoards recruitBoards) {
        // update
        RecruitBoards recruitBoardsEntity = recruitBoardsRepositoty.findById(recruitBoardId)
                .orElseThrow(() -> new IllegalArgumentException("id를 똑바로 확인하시오.")); //영속화 (recruitBoards 오브젝트)->영속성 context 보관
        recruitBoardsEntity.setRecruitBoardContent(recruitBoards.getRecruitBoardContent());
        return recruitBoardsEntity;
    } //함수종료 => 트랜잭션 종료 => 영속화 되어있는 데이터를 DB로 갱신(flush) => commit ==> 더티체킹

    @Transactional
    public String deleteBoard(Long recruitBoardId) {
        recruitBoardsRepositoty.deleteById(recruitBoardId);
        return "삭제완료";
    }
}
