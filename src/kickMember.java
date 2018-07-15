import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

public class kickMember extends HttpServlet {
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		try {
		String id = (request.getParameter("id"));
		
		//Map<Long, String> user = (Map<Long, String>) Userstore.getinstance().listUsers();
		
		//System.out.print(user);
		
		System.out.println(bot.getServer().getMemberById(id).toString());
		//bot.getServer().kickUser(bot.getServer().getMemberById(id));
		
		response.sendRedirect("/listPlayers");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
