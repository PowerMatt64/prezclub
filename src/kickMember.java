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
		String user = (request.getParameter("user"));
		
		//Map<Long, String> user = (Map<Long, String>) Userstore.getinstance().listUsers();
		
		System.out.print(user);
		DiscordApi api = (DiscordApi) new DiscordApiBuilder().setToken("NDYxNTg5NzEwNDg2MjQxMjkw.DivYaA.uiPIV9MNtUmJ6rSNu0Jh8sbG30g");
        Optional<Server> server = api.getServerById(467517939554451456L);
		server.get().kickUser(user);
		response.sendRedirect("/listPlayers");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
