package com.bit.growith.controller;

import com.bit.growith.repository.RecruitBoardsRepliesRepository;
import com.bit.growith.repository.RecruitBoardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/RecruitBoards")
public class RecruitBoardsController {

    @Autowired
    private RecruitBoardsRepository recruitBoardsRepository;
    @Autowired
    private RecruitBoardsRepliesRepository recruitBoardsRepliesRepository;


}
