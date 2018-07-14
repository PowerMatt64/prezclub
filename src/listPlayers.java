import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listPlayers extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         response.setStatus(HttpServletResponse.SC_OK);
         response.getWriter().println("<head>\r\n" + "  <link rel=\"stylesheet\" href=\"index.css\">\r\n" + "</head>");
         response.getWriter().println("<a href='/'>Home</a>");
         response.getWriter().println("<table>");
         response.getWriter().println("<tr>");
    	 response.getWriter().println("<th>PFP</th>");
    	 response.getWriter().println("<th>Name</th>");
    	 response.getWriter().println("<th>DiscordId</th>");
    	 response.getWriter().println("<th>Kick</th>");
    	 response.getWriter().println("<th>Ban</th>");
    	 response.getWriter().println("</tr>");
         /*for(Entry<Integer, Map<String, Object>> b: web.books.entrySet()) {
        	 response.getWriter().println("<tr>");
        	 response.getWriter().println("<td>"+b.getValue().get("bookId")+"</td>");
        	 response.getWriter().println("<td>"+b.getValue().get("Author")+"</td>");
        	 response.getWriter().println("<td>"+b.getValue().get("BookName")+"</td>");
        	 response.getWriter().println("<td>"+b.getValue().get("Amount")+"</td>");
        	 response.getWriter().println("<td>"+b.getValue().get("MinRe")+"</td>");
        	 response.getWriter().println("<td>"+b.getValue().get("Min")+"</td>");
        	 response.getWriter().println("<td>"+"<a href='/deletebook?id="+b.getValue().get("bookId")+"'>Sell</a></td>");
        	 response.getWriter().println("<td>"+"<a href='/exterminate?id="+b.getValue().get("bookId")+"'>Delete</a></td>");
        	 response.getWriter().println("</tr>");
        }*/
         response.getWriter().println("</table>");
         

}
}