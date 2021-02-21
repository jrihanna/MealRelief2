package com.rihanna.neo4j.eg3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.model.Tag;
import com.rihanna.neo4j.eg3.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	TagRepository tagRepository;
	
	public List<Tag> searchTagsByLabel(String tagName) {
		if(tagName != null && tagName.length() > 0)
			return tagRepository.getTagsByName(tagName);
		else
			return tagRepository.findAll();
	}
}
