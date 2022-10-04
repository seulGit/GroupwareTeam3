package com.team3.groupware.eunji.model;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

	void board_write_insert(BoardVO boardVo);

	List<BoardVO> board_selectList(BoardVO boardVo);

	Map<String, Object> board_detail(Map<String, Object> map);



}
