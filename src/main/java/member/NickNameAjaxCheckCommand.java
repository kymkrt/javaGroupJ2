package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NickNameAjaxCheckCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickName = request.getParameter("nickName")==null ? "" : request.getParameter("nickName");

		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.getMemberNickNameCheck(nickName);
		String res = "0";
		
		if(vo.getNickName() != null && !vo.getNickName().equals("")) res= "1";
		response.getWriter().write(res); //res가 0 중복아님 1이면 중복
	}

}
