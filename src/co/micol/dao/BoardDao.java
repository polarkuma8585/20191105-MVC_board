package co.micol.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.dto.BoardDto;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "jaeheum";
	private String pw = "jaeheum";

	public BoardDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
	}

	public ArrayList<BoardDto> select() { // 전체 리스트
		ArrayList<BoardDto> list = new ArrayList<>();
		BoardDto dto = new BoardDto();
		String sql = "select * from mvc_board";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDto();
				dto.setId(rs.getInt("bid"));
				dto.setName(rs.getString("bname"));
				dto.setTitle(rs.getString("btitle"));
				dto.setContents(rs.getString("bcontent"));
				dto.setwDate(rs.getDate("bdate"));
				dto.setHit(rs.getInt("bhit"));
				dto.setGroup(rs.getInt("bgroup"));
				dto.setStep(rs.getInt("bstep"));
				dto.setIndent(rs.getInt("bindent"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	public BoardDto select(int id) { // 세부 목록 조회
		BoardDto dto = new BoardDto();
		String sql = "select * from mvc_board where bid =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDto();
//				dto.setId(rs.getInt("bid"));
				dto.setName(rs.getString("bname"));
				dto.setTitle(rs.getString("btitle"));
				dto.setContents(rs.getString("bcontent"));
				dto.setwDate(rs.getDate("bdate"));
				dto.setHit(rs.getInt("bhit"));
//				dto.setGroup(rs.getInt("bgroup"));
//				dto.setStep(rs.getInt("bstep"));
//				dto.setIndent(rs.getInt("bindent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return dto;
	}

	public int insert(BoardDto dto) { // 글 추가
		int n = 0;
		String sql = "insert into mvc_board (bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent)"
				+ "values(b_num.nextval, ?, ?, ?, ?, 0, b_num.currval, 0, 0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContents());
			pstmt.setDate(4, dto.getwDate());
			n = pstmt.executeUpdate();
			
			System.out.println(dto.getName() + "님의 글이 "+ dto.getwDate()+" 의 시간에 정상적으로" + n +" 건 추가되었습니다.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	public int update(BoardDto dto) { // 글 수정
		int n = 0;

		return n;
	}

	public int delete(int id) { // 글 삭제
		int n = 0;

		return n;
	}

	private void close() {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
