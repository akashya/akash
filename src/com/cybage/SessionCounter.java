package com.cybage;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener
{
	public static int count=0;
	@Override
	public void sessionCreated(HttpSessionEvent sessionevent) {
		
		count++;
		
		ServletContext context=sessionevent.getSession().getServletContext();
		synchronized (context) {
			context.setAttribute("usercount", new Integer(count));
			
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionevent) {
          count--;
		
		ServletContext context=sessionevent.getSession().getServletContext();
		synchronized (context) {
			context.setAttribute("usercount", new Integer(count));
			
		}
	}
	/*public static int counter=0;
	
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		SessionCounter.counter = counter;
	}
	public static void increment()
	{
		counter++;
	}
	public static void decrement()
	{
		counter--;
	}
*/
}
