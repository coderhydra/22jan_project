package com.example.demo.cont;

import org.springframework.beans.factory.annotation.Autowired;                 
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.svc.PhotoBoardSVC;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.CommentVO;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("library/photoBoard")
public class PhotoBoardCont {
	
	@Autowired
	private PhotoBoardSVC svc;
	/*board create*/
	@GetMapping("/regi")
	public String getRegi() {
		return "/photoBoard/photoBoardRegi";
	}
	@PostMapping("/regi")
	@ResponseBody
	public String postRegi(BoardVO b) {
		int saved  = svc.addAndGetKey(b);
		return String.format("{\"saved\":%d}", saved);
	}
	/*board list*/
	@RequestMapping("")
	public String getFreeBoard(Model m) {
		return "redirect:/library/photoBoard/list/page/1";
	}
	/*board list pageInfo*/
	@GetMapping("/list/page/{pgNum}")
  public String getListByPage(@PathVariable("pgNum")String page, Model model) {
int pg = 0;
if (page.equals("undefined")) pg=1;
else pg = Integer.parseInt(page);
		PageInfo<BoardVO> pgInfo = svc.getListByPage(pg, 10);
     model.addAttribute("pageInfo", pgInfo);
     model.addAttribute("page",pgInfo.getPageNum());
   return "/photoBoard/photoBoard";
  }
	/*board read*/
	@GetMapping("/detail/{page}/{id}")
	public String detail(
			@PathVariable("page") int pg,
			@PathVariable("id") int id,
			Model m) {
		svc.boardCnt(id);
		m.addAttribute("detail",svc.getBoardById(id));
		m.addAttribute("page",pg);
		m.addAttribute("comments",svc.getCommentList(id));
		return "/photoBoard/photoBoardDetail";
	}
	/*board edit 수정창에서 뒤로버튼 눌렀을때 보던 페이지로 돌아가기 위한 메소드*/
	@GetMapping("/edit/{page}/{id}")
	public String getEdit(@PathVariable("id")int id,
			@PathVariable("page") int pg,
		Model m) {
		m.addAttribute("detail",svc.getBoardById(id));
		m.addAttribute("page",pg);
		return "/photoBoard/photoBoardEdit";
	}
	/*board edit*/
	@PostMapping("/edit")
	@ResponseBody
	public boolean postEdit(BoardVO b) {
		return svc.updateBoard(b);
	}
	/*board delete*/
	@GetMapping("/delete/{id}")
	@ResponseBody
	public boolean getDelete(@PathVariable("id")int id) {
		return svc.deleteBoard(id);
	}
	
	/*board comment create*/
	@PostMapping("/comment")
	@ResponseBody
	public int postComment(
			CommentVO c) {
		return svc.insertComment(c);
	}

	/*board comment edit*/
	@PostMapping("/commentEdit")
	@ResponseBody
	public boolean postEdit(CommentVO c) {
		return svc.updateComment(c);
	}
	/*board delete*/
	@GetMapping("/comentDelete/{page}/{pid}/{id}")
	public String commentDel(
			@PathVariable("page")int page,
			@PathVariable("pid")int pid,
			@PathVariable("id")int id
			) {
			svc.deleteComment(id);
		return "redirect:/library/photoBoard/detail/"+page+"/"+pid;
	}
	
	/*검색후 페이지연결 기본 페이지는 뷰에서 1로줌 검색종류와 검색어 받아옴*/
	@GetMapping("/search/{page}/{cmd}/{word}")
	public String getSearch(
			@PathVariable("page") int pg,
			@PathVariable("cmd") String cmd,
			@PathVariable("word") String word,
			Model m
			) {
		PageInfo<BoardVO> pgInfo = svc.getSearchListByPage(pg, 10,cmd, word);
    m.addAttribute("pageInfo", pgInfo);
    m.addAttribute("page",pgInfo.getPageNum());
  return "/photoBoard/photoBoard";
	}
	//검색결과 boolean
	@PostMapping("/search")
	@ResponseBody
	public String postSearch(
			@RequestParam("cmd") String cmd,
			@RequestParam("word") String word
			) {
		PageInfo<BoardVO> pgInfo = svc.getSearchListByPage(1, 10,cmd, word);
    return String.format("{\"ok\":%b}", pgInfo.hasContent());
	}
	
}