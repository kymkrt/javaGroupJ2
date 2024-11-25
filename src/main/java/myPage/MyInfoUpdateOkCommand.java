package myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.MemberDAO;
import member.MemberVO;

public class MyInfoUpdateOkCommand implements MyPageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String realPath = request.getServletContext().getRealPath("/images/memberImg"); //서버의 저장될 파일의 경로
		int maxSize = 1024*1024*10;  //1024Byte=1KB=2^10, 1MB=1024KByte=2^20Byte=1024B*1024B 10메가. 계산해서 넣어도된다
		String encoding = "UTF-8";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, maxSize, encoding, new DefaultFileRenamePolicy());
		String originalFileName = multipartRequest.getOriginalFileName("fName"); //form에서 name으로 넘어오는것이므로 form의 name태그의 이름을 써야함
		String filesystemName = multipartRequest.getFilesystemName("fName");
	  String photoPath = filesystemName != null ? "/images/memberImg/" + filesystemName : ""; // 저장된 파일 경로
		
		//String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		//String memorymid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String userType = multipartRequest.getParameter("userType")==null ? "" : multipartRequest.getParameter("userType");
		String pwd = multipartRequest.getParameter("pwd")==null ? "" : multipartRequest.getParameter("pwd");
		String nickName = multipartRequest.getParameter("nickName")==null ? "" : multipartRequest.getParameter("nickName");
		String name = multipartRequest.getParameter("name")==null ? "" : multipartRequest.getParameter("name");
		String address = multipartRequest.getParameter("address")==null ? "" : multipartRequest.getParameter("address");
		String telMain = multipartRequest.getParameter("telMain")==null ? "0" : multipartRequest.getParameter("telMain");
		String telSub = multipartRequest.getParameter("telSub")==null  ? "0" : multipartRequest.getParameter("telSub");
		String email = multipartRequest.getParameter("email")==null ? "" : multipartRequest.getParameter("email");
		String content = multipartRequest.getParameter("content")==null ? "" : multipartRequest.getParameter("content");
		String userInfo = multipartRequest.getParameter("userInfo")==null ? "" : multipartRequest.getParameter("userInfo");
		String photo = multipartRequest.getParameter("photo")==null ? "" : multipartRequest.getParameter("photo");
		String advertiseCheck = multipartRequest.getParameter("advertiseCheck")==null ? "" : multipartRequest.getParameter("advertiseCheck");
		String fax = multipartRequest.getParameter("fax")==null ? "0" : multipartRequest.getParameter("fax");
		String pwdCheckQ = multipartRequest.getParameter("pwdCheckQ")==null ? "" : multipartRequest.getParameter("pwdCheckQ");
		String companyName = multipartRequest.getParameter("companyName")==null ? "" : multipartRequest.getParameter("companyName");
		String BSNum = multipartRequest.getParameter("BSNum")==null  ? "0" : multipartRequest.getParameter("BSNum");
		
		MemberVO vo  = new MemberVO();
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("sMid");
		
		vo.setMid(mid);
		//vo.setMemoryMid(memorymid);
		vo.setUserType(userType);
		vo.setPwd(pwd);
		vo.setNickName(nickName);
		vo.setName(name);
		vo.setAddress(address);
		vo.setTelMain(telMain);
		vo.setTelSub(telSub);
		vo.setEmail(email);
		vo.setContent(content);
		vo.setUserInfo(userInfo);
		vo.setAdvertiseCheck(advertiseCheck);
		vo.setFax(fax);
		vo.setPwdCheckQ(pwdCheckQ);
		vo.setCompanyName(companyName);
		vo.setBSNum(BSNum);
		
		vo.setPhoto(photoPath);
		
		MemberDAO dao = new MemberDAO();
		int res = dao.setMemberUpdateOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "회원정보가 수정되었습니다");
			request.setAttribute("url", "/MyPageMain.my"); //확장자패턴
		}else {
			request.setAttribute("message", "회원정보 수정에 실패하였습니다");
			request.setAttribute("url", "/MyPageMain.my"); //확장자패턴
		}
	}

}
