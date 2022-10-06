package com.team3.groupware.eunji.service;

import java.util.List;
import java.util.Map;

import com.team3.groupware.eunji.model.BoardVO;

public interface BoardService {

	void board_write_insert(BoardVO boardVo);

	List<BoardVO> board_selectList(BoardVO boardVo);

	Map<String,Object> board_detail(Map<String, Object> map);

	void board_modify(BoardVO boardVo);



}
