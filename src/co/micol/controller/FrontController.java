package co.micol.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.command.BoardDelete;
import co.micol.command.BoardEdit;
import co.micol.command.BoardEditOk;
import co.micol.command.BoardList;
import co.micol.command.BoardNameSearch;
import co.micol.command.BoardReply;
import co.micol.command.BoardReplyOk;
import co.micol.command.BoardView;
import co.micol.command.BoardWrite;
import co.micol.command.BoardWriteOk;
import co.micol.command.Command;
import co.micol.command.MainCommand;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> list = null;
	
	
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Command>();
		list.put("/index.do", new MainCommand()); // url 에서 index.do 로 접속하면 MainCommand를 실행
		list.put("/boardlist.do", new BoardList());
		list.put("/boardNameSearch.do", new BoardNameSearch()); // 리스트 이름 검색
		list.put("/boardEdit.do", new BoardEdit()); // 글 수정
		list.put("/boardWrite.do", new BoardWrite()); // board를 쓰기위한 form 으로 보내는 주소
		list.put("/boardWriteOk.do", new BoardWriteOk());
		list.put("/boardView.do", new BoardView());  // 글 세부사항 페이지
		list.put("/boardEditOk.do", new BoardEditOk()); // 글 수정 후 저장
		list.put("/boardDelete.do", new BoardDelete()); // 글 삭제
		list.put("/boardReply.do", new BoardReply()); // 댓글 달기
		list.put("/boardReplyOk.do", new BoardReplyOk()); // 댓글 작성
		// list.put("/boardinsert.do", new BoardSave());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();	// URI 값을 얻음
		String context = request.getContextPath(); // URI 중 Context 값을 얻음
		String path = url.substring(context.length());	// Context 길이 이후의 값을 얻음
		Command subCommand = list.get(path);	// list HashMap 에 값을 넣어줌
		subCommand.execute(request, response); // list 의 매개값에 의한 결과 실행 => MainCommand 인스턴스 생성
		
	}

}
