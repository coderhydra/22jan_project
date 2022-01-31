package com.example.demo.svc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.dao.RecordDAO;
import com.example.demo.util.Cart;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.RecordVO;

@Service
public class BookSVC {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private BookDAO book;
	
	@Autowired
	private RecordDAO recordDao;
	
	public List<BookVO> search(String keyWord){
		return book.search(keyWord);
	}

	public Object searchIsbn(String isbn) {
		return book.searchIsbn(isbn);
	}
	

	public boolean toCart(BookVO book) {
	if( session.getAttribute("cart") == null ) { 
			session.setAttribute("cart", new Cart());
			System.err.println("서비스에서 카트주기");
		}
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.add(book);
	}
	
	public List<BookVO> showCart() {
		Cart cart = (Cart) session.getAttribute("cart");
		return cart.getList();
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
			if (isbn.equals(list.get(i).getIsbn())) {
				record.setUid(uid);
				record.setIsbn(list.get(i).getIsbn());
				record.setAuthor(list.get(i).getAuthor());
				record.setTitle(list.get(i).getTitle());
				record.setPublisher(list.get(i).getPublisher());
			}
		}
		if (recordDao.insert(record)>0) return true;
		return false;
	}


}
