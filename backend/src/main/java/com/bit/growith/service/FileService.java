//package com.bit.growith.service;
//
//import com.bit.growith.dao.FileRepository;
//import com.bit.growith.dto.FileDto;
//import com.bit.growith.vo.File;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class FileService {
//    private FileRepository fileRepository;
//
//    public FileService(FileRepository fileRepository) {
//        this.fileRepository = fileRepository;
//    }
//
//    @Transactional
//    public Long saveFile(FileDto fileDto) {
//        return fileRepository.save(fileDto.toEntity()).getId();
//    }
//
//    @Transactional
//    public FileDto getFile(Long id) {
//        File file = fileRepository.findById(id).get();
//
//        FileDto fileDto = FileDto.builder()
//                .id(id)
//                .origFilename(file.getOrigFilename())
//                .filename(file.getFilename())
//                .filePath(file.getFilePath())
//                .build();
//        return fileDto;
//    }
//}
