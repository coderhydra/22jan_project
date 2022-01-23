package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.bbsVO;

@Mapper
public interface bbsMapper {

  @Insert
  /*JDBC template == ? 를 대신함 셋겟 필요*/
  ("INSERT INTO library_bbs VALUES(NULL,#{name},#{phone},#{email})")
  /*리턴되는값 추상매소드*/
  int insertUser(bbsVO vo);

  /* 행을 추가하고 자동증가필드의 값을 파라미터로 전달된 UserVO 의 num 변수에 저장*/
  @Insert("INSERT INTO library_bbs VALUES(NULL,#{name},#{phone},#{email})")
  /*키를 가져올때는 넣어줘야하는 로직
   * 한행을 삽입하고 프라이머리키를 가져온다*/
  @Options(useGeneratedKeys = true, keyProperty = "num")
  int addAndGetKey(bbsVO vo);

  /*파라미터의 넘을 sql에서 찾아준다. new User 필요 없다.*/
  @Select("SELECT * FROM library_bbs WHERE no = #{no}")
  bbsVO getBBSById( int no);
  
  @Select("SELECT * FROM library_bbs WHERE no = #{no} AND name=#{name}")
  bbsVO getUser(bbsVO vo);
  
  /*다수횅을 찾아줌*/
  @Select("SELECT * FROM library_bbs")
  List<bbsVO> getUserList();

  /*업데이트*/
  @Update("UPDATE library_bbs SET phone=#{phone}, email=#{email} "+
        "WHERE num=#{no}")
  int updateUser(bbsVO vo);
  
  /*삭제*/
  @Delete("DELETE FROM library_bbs WHERE no=#{no}")
  int deleteUser( int no);
}
