package com.rihanna.neo4j.eg3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rihanna.neo4j.eg3.model.Tag;
import com.rihanna.neo4j.eg3.service.TagService;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
@RequestMapping("/base/tags")
public class TagController {
	
	@Autowired
	TagService tagService;
	
	@GetMapping
    public @ResponseBody List<Tag> searchTagsByLabel(@Nullable @RequestParam String tagLabel) {
    	return tagService.searchTagsByLabel(tagLabel);
    }

}
