import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

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
         response.getWriter().println("<div style=\"width:60%; height:80%; overflow:auto;\">");
         response.getWriter().println("<table>");
         response.getWriter().println("<tr>");
    	 response.getWriter().println("<th>ID</th>");
    	 response.getWriter().println("<th>Name</th>");
    	 //response.getWriter().println("<th>DiscrimId</th>");
    	 response.getWriter().println("<th>Kick</th>");
    	 //response.getWriter().println("<th>Ban</th>");
    	 response.getWriter().println("</tr>");
    	 response.getWriter().println("<tbody>");
    	 Map<String, String> sorted = new TreeMap<>();
    	 for(Entry<String, String> u: Userstore.getinstance().listUsers()) {
    		 sorted.put(u.getValue(),u.getKey());
    	 }
         for(Entry<String, String> u: sorted.entrySet()) {
        	 response.getWriter().println("<tr>");
        	 response.getWriter().println("<td>"+u.getValue()+"</td>");
        	 response.getWriter().println("<td>"+u.getKey()+"</td>");
        	// response.getWriter().println("<td>"+u.getKey()+"</td>");
        	 
      
        	 response.getWriter().println("<td>"+"<a href='/kickMember?userid="+u.getValue()+"'>Kick</a></td>");
        	 //response.getWriter().println("<td>"+"<a href='/exterminate?id="+b.getValue().get("bookId")+"'>Delete</a></td>");
        	 response.getWriter().println("</tr>");
        }
         response.getWriter().println("</tbody>");
         response.getWriter().println("</table>");
         response.getWriter().println("</div>");
         

}
}