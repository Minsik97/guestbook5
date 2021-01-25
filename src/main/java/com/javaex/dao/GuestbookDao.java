package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;
	
	//리스트 가져오기
	public List<GuestbookVo> getgdList() {
		System.out.println("리스트");
		
		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.selectList");
		
		return guestbookList;
	}
	
	//등록
	public int gbInsert(GuestbookVo guestbookVo) {
		System.out.println("등록");
		
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		
		return count;
	}
	
	//삭제
	public int gbDelete(int no, String password) {
		System.out.println("삭제");
		
		Map<String, Object>gbMap = new HashMap<String, Object>();
		gbMap.put("no", no);
		gbMap.put("password", password);
		
		System.out.println(gbMap.toString());
		
		return sqlSession.delete("guestbook.delete", gbMap);
		
	}
	
}
