package co.micol.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardNameSearch implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BoardDto> list = new ArrayList<>();
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();

		String name = request.getParameter("name");

		list = dao.nameSearchList(name);

		request.setAttribute("list", list);
		String path = "view/boardlistbyname.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
