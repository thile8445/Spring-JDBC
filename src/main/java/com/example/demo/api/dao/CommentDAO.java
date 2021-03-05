package com.example.demo.api.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.mapper.CommentMapper;
import com.example.demo.common.model.Comment;

@Repository
@Transactional
public class CommentDAO extends JdbcDaoSupport {

	@Autowired
	public CommentDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<Comment> getAllComment() {

		Object[] params = new Object[] {};

		CommentMapper mapper = new CommentMapper();

		String sqlGetAll = CommentMapper.BASE_GET_COMMENT_SQL;

		List<Comment> list = this.getJdbcTemplate().query(sqlGetAll, params, mapper);
		return list;
	}

	public List<Comment> getCommentByPostAndUser(Long userId, Long postId) {
		Object[] params = new Object[] { userId, postId };
		CommentMapper mapper = new CommentMapper();

		String sqlGetByUserAndPost = CommentMapper.BASE_GET_COMMENT_SQL + " WHERE c.user_id = ? and c.post_id = ?";

		return this.getJdbcTemplate().query(sqlGetByUserAndPost, params, mapper);
	}
	
}
