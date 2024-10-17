package ar.edu.utn.frc.backend.model.service;

import ar.edu.utn.frc.backend.model.entities.Tag;

import java.util.*;

public class TagService {
    private Map<String, Tag> tagMap;

    public TagService(){
        this.tagMap = new HashMap<>();
    }

    public Set<Tag> getOrCreate(List<String> tagList){
        Set<Tag> tags = new HashSet<>();
        tagList.forEach(
                tagName -> tags.add(tagMap.computeIfAbsent(tagName,Tag::new))
        );
        return tags;
    }

}
