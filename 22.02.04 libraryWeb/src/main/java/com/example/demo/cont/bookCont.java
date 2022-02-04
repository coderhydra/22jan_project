package com.example.demo.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.svc.BookSVC;
import com.example.demo.vo.BookVO;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/library")
public class bookCont {

	@Autowired
	private BookSVC bookSvc;
	
	@GetMapping("bookSearch")
	public String bookSerch() {
		return "/book/bookSearch";
	}
	@GetMapping("bookSearch/{keyWord}")
	public String bookSearch(@PathVariable("keyWord")String keyWord,
			Model m) {
		m.addAttribute("bookList",bookSvc.search(keyWord));
		//페이지헬퍼 연결
		return "/book/bookSearchList";
	}
	
	/*board list pageInfo*/
	@GetMapping("/bookSearch/page/{pgNum}/{keyWord}")
  public String getListByPage(@PathVariable("pgNum") String page,
  		@PathVariable("keyWord")String keyWord,
  		Model model) {
int pg = 0;
if (page.equals("undefined")) pg=1;
else pg = Integer.parseInt(page);
		PageInfo<BookVO> pgInfo = bookSvc.getSearchByPage(pg, 3, keyWord);
     model.addAttribute("pageInfo", pgInfo);
     model.addAttribute("page",pgInfo.getPageNum());
   return "/book/bookSearchList";
  }
	
	@GetMapping("bookDetail/{isbn}")
	public String bookDetail(@PathVariable("isbn")String isbn,
			Model m) {
		m.addAttribute("book",bookSvc.searchIsbn(isbn));
		return "/book/bookDetail";
	}
	@GetMapping("/cart")
	public String showCart(Model m) {
		m.addAttribute("list", bookSvc.showCart());
		return "/book/showCart";
	}
	@PostMapping("/cart/tocart")
	@ResponseBody
	public String toCart(BookVO book) {
		return String.format("{\"ok\":%b}", bookSvc.toCart(book));
	}
  @GetMapping("/cart/delelte/{isbn}")
  public String deleteBook(@PathVariable("isbn")String isbn, Model model) {
  	bookSvc.delete(isbn);
     return "redirect:/library/cart";
  }
  @GetMapping("/cartempty")
  public String cartEmpty() {
     bookSvc.cartEmpty();
     return "redirect:/library/cart";
  }
  
  @PostMapping("/cart/rent/{isbn}")
  @ResponseBody
  public String rent(@PathVariable("isbn")String isbn) {
  return String.format("{\"ok\":%b}", bookSvc.rent(isbn));
  }
  @PostMapping("/cart/reserve/{isbn}")
  @ResponseBody
  public String reserve(@PathVariable("isbn")String isbn) {
  return String.format("{\"num\":%d}", bookSvc.reserve(isbn));
  }
  
  @PostMapping("/cart/delivery/{isbn}")
  @ResponseBody
  public String delivery(@PathVariable("isbn")String isbn) {
  return String.format("{\"ok\":%b}", bookSvc.delivery(isbn));
  }
}
