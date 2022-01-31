package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.vo.BookVO;

public class Cart {
	
		private List<BookVO> list= new ArrayList<>();
		
		public boolean add(BookVO book) {
//			list.add(book);
//			return true;
//			동일 도서가 이미 장바구니에 있다면 이미 추가한 도서 입니다. 리턴
//			for (int i = 0; i<list.size(); i++) {
//				BookVO _book = list.get(i);
//				if ( _book.getIsbn().equals(book.getIsbn()))	return false;
//			}
			list.add(book);
			return true;
		}
		
		public List<BookVO> getList() {
//			카트 리스트는 대출상태 확인이 필요하다..
//			Bookvo 에 카트 vo??? 다른대서 안쓰니 변수 추가
//			카트는 db랑 소통????
			return list;
		}
		
		public boolean delete(String isbn) {
			for (int i = 0; i<list.size(); i++) {
				BookVO book = list.get(i);
				if ( book.getIsbn().equals(isbn) ){
					list.remove(i);
					return true;
				}
			}
			return false;
		}
		
		public boolean cartEmpty() {
			list.clear();
			return true;
		}
		
		public boolean cartSave() {
			list.clear();
			return true;
		}

}
