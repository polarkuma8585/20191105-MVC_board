package co.micol.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardView implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<BoardDto> list = new ArrayList<>();
			BoardDao dao = new BoardDao();
			//BoardDto dto = new BoardDto();
			
			int id = Integer.parseInt(request.getParameter("id"));
			list = dao.select(id);
			
			int length = list.size();
			
			request.setAttribute("list", list);
			request.setAttribute("length", length); //리스트 사이즈
			
			String path = "view/boardview.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
	}

}
