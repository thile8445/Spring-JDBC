package com.example.demo.common.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.common.model.Comment;

public class CommentMapper implements RowMapper<Comment> {

	public static final String BASE_GET_COMMENT_SQL = "SELECT c.comment_id, c.content, c.user_id, c.post_id, c.created, c.modified FROM comment as c";

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Long commentId = rs.getLong("comment_id");
		Long userId = rs.getLong("user_id");
		Long postId = rs.getLong("post_id");

		String content = rs.getString("content");

		Date created = rs.getDate("created");
		Date modified = rs.getDate("modified");
		return new Comment(commentId, content, userId, postId, created, modified);
	}

}
