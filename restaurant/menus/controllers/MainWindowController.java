package restaurant.menus.controllers;

import java.util.List;
import restaurant.core.Controller;

/**
 *
 * @author Nicolas
 */
public class MainWindowController extends Controller {

    public MainWindowController(MainWindow mainWindow) {
        this.setMainWindow(mainWindow);
    }

    public interface MainWindow {

        void setController(MainWindowController controller);

        void setSearchText(String value);

        String getSearchText();

        void setSearchResult(List<String> result);

        void close();
    }

    private MainWindow mainWindow;

    public MainWindow getMainWindow() {
        return this.mainWindow;
    }

    public void setMainWindow(MainWindow window) {
        this.mainWindow = window;
        this.mainWindow.setController(this);
    }

    public void newDishEvent() {
        requestNavigationTo("EditDish", null);
    }

    public void newMenuEvent() {
        requestNavigationTo("EditMenu", null);
    }

    public void newSearchEvent() {
    }

    public void quitEvent() {
        mainWindow.close();
    }

    @Override
    public void handleNavigation(Object args) {
    }
}
