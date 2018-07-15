import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class kickMember extends HttpServlet {
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		String id = (request.getParameter("userid"));
		
		Map<String, Object> user = (Map<String, Object>) Userstore.getinstance();
		
		//System.out.print(user.get(id));
		
		
		
		response.sendRedirect("/listPlayers");
	}
	
	

}
