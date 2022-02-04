package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.RecordMapper;
import com.example.demo.vo.RecordVO;

@Repository
public class RecordDAO {
	
	@Autowired
	private RecordMapper mapper;

	public int insertRent(RecordVO record) {
		mapper.insertStatus(record);
		return mapper.insertRecord(record);
	}

	public int insertReserve(RecordVO record) {
		return mapper.insertReserve(record);
	}

	public RecordVO reserveNo(RecordVO record) {
		return mapper.reserveNo(record);
	}

	public int insertDelivery(RecordVO record) {
		return mapper.insertDelivery(record);
	}

	public RecordVO status(RecordVO isbn) {
		List<RecordVO> list =  mapper.getRentStatusByIsbn(isbn);
		RecordVO record = null;
		if (list.size()==0) return null;
		record = list.get(0);
		return record;
	}


}
