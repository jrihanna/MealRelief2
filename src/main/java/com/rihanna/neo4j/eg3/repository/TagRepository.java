package com.rihanna.neo4j.eg3.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.rihanna.neo4j.eg3.model.Tag;

@Repository
public interface TagRepository extends Neo4jRepository<Tag, String> {

	@Query("MATCH (t: Tag) where (t.name =~ '(?i).*'+$tagName+'.*') return t")
	List<Tag> getTagsByName(String tagName);
}
