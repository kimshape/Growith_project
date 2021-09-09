package com.bit.growith.controller.api;

import com.bit.growith.dto.FileDto;
import com.bit.growith.service.FileService;
import com.bit.growith.service.RecruitBoardsService;
import com.bit.growith.util.MD5Generator;
import com.bit.growith.vo.File;
import com.bit.growith.vo.RecruitBoards;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin // 다른 포트에서 자원을 공유하기 위해
@RequiredArgsConstructor
@RestController
public class RecruitBoardsApiController {

    private final RecruitBoardsService recruitBoardsService;
//  private final FileService fileService;

//    @PostMapping("/recruitBoard")
//    public String save(@RequestBody RecruitBoards recruitBoards) {
//        System.out.println("recruitBoardId : "+recruitBoards.getRecruitBoardId());
//        System.out.println("teams : "+recruitBoards.getTeams());
//        System.out.println("recruitBoardContent : "+recruitBoards.getRecruitBoardContent());
//        System.out.println("likeCount : "+recruitBoards.getLikeCount());
//        return "저장완료";

    @PostMapping("/recruitBoard")
    public ResponseEntity<?> save(@RequestBody RecruitBoards recruitBoards) {
       return new ResponseEntity<>(recruitBoardsService.saveBoard(recruitBoards), HttpStatus.OK);
    }

//    @PostMapping("/recruitBoard")
//    public RecruitBoards save(@RequestBody RecruitBoards recruitBoards, @RequestParam("file") MultipartFile files) {
//        try {
//            String origFilename = files.getOriginalFilename();
//            String filename = new MD5Generator(origFilename).toString();
//            /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
//            String savePath = System.getProperty("user.dir") + "\\files";
//            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
//            if (!new File(savePath).exists()) {
//                try{
//                    new File(savePath).mkdir();
//                }
//                catch(Exception e){
//                    e.getStackTrace();
//                }
//            }
//            String filePath = savePath + "\\" + filename;
//            files.transferTo(new File(filePath));
//
//            FileDto fileDto = new FileDto();
//            fileDto.setOrigFilename(origFilename);
//            fileDto.setFilename(filename);
//            fileDto.setFilePath(filePath);
//
//            Long fileId = fileService.saveFile(fileDto);
//            recruitBoards.setFileId(fileId);
//            recruitBoardsService.saveBoard(recruitBoards);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }
//}


    @GetMapping("/recruitBoard")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(recruitBoardsService.listBoard(), HttpStatus.OK);

    }

    @GetMapping("/recruitBoard/{id}")
    public ResponseEntity<?> findById(@PathVariable Long recruitBoardId) {
        return new ResponseEntity<>(recruitBoardsService.viewBoard(recruitBoardId), HttpStatus.OK);

    }

    @PutMapping("/recruitBoard/{id}")
    public ResponseEntity<?> update(@PathVariable Long recruitBoardId, @RequestBody RecruitBoards recruitBoards) {
        return new ResponseEntity<>(recruitBoardsService.modifyBoard(recruitBoardId, recruitBoards), HttpStatus.OK);

    }

    @DeleteMapping("/recruitBoard/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long recruitBoardId, @RequestBody RecruitBoards recruitBoards) {
        return new ResponseEntity<>(recruitBoardsService.deleteBoard(recruitBoardId), HttpStatus.OK);

    }
}