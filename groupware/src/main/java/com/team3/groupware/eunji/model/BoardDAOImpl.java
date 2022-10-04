package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	SqlSessionTemplate session;

	// 게시글 작성
	@Override
	public void board_write_insert(BoardVO boardVo) {
		this.session.insert("board.board_write_insert", boardVo);
		
	}

	// 게시글 리스트 불러오기
	@Override
	public List<BoardVO> board_selectList(BoardVO boardVo) {
		return session.selectList("board.board_normal_selectList", boardVo);
		
	}

	// 게시판 디테일 페이지
	@Override
	public Map<String, Object> board_detail(Map<String, Object> map) {
		return session.selectOne("board.board_detail", map);
	}



}
