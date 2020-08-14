package jsh.project.boardReply.board.util;

import java.util.HashMap;
import java.util.Map;

public class Pagination {
	private int totalCount; //게시판의 총 게시글 값
	private int countList = 10;  //한 페이지내에 보여줄 게시글 값 
	private int countPage = 5;	//하단에 표시할 총 페이지 값 
	
	//DB 검색 조건
	private int startCount;
	private int endCount;
	
	//view 단에 필요한 값
	private int page;		//현재 페이지 값 
	private int totalPage;	//하단에 표시할 총 페이지 값 
	private int startPage;	//하단에 표시 될 첫번째 값
	private int endPage;	//하단에 표시 될 마지막 값
	
	public Pagination(int totalCount, int page) {
		this.totalCount = totalCount;
		this.page = page;
		init();
	}
	
	public int getPage() {
		return page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void init() {
		totalPage = (totalCount / countList);
		/*
		총 게시글(totalCount)를 한페이지당 보여줄 게시글 수(countList)로 나눴을때 나머지가 0 보다크다는것은
		게시글이 최소 1개이상 더 있다는 뜻이므로, 전체페이지를 하나더 추가해줘야함
		*/
		if(totalCount % countList > 0) {
			totalPage++;
		}
		
		/*
		 * 전체 페이지(totalPage) 보다 현재 page가 크다면, 현재 페이지를 totalPage로 맞춰준다.
		 * ex) 전체페이지는 24 인데 현재 페이지가 26이라면 현재 페이지를 24로 만들어주는 것임.
		 */
		if(totalPage < page){
			page = totalPage;
		}
		/*
		 * 하단에 표시될 페이지들을 출력해주기 위하여 startPage & endPage 를 계산해준다.
		 * 현재 페이지가 10안밖이라면 하단에는 1~10까지 표시되어야한다.
		 */
		startPage = ((page -1) / countPage) * countPage + 1;
		endPage = startPage + countPage - 1;  
		/*
		 * endPage가 totalPage보다 크다면, 마지막페이지를 전체페이지로 맞춰준다.
		 */
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		startCount = (page - 1) * countList + 1;
		endCount = page * countList;
	}
	
	public Map<String, Integer> getResultMap(){
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("startCount", startCount);
		resultMap.put("endCount", endCount);
		return resultMap;
	}
	
	@Override
	public String toString() {
		return "pagination { totalCount : "+ totalCount + " countList : " + countList +
				" countPage : " + countPage + " page : " + page + " totalPage : "
				+ totalPage + " startCount : " + startCount + " endCount : " + endCount + " startPage : "
				+ startPage + " endPage : " + endPage + " }";
	}
}
