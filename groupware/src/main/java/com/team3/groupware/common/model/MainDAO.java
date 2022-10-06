package com.team3.groupware.common.model;

import java.util.List;
import java.util.Map;

import com.team3.groupware.eunji.model.BoardVO;

public interface MainDAO {

	List<BoardVO> allBoardView(Map<String, Object> boardMap);

}
