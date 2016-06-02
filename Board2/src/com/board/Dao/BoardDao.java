package com.board.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.board.beans.BoardDto;
import com.board.util.DBManager;

public class BoardDao {

	// 리스트 보기
	public ArrayList<BoardDto> bList() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBManager db = new DBManager();
		
		try{
			conn = db.connect();
			String sql = "select bseq, title, content, regid, to_char(regdate) as regdate"+
			"from board order by bseq";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardDto dto = new BoardDto();
				dto.setBseq(rs.getInt("bseq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegid(rs.getString("regid"));
				dto.setRegdate(rs.getString("regdate"));
				//빈 객체에 ArrayList를 이용하여 담음
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			db.close(rs, pstmt, conn);
		}
		// ArrayList 출력
		return list; 
	}
	
	public int bInsert(BoardDto dto) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBManager db = new DBManager();
		
		try{
			conn = db.connect();
			String sql = "insert into board2(bseq, title, content, img_path, img_oname, img_name, regid, regdate)"+
			"values (seq.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			
			// preparedStatement에 쿼리 내용을 담음
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getImg_path());
			pstmt.setString(4, dto.getImg_oname());
			pstmt.setString(5, dto.getImg_name());
			pstmt.setString(6, dto.getRegid());
			
			// int형 변수에 쿼리 업데이트를 대입
			res = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		// 쿼리 업데이트 리턴
		return res;
	}
}
