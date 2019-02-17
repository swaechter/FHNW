package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.util.QuestionnaireInitializer;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener()
public class BasicListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private static Logger logger = Logger.getLogger(BasicListener.class);

    public static final String KEY_NAME_REPOSITORY = "repository";

    public static final String KEY_NAME_MODE = "mode";

    private static final String VALUE_NAME_MODE = "test";

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String mode = servletContext.getInitParameter(KEY_NAME_MODE);
        QuestionnaireRepository questionnaireRepository = !mode.equalsIgnoreCase(VALUE_NAME_MODE) ? new QuestionnaireRepository() : new QuestionnaireInitializer().initRepoWithTestData();
        servletContext.setAttribute(KEY_NAME_REPOSITORY, questionnaireRepository);
        logger.debug("Repository initialized and set");
        // Context is initialized
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // Context is created
    }

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        // Session is created.
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // Session is destroyed.
    }

    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        //This method is called when an attribute is added to a session.
    }

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        // This method is called when an attribute is removed from a session.
    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        // This method is invoked when an attibute is replaced in a session.
    }
}
