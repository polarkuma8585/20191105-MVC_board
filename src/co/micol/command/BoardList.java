package co.micol.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db 목록가져오기
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = new ArrayList<>();
		list = dao.select();
		
		request.setAttribute("list", list); // 요청객체에  list라는 변수명에 값이 담긴 list를 담아 넘김.
		String path = "view/boardlist.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
