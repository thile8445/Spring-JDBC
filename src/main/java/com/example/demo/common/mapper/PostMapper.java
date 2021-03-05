package com.example.demo.common.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.common.model.Post;

public class PostMapper implements RowMapper<Post> {

	public static final String GET_ALL_POST_SQL = "SELECT p.post_id,p.title,p.content,p.img_header,p.user_id,p.created,p.modified FROM post as p";

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Long id = rs.getLong("post_id");
		String title = rs.getString("title");
		String content = rs.getString("content");
		Long userId = rs.getLong("user_id");
		String imgHeader = rs.getString("img_header");
		Date created = rs.getDate("created");
		Date modified = rs.getDate("modified");

		return new Post(id, title, content, imgHeader, userId, created, modified);

	}

}
