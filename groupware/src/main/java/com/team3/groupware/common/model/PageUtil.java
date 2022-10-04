package com.team3.groupware.common.model;

public class PageUtil {
	
	private int curPage;		// 현재 페이지
	private int prevPage;		// 이전 페이지
	private int nextPage;		// 다음 페이지
	private int totPage;		// 전체 페이지 개수
	private int totBlock;		// 전체 페이지 블록 개수
	private int curBlock;		// 현재 블록
	private int prevBlock;		// 이전 블록
	private int nextBlock;		// 다음 블록
	private int pageBegin;		// 시작
	private int pageEnd;		// 끝
	private int blockBegin;		// 블록의 시작페이지 번호
	private int blockEnd;		// 블록의 끝 페이지 번호
	public static final int PAGE_SCALE = 5;		// 페이지당 게시물수
	public static final int BLOCK_SCALE = 5;	// 화면(블록)당 페이지 수
	
	public PageUtil(int count, int curPage) {
		curBlock = 1;			// 현재 블록 번호
		this.curPage = curPage;	// 현재 페이지 번호
		setTotPage(count);		// 전체 페이지 갯수 계산
		setPageRange();			// 
		setTotBlock();			// 전체 블록 갯수 계산
		setBlockRange();		// 블록의 시작, 끝 번호 계산
	}

	private void setPageRange() {
		pageBegin = (curPage - 1) * PAGE_SCALE +1;
		pageEnd = pageBegin + PAGE_SCALE -1;
	}

	//블록의 시작, 끝 번호 계산 ( (현재페이지-1) /10 +1 )
	public void setBlockRange() {
		//원하는 페이지가 몇번째 블록에 속하는지 계산
		curBlock = (int) Math.floor((curPage-1)/BLOCK_SCALE)+1;
		//블록의 시작페이지,끝페이지 번호 계산
		blockBegin = (curBlock -1)*BLOCK_SCALE +1;
		blockEnd = blockBegin+BLOCK_SCALE -1;
		// 블록 끝이 전체 페이지보다 클 경우
		// -> prevPage, nextPage를 다시 세팅.
		if(blockEnd>totPage) {
			blockEnd = totPage;
			prevPage = (curBlock==1)?1:(curBlock-1)*BLOCK_SCALE; 
			nextPage = (curBlock>totBlock)?
				(curBlock*BLOCK_SCALE) : (curBlock * BLOCK_SCALE)+1;
		}
		if(nextPage >= totPage) {
			nextPage = totPage;
		}
	}
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int count) {
		totPage = (int) Math.ceil(count * 1.0 / PAGE_SCALE);
	}

	public int getTotBlock() {
		return totBlock;
	}

	public void setTotBlock() {
		totBlock = totPage * 1/BLOCK_SCALE;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}


}
