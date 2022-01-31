package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.RecordVO;

@Mapper
public interface RecordMapper {

	int insertRecord(RecordVO r);
}
