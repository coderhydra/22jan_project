package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.RecordMapper;
import com.example.demo.vo.RecordVO;

@Repository
public class RecordDAO {
	
	@Autowired
	private RecordMapper mapper;

	public int insert(RecordVO record) {
		return mapper.insertRecord(record);
	}
}
