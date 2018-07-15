

import java.util.Optional;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

public class bot implements Runnable{

	public static void main(String[] args) {
        new bot();
    }
	public bot() {
		new Thread(this).start();
	}
	@Override
	public void run() {
		 String token = "NDYxNTg5NzEwNDg2MjQxMjkw.DivYaA.uiPIV9MNtUmJ6rSNu0Jh8sbG30g";

	        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
	        Optional<Server> server = api.getServerById(467517939554451456L);
	        // Add a listener which answers with "Pong!" if someone writes "!ping"
	        api.addMessageCreateListener(event -> {
	            if (event.getMessage().getContent().equalsIgnoreCase("!ping")) {
	                event.getChannel().sendMessage("Pong!");
	                System.out.println(api.getStatus());
	            }
	            
	            if (event.getMessage().getContent().equalsIgnoreCase("!update")) {
	            	event.getChannel().sendMessage("Updated!");
	            	int servercount = server.get().getMemberCount();
	            	//Optional<ServerChannel> channel = server.get().getChannelById(467517939554451460L);
	                //System.out.println(channel.get().get);
	                //System.out.println(servercount);
	                for (User u: server.get().getMembers()) {
	          
	                	Userstore.getinstance().adduser(u.getId(), u.getName() );
	                }
	                
	               
	            }
	            if (event.getMessage().getContent().equalsIgnoreCase("!count")) {
	                event.getChannel().sendMessage("There are "+Integer.toString(server.get().getMemberCount())+" people on this server!");
	                
	                System.out.println(api.getStatus());
	            }
	        });
	        
	        // Print the invite url of your bot
	       // System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
		
	}

}


