package cn.nmb.draw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//获取到请求资源路径
		String uri = request.getRequestURI();
		System.out.println(uri);
			//URI 请求资源路径是：/web66/test.do
			//URL 完整的地址：http://127.0.0.1:8080/web66/test.do
		
		int beginIndex = uri.indexOf("/", 1);
		String path = uri.substring(beginIndex);
		System.out.println(path);
		
		test2 t = new test2();
		
		//根据请求的路径，进行相应的处理
		if("/Draw.do".equals(path)) {
			t.draw(request, response);
		}
		
	}
}






