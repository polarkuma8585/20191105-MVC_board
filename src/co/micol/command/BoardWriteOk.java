package co.micol.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardWriteOk implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = 0;
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();

//		String name = request.getParameter("name");
//		String title = request.getParameter("title");
//		Date date =  Date.valueOf(request.getParameter("date"));
//		String contents = request.getParameter("contents");

		// dto.setName(name);
		dto.setName(request.getParameter("name"));
		// dto.setTitle(title);
		dto.setTitle(request.getParameter("title"));
		// dto.setwDate(date);
		dto.setwDate(Date.valueOf(request.getParameter("date")));
		// dto.setContents(contents);
		dto.setContents(request.getParameter("contents"));
		
		n = dao.insert(dto);
		
		String path = null;
		if (n != 0) {
			path = "boardlist.do"; // 성공시 목록 보여주기
			response.sendRedirect(path); // insert 가 종료되었기 때문에 request 객체를 없애고 새로 만듬.
		} else {
			path = "view/boardinsertfail.jsp"; // 실패시 실패 페이지 보여주기
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);  // 실패시에만 request객체를 가져감.
			dispatcher.forward(request, response);
		}


		

	}

}
