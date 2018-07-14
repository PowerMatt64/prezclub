

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class bot {

	public static void main(String[] args) {
        // Read the token from the first program parameter when invoking the bot
        String token = "NDYxNTg5NzEwNDg2MjQxMjkw.DivYaA.uiPIV9MNtUmJ6rSNu0Jh8sbG30g";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        
        // Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessage().getContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
                System.out.println(api.getStatus());
            }
            if (event.getMessage().getContent().equalsIgnoreCase("!showusersconsole")) {
                System.out.println(api.getCachedUsers());
               
            }
        });
        
        // Print the invite url of your bot
       // System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }

}


