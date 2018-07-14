import java.util.Collections;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.security.authentication.BasicAuthenticator;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.security.Constraint;


public class web {


		public static void main(String[] args) {
			Server s = new Server(8080);

			LoginService loginService = new HashLoginService("matt",
					"./UI/realm.properties");
			s.addBean(loginService);

			ConstraintSecurityHandler security = new ConstraintSecurityHandler();
			s.setHandler(security);

			Constraint constraint = new Constraint();
			constraint.setName("auth");
			constraint.setAuthenticate(true);
			constraint.setRoles(new String[] { "user", "matt" });

			ConstraintMapping mapping = new ConstraintMapping();
			mapping.setPathSpec("/*");
			mapping.setConstraint(constraint);


			security.setConstraintMappings(Collections.singletonList(mapping));
			security.setAuthenticator(new BasicAuthenticator());
			security.setLoginService(loginService);

			ResourceHandler resource_handler = new ResourceHandler();
			resource_handler.setDirectoriesListed(false);
			resource_handler.setWelcomeFiles(new String[]{ "index.html" });
			resource_handler.setResourceBase("./UI");
			ServletHandler handler = new ServletHandler();
			handler.addServletWithMapping(listPlayers.class, "/listPlayers");

			HandlerList handlers = new HandlerList();
			handlers.setHandlers(new Handler[] { resource_handler,handler, new DefaultHandler() });
			security.setHandler(handlers);
			
			try {
				s.start();
				s.join();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

}
