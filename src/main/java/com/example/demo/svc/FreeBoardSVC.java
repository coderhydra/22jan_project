package com.example.demo.svc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.CommentVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class FreeBoardSVC {

	@Autowired
	private BoardDAO dao;
	
	@Autowired
	HttpSession session;
	
	public int addAndGetKey(BoardVO b) {
		b.setWriter((String) session.getAttribute("uid"));
		System.err.println(b.getWriter());
		return dao.addAndGetKey(b);
	}
	
  public BoardVO  getBoardById(int id) {
  	return dao.getBoardById(id);
  }
  public List<BoardVO> getBoardList(){
	return dao.getBoardList();
}
  public PageInfo<BoardVO> getListByPage(int pg, int pageSize) {
		PageInfo<BoardVO> pgInfo = dao.getBoardListPage(pg, pageSize);
		//현재페이지에서 -5 +5 해서 최대 11개만 브라우저에 표시한다!
   return pgInfo;
	}
  
  public boolean updateBoard(BoardVO b) {
  	return dao.updateBoard(b);
  }

	public boolean deleteBoard(int id) {
		BoardVO b = new BoardVO();
		b.setId(id);
		return dao.deleteBoard(b);
	}
	//로그인 세션에서 uid로 작성자 변경 섹션 게시판종류
	public boolean insertComment(CommentVO c) {
		c.setSection("free");
		c.setWriter("eeni");
		return dao.insertComment(c);
	}

	public List<CommentVO> getCommentList(int parent_id) {
		   return dao.getCommentList(parent_id);
	}

	public boolean deleteComment(int id) {
		return dao.deleteComment(id);
	}

	public boolean updateComment(CommentVO c) {
		return dao.updateComment(c);
	}

	public int boardCnt(int id) {
		return dao.boardCnt(id);
	}
	
	/*검색기능*/
	public PageInfo<BoardVO> getSearchListByPage(int pg, int i, String cmd, String word) {
		return dao.getSearchListByPage(pg,i,cmd,word);
	}

}//end C
