package org.minioa.core;
import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyTimer implements ServletContextListener {
	private Timer timer = null;

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			timer = new Timer(true);
			timer.schedule(new MyTimerTask(), 0, 60000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		timer.cancel();
	}
}