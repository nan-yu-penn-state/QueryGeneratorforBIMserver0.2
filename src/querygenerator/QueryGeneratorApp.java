/*
 * QueryGeneratorApp.java
 */

package querygenerator;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 * @author Nan Yu
 */


public class QueryGeneratorApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new QueryGeneratorView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of QueryGeneratorApp
     */
    public static QueryGeneratorApp getApplication() {
        return Application.getInstance(QueryGeneratorApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(QueryGeneratorApp.class, args);
    }
}
