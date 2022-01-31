package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.parsing.BookParsing;
import com.example.demo.vo.BookVO;

@Repository
public class BookDAO {
	
	private BookParsing bp = new BookParsing();
	
	public List<BookVO> search(String keyWord) {
		return bp.search(keyWord);
		//return null;
	}

	public Object searchIsbn(String isbn) {
		return bp.searchIsbn(isbn);
	}
}
