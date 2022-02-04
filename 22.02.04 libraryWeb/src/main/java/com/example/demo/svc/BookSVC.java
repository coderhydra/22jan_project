package com.example.demo.svc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.dao.RecordDAO;
import com.example.demo.util.Cart;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.RecordVO;
import com.github.pagehelper.PageInfo;

@Service
public class BookSVC {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private BookDAO book;
	
	@Autowired
	private RecordDAO recordDao;
	
	@Autowired
	private Cart cart;
	
	public List<BookVO> search(String keyWord){
		return book.search(keyWord);
	}
	
  public PageInfo<BookVO> getSearchByPage(int pg, int pageSize,String keyWord) {
		PageInfo<BookVO> pgInfo = book.getSearchListPage(pg, pageSize,keyWord);
   return pgInfo;
	}

	public Object searchIsbn(String isbn) {
		return book.searchIsbn(isbn);
	}
	

	public boolean toCart(BookVO book) {
	if( session.getAttribute("cart") == null ) { 
			session.setAttribute("cart", cart);
			System.err.println("서비스에서 카트주기");
		}
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.add(book);
	}
	
	public List<RecordVO> showCart() {
		Cart cart = (Cart) session.getAttribute("cart");
//	카트 리스트는 대출상태 확인이 필요하다..
//리스트를 받아서 db에서 대출/예약 정보를 추가 한다.
		List<RecordVO> newList = new ArrayList<>();
		List<BookVO> list = new ArrayList<>();
		list = cart.getList();
	for (int i=0; i<list.size(); i++) {
		BookVO book = new BookVO();
		book = list.get(i);
		RecordVO castRecord = new RecordVO();
		// booklist 에 대출현황을 포함함 recordVO로 가공 반환하다.
		castRecord.setIsbn(book.getIsbn());
		castRecord.setTitle(book.getTitle());
		castRecord.setAuthor(book.getAuthor());
		castRecord.setPublisher(book.getPublisher());
		castRecord.setImageUrl(book.getImageUrl());
//		castRecord.setIsbn(book.getIsbn());
//		castRecord.setRent_time(db)
//		castRecord.setReturn_time(db);
//		castRecord.setReserve(db);
			newList.add(castRecord);
	}
	return newList;
	}

	public boolean delete(String isbn) {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.delete(isbn);
	}

	public boolean cartEmpty() {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.cartEmpty();
		
	}

	public boolean rent(String isbn) {
		String uid = (String) session.getAttribute("uid");
		Cart cart = (Cart) session.getAttribute("cart");
		List<BookVO> list = cart.getList();
		RecordVO record = new RecordVO();
		for(int i=0; i<cart.getList().size(); i++) {
				record.setUid(uid);
				record.setIsbn(list.get(i).getIsbn());
				record.setImageUrl(list.get(i).getImageUrl());
				record.setAuthor(list.get(i).getAuthor());
				record.setTitle(list.get(i).getTitle());
				record.setPublisher(list.get(i).getPublisher());
		}
		//대출확인 로직 디비에서 응답하면 대출중이다.
		if (recordDao.status(record)==null) {
			if (recordDao.insertRent(record)>0) {
				return true;
			}
			return false;
		}
		return false;
		}
	
	public int reserve(String isbn) {
		String uid = (String) session.getAttribute("uid");
		Cart cart = (Cart) session.getAttribute("cart");
		List<BookVO> list = cart.getList();
		RecordVO record = new RecordVO();
		for(int i=0; i<cart.getList().size(); i++) {
			if (isbn.equals(list.get(i).getIsbn())) {
				record.setUid(uid);
				record.setIsbn(list.get(i).getIsbn());
				record.setImageUrl(list.get(i).getImageUrl());
				record.setAuthor(list.get(i).getAuthor());
				record.setTitle(list.get(i).getTitle());
				record.setPublisher(list.get(i).getPublisher());
			}
		}
		int no = recordDao.insertReserve(record);
		if (no>0) {
			return no;
		}
		return 0;
	}

public int reserveNo(String isbn) {
	RecordVO record = new RecordVO();
	record.setIsbn(isbn);
	int no =  recordDao.reserveNo(record).getReserve();
	return no;
}

	public boolean delivery(String isbn) {
		String uid = (String) session.getAttribute("uid");
		Cart cart = (Cart) session.getAttribute("cart");
		List<BookVO> list = cart.getList();
		RecordVO record = new RecordVO();
		for(int i=0; i<cart.getList().size(); i++) {
			if (isbn.equals(list.get(i).getIsbn())) {
				record.setUid(uid);
				record.setIsbn(list.get(i).getIsbn());
				record.setImageUrl(list.get(i).getImageUrl());
				record.setAuthor(list.get(i).getAuthor());
				record.setTitle(list.get(i).getTitle());
				record.setPublisher(list.get(i).getPublisher());
			}
		}
		//대출확인 로직 디비에서 응답하면 대출중이다.
		if (recordDao.status(record)==null) {
			int no = recordDao.insertDelivery(record);
			if (no>0) {
				return true;
			}
			return false;
		}
		return false;
	}
}