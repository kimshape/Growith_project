package com.bit.growith.service;

import com.bit.growith.repository.TeamsRepository;
import com.bit.growith.entity.Teams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamsService {

    private final TeamsRepository teamsRepository;

    @Transactional
    public Teams 팀생성(Teams teams) {
//        teams.setMember(member);
        return teamsRepository.save(teams);
    }

    @Transactional(readOnly = true)
    public List<Teams> 팀목록(){
        return teamsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Teams 팀상세보기(Long id) {
        return teamsRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("팀 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public String 팀삭제하기(Long id) {
        teamsRepository.deleteById(id);
        return "ok";
    }

    @Transactional
    public Teams 팀수정하기(Long id, Teams requestTeams) {
        Teams teams = teamsRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("팀 찾기 실패 : 아이디를 찾을 수 없습니다.");
                }); // 영속화 완료
        teams.setTeamsName(requestTeams.getTeamsName());
        teams.setTeamsDescription(requestTeams.getTeamsDescription());
        return teams;
    }
}
