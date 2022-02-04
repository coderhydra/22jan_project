package com.example.demo.dao;

import java.util.List;

import com.example.demo.vo.userVO;

public interface userDAO_IF {

		boolean insert(userVO u); //User u 를insert
	  int insertAndGetId(userVO u);
	  //인서트하고 ID(primary key)를 가져온다. 관계형(RDBMS_relational data base manage system)
	  userVO select(String uid); 
	  //date 추출 num 으로 한행만 추출 (primary key활용) 한행을 객체로 매핑필요
	  //키를 가지고 셀렉 하면 객체가 나옴
	  boolean update(userVO u);
	  //한행을 개조 (갱신,내용변경)
	  //새 데이터를 넣고 불린으로 결과 
	  boolean delete(int num);
	  //프라이머리 키를 입력하면 삭제결과 리턴
	  List<userVO> getList();
	  //여러행을 담아줄 리스트...
	  
	  //추상메소드를 선언하고 반드시 임플리먼트에서 오버라이드(구현)
	}