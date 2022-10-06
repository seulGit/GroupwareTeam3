package com.team3.groupware.common.service;

import java.util.List;
import java.util.Map;

import com.team3.groupware.eunji.model.BoardVO;

public interface MainService {

	List<BoardVO> allBoardView(Map<String, Object> boardMap);

}
