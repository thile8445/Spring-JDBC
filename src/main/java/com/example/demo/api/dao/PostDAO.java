package com.example.demo.api.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.commom.exception.PostException;
import com.example.demo.common.dto.AddPostDTO;
import com.example.demo.common.mapper.PostMapper;
import com.example.demo.common.model.Post;
import com.sun.jdi.connect.spi.Connection;

@Repository
@Transactional
public class PostDAO extends JdbcDaoSupport {

	@Autowired
	public PostDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<Post> getAllPost() {
		// Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
		String sql = PostMapper.GET_ALL_POST_SQL;

		Object[] params = new Object[] {};
		PostMapper mapper = new PostMapper();
		
		List<Post> list = this.getJdbcTemplate().query(sql, params, mapper);

		return list;
	}

	public Post getPostById(Long id) {
		String sqlById = PostMapper.GET_ALL_POST_SQL + " WHERE p.post_id = ?";
		Object[] params = new Object[] { id };
		PostMapper mapper = new PostMapper();
		try {
			Post post = this.getJdbcTemplate().queryForObject(sqlById, params, mapper);
			return post;
		} catch (Exception e) {
			return null;
		}
	}

	public int addPost(AddPostDTO post) throws PostException {
		Object[] params = new Object[] { post.getTitle(), post.getContent(), post.getImgHeader(), post.getUserId() };
		String sqlAdd = "INSERT INTO post (`title`,`content`,`img_header`,`user_id`,`created`,`modified`) VALUES (?,?,?,?,NOW(),NOW())";

//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		
//		this.getJdbcTemplate().update(
//				new PreparedStatementCreator() {
//			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//			            PreparedStatement ps =
//			                connection.prepareStatement(sqlAdd, new String[] {"id"});
//			            ps.setString(1, post.getTitle());
//			            return ps;
//			        }
//			    },
//			    keyHolder);
//				);
//		
//		return (int) keyHolder.getKey();
		return this.getJdbcTemplate().update(sqlAdd, params);
	}

	public int updatePost(Long id, AddPostDTO post) throws PostException {

		Object[] params = new Object[] { post.getTitle(), post.getContent(), post.getImgHeader(), post.getUserId(),
				id };
		String sqlUpdate = "UPDATE post SET `title` = ?,`content` = ?,`img_header` = ?,`user_id` = ?,`modified` = NOW() WHERE `post_id` = ?;";

		return this.getJdbcTemplate().update(sqlUpdate, params);

	}

	public int deletePost(Long id) throws PostException {
		Object[] params = new Object[] { id };

		String deleteSqlPost = "DELETE FROM post where `post_id` = ?";

		return this.getJdbcTemplate().update(deleteSqlPost, params);
	}
}
