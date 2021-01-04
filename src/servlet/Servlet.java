package src.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		String type = req.getParameter("type");
		int value = Integer.parseInt(req.getParameter("value"));
		
		PrintWriter out = res.getWriter();
		out.println(" recebidos os valores: " + name + " " + type + " " + value);
	}
}
