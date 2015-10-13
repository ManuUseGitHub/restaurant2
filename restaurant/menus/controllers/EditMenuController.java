package restaurant.menus.controllers;

import java.util.*;
import restaurant.core.Controller;
import restaurant.core.MenuFileWriter;
import restaurant.models.work.Menu;
import restaurant.models.writers.Writer;

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
        // on crée un dish à partir des valeurs de la vue
        Map<String,List<String>> map = window.getDishes();
        Menu menu = new Menu(
                window.getName().hashCode(),
                window.getName(),
                window.getPrice(),
                map);
        
        // on crée un écrivain spécialisé et on lui passe le dish
        MenuFileWriter writer = new MenuFileWriter("Exemples");
        writer.setMenu(menu);
        
        // on fait écrire l'écrivain
        Writer.WriteStatus status = writer.tryWrite();// si il y a une erreur, c'est ici dedans que ça se passe
        
        /*
        // on fait afficher le feedback 
        MessagesForWriting.showMessage(status); 
        status = hoverWrite(status, writer);
        feedBack(status);
        MessagesForWriting.showMessage(status); */
        
        this.window.hide();
    }

    public void cancelEvent() {
        this.window.hide();
    }
}
