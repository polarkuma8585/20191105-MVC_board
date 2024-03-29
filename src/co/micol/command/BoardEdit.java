package co.micol.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardEdit implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		
		
		
		dto = dao.boardEditSelect(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("dto", dto);
		
		String path="view/boardedit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
		
	}

}
