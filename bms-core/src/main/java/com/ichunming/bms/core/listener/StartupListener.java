/**
 * 应用启动监听器
 * create by ming 2016/11/17 
 */
package com.ichunming.bms.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ichunming.bms.core.helper.MessageManager;

/**
 * Application Lifecycle Listener implementation class appListener
 *
 */
public class StartupListener implements ServletContextListener {

	 private static Logger logger = LoggerFactory.getLogger(StartupListener.class);
	 
    /**
     * Default constructor. 
     */
    public StartupListener() {}

    @Override
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletcontextevent) {
    	logger.info("应用程序启动...");
    	
    	// context path
    	logger.info("context path:" + servletcontextevent.getServletContext().getContextPath());
    	
    	// load message
    	MessageManager.init(this.getClass().getClassLoader().getResource("message.properties").getPath());
    }
    
    @Override
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletcontextevent) {
    	logger.info("应用程序关闭...");
    }
}