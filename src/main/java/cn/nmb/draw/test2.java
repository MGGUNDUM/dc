package cn.nmb.draw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test2 {

	public void draw(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException{
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("抽卡次数");
		
		//request.setAttribute("card", d.getId());
		System.out.println();
		int n;
		if(num.equals("十连")) {
			n=10;
		}else {
			n=1;
		}
		Draw d = new Draw(n);
		request.setAttribute("card", d.getId());
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
}
