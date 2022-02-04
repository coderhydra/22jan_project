package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.BoardVO;
import com.example.demo.vo.CommentVO;

@Mapper
public interface PhotoBoardMapper {
	int insertBoard(BoardVO b);
  int addAndGetKey(BoardVO b);
  BoardVO  getBoardById(int id);
List<BoardVO> getBoardList();
int updateBoard(BoardVO b);
BoardVO findWithoutId(BoardVO b);
int deleteBoard(BoardVO b);
int insertComment(CommentVO c);
List<CommentVO> getCommentList(int parent_id);
int deleteComment(int id);
int updateComment(CommentVO c);
//조회수 카운트
int boardCnt(int id);
//검색기능
List<BoardVO> getSearchTitle(BoardVO key);
List<BoardVO> getSearchBoth(BoardVO key);
List<BoardVO> getSearchContent(BoardVO key);
List<BoardVO> getSearchWriter(BoardVO key);
}
