package cz.doubeon.cars.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {
	 
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ClientWebConfig.class);
		context.register(DatabaseConfig.class);
		context.register(DateTimeConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(context));


		final ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(context));
         
        dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}