package com.bit.growith.service;

import com.bit.growith.repository.TagRepository;
import com.bit.growith.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    @Override
    public boolean checkDuplicateTagName() {
        return false;
    }

    @Override
    public Long create(Tag tag) {
        tagRepository.save(tag);
        return tag.getTagId();
    }

    @Override
    public Tag get(Long tagId) {
        Optional<Tag> result = tagRepository.getWithMember(tagId);
        if(result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void modify(Tag tag) {
        Optional<Tag> result = tagRepository.findById(tag.getTagId());
        if(result.isPresent()){
            tag = result.get();
            tag.setTagName(tag.getTagName());
            tag.setTagColor(tag.getTagColor());
            tagRepository.save(tag);
        }

    }

    @Override
    public void delete(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public List<Tag> getAllWithMember(String memberEmail) {
        List<Tag> tags = tagRepository.getList(memberEmail);
        return tags;
    }
}
