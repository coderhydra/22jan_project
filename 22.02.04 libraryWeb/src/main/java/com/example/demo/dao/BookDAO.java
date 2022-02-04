package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.parsing.BookParsing;
import com.example.demo.vo.BookVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Repository
public class BookDAO {
	
	private BookParsing bp = new BookParsing();
	
	public List<BookVO> search(String keyWord) {
		return bp.search(keyWord);
	}

	public Object searchIsbn(String isbn) {
		return bp.searchIsbn(isbn);
	}
	
	public PageInfo<BookVO> getSearchListPage(int pageNum, int pageSize,String keyWord){
	   PageHelper.startPage(pageNum, pageSize);
	 PageInfo<BookVO> pageInfo = new PageInfo<>(bp.search(keyWord));
	   return pageInfo;
	}
}
