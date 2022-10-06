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

	// 게시판 디테일 페이지에서 데이터 불러오기
	@Override
	public Map<String, Object> board_detail(Map<String, Object> map) {
		return session.selectOne("board.board_detail", map);
	}

	// 게시글 수정
	@Override
	public void board_modify(BoardVO boardVo) {
		this.session.update("board.board_modify", boardVo);
	}

	// 게시글 삭제
	@Override
	public void board_delete(BoardVO boardVo) {
		this.session.delete("board.board_delete", boardVo);
		
	}

	// 게시글 검색
	@Override
	public List<Map<String, Object>> board_search(Map<String, Object> map) {
		return session.selectList("board.board_search", map);
	}

	// 조회수 증가
	@Override
	public int board_view_plus(int board_num) {
		return session.update("board.view_plus", board_num);
	}

	// 공지게시판 리스트 불러오기 -정치-
	@Override
	public List<BoardVO> board_selectNTList(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return session.selectList("board.board_notice_selectList", boardVo);
	}

}
