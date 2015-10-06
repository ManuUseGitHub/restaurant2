package restaurant.menus.controllers;

import java.util.*;
import restaurant.core.Controller;

/**
 *
 * @author Nicolas
 */
public class EditMenuController extends Controller {
//<editor-fold defaultstate="collapsed" desc="interface EditMenuWindow ">

    public interface EditMenuWindow {

        void setController(EditMenuController controller);

        void setName(String name);

        String getName();

        void setErrorForName(String value);

        void setPrice(float value);

        float getPrice();

        void setErrorForPrice(String value);

        Map<String, List<String>> getDishes();

        void setDishes(Map<String, List<String>> value);

        void setErrorForDishes(String value);

        void setDishTypes(List<String> dishTypes);

        void setDishTypes(String[] dishTypes); // personnal

        void setDishList(List<String> dishList);

        void show();

        void hide();
    }
//</editor-fold>

    public EditMenuController(EditMenuWindow window) {
        this.setWindow(window);
    }

    private EditMenuWindow window;

    public EditMenuWindow getWindow() {
        return window;
    }

    public void setWindow(EditMenuWindow window) {
        this.window = window;
        this.window.setController(this);
    }

    @Override
    public void handleNavigation(Object args) {
        window.show();
    }

    public void saveEvent() {
        this.window.hide();
    }

    public void cancelEvent() {
        this.window.hide();
    }
}
