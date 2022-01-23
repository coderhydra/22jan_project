package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.userVO;
@Repository("userDao")
public class userDAO implements userDAO_IF {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean insert(userVO u) {
		String sql = "INSERT INTO library_user VALUES(NULL,NULL,?,?,?,?,?,?,?,?)";
		int rows = jdbcTemplate.update(sql,
				u.getUid(),u.getPwd(),u.getName(),u.getBirth(),u.getGender(),u.getPhone(),u.getEmail(),u.getAddress());
		return rows>0;
	}

	@Override
	public int insertAndGetId(userVO u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(userVO u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<userVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public userVO select(String uid) {
		String sql = "SELECT* FROM library_user WHERE uid=?";
		return jdbcTemplate.queryForObject(sql, (rs,i)->
		//select ---> queryforObject
		new userVO(rs.getString(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),
				rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10))
				,uid);
	}

}
