package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.FreeBoardMapper;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.CommentVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Repository
public class BoardDAO {

	@Autowired
	private FreeBoardMapper mapper;
	
//	public int insertBoard(BoardVO b);
  public int addAndGetKey(BoardVO b) {
  	return mapper.addAndGetKey(b);
  }
  
  public BoardVO  getBoardById(int id) {
  	return mapper.getBoardById(id);
  }
	public List<BoardVO> getBoardList(){
		return mapper.getBoardList();
	}
	/** Open Source, MyBatis PageHelper 사용 예
	 * @param int pageNum : 추출하고자 하는 목록의 페이지 번호
	 * @param int pageSize : 한 페이지(화면)에 보여줄 목록의 아이템 수
	 * @return PageInfo : 목록의 한 페이지 아이템들과 페이징 관련 정보를 저장한 객체
	 */
	/*
	//PageHelper 페이지 를 넣어주는 클래스
	//다오위치
	 * 리스트를 받아온다음 페이지 정보를 추가 그담 jsp로....
	 * 1.마이바티스에서 리스트를 받는다.
	 * 2. 페이지 인포를 추가한다.
	 * 	1.몇페이지인가? int pageNum
	 * 	2.한페이지에 몇개를 보여줄 것인가? int pageSize
	 * 3. 리턴한다.
	 * 스타트 페이지 는 페이지 넘버와 페이지 사이즈 
	*/
	public PageInfo<BoardVO> getBoardListPage(int pageNum, int pageSize){
	   PageHelper.startPage(pageNum, pageSize);
	   PageInfo<BoardVO> pageInfo = new PageInfo<>(mapper.getBoardList());
	   return pageInfo;
	}
	
	//public int updateBoard(BoardVO b);
	//public int deleteBoard(int id);
	//public BoardVO findWithoutId(BoardVO b);
	
	public boolean  updateBoard(BoardVO b) {
		if(mapper.updateBoard(b)>0)return true;
		return false;
	}
	
	public boolean deleteBoard(BoardVO b) {
		if(mapper.deleteBoard(b)>0)return true;
		return false;
	}

	public boolean insertComment(CommentVO c) {
		if (mapper.insertComment(c)>0) return true;
		return false;
	}

	public List<CommentVO> getCommentList(int parent_id) {
		List<CommentVO> loadList =  mapper.getCommentList(parent_id);
		List<CommentVO> newList = new ArrayList<>();
		for(int i=0; i<loadList.size(); i++) {
			CommentVO newBoard = new CommentVO();
			if(loadList.get(i).getDelete_yn().equals("N")&&
					loadList.get(i).getParent_id()==parent_id
					) {
				newBoard.setParent_id(loadList.get(i).getParent_id());
				newBoard.setId(loadList.get(i).getId());
				newBoard.setWriter(loadList.get(i).getWriter());
				newBoard.setComment(loadList.get(i).getComment());
				newBoard.setTime(loadList.get(i).getTime());
				newBoard.setSection(loadList.get(i).getSection());
				newList.add(newBoard);
			}
		}
	   return newList;
	}
	public boolean deleteComment(int id) {
	if(mapper.deleteComment(id)==1) return true;
	return false;
	}

	public boolean updateComment(CommentVO c) {
		if(mapper.updateComment(c)>0) return true;
		return false;
	}

	public int boardCnt(int id) {
		return mapper.boardCnt(id);
	}
	
	
	//검색 cmd 분기 title,content,both,writer
	public PageInfo<BoardVO> getSearchListByPage(int pageNum, int pageSize, String cmd, String word) {
		BoardVO key = new BoardVO();
		key.setTitle(word);
		PageHelper.startPage(pageNum, pageSize);
		if(cmd.equals("title")) {
			PageInfo<BoardVO> pageInfo = new PageInfo<>(mapper.getSearchTitle(key));
			return pageInfo;
		}
		if(cmd.equals("content")) {
			System.err.println("dao______"+key.getTitle());
			PageInfo<BoardVO> pageInfo = new PageInfo<>(mapper.getSearchContent(key));
			return pageInfo;
		}
		if(cmd.equals("both")) {
			PageInfo<BoardVO> pageInfo = new PageInfo<>(mapper.getSearchBoth(key));
			return pageInfo;
		}
		if(cmd.equals("writer")) {
			PageInfo<BoardVO> pageInfo = new PageInfo<>(mapper.getSearchWriter(key));
			return pageInfo;
		}
	   return null;
	}


}