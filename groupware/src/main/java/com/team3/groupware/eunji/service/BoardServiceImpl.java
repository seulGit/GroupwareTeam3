package com.team3.groupware.eunji.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team3.groupware.eunji.model.BoardDAO;
import com.team3.groupware.eunji.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;

	// 게시글 작성
	@Override
	public void board_write_insert(BoardVO boardVo) {
		this.boardDao.board_write_insert(boardVo);
		
	}

	// 게시글 리스트 불러오기
	@Override
	public List<BoardVO> board_selectList(BoardVO boardVo) {
		return boardDao.board_selectList(boardVo);
		
	}

	// 게시판 디테일 페이지
	@Override
	public Map<String, Object> board_detail(Map<String, Object> map) {
		return boardDao.board_detail(map);
	}
	


}
