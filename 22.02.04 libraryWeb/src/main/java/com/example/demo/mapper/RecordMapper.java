package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.RecordVO;

@Mapper
public interface RecordMapper {

	int insertRecord(RecordVO r);
	int insertReserve(RecordVO r);
	RecordVO reserveNo(RecordVO r);
	int insertDelivery(RecordVO record);
	List<RecordVO> getRentStatusByIsbn(RecordVO vo);
	int insertStatus(RecordVO record);
}
