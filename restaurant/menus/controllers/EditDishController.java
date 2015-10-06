package restaurant.menus.controllers;

import restaurant.core.DishFileWriterController;
import java.util.ArrayList;
import java.util.List;
import restaurant.core.Controller;
import restaurant.menus.views.messages.MessagesForWriting;
import restaurant.models.work.Dish;
import restaurant.models.writers.Writer;

/**
 *
 * @author Nicolas
 */
public class EditDishController extends Controller {

    public interface EditDishWindow {

        void setController(EditDishController controller);

        String getName();

        void setName(String value);

        void setErrorForName(String value);

        void setPrice(float value);

        float getPrice();

        void setErrorForPrice(String value);

        List<String> getIngredients();

        void setIngredients(List<String> value);

        void setErrorForIngredients(String value);

        void show();

        void hide();
    }

    private EditDishWindow window;

    public EditDishController(EditDishWindow editDishWindow) {
        this.setWindow(editDishWindow);
    }

    public EditDishWindow getWindow() {
        return window;
    }

    public void setWindow(EditDishWindow window) {
        this.window = window;
        this.window.setController(this);
    }

    public void saveEvent() {
        
        // on crée un dish à partir des valeurs de la vue
        Dish dish = new Dish(
                window.getName().hashCode(),
                window.getName(),
                window.getPrice(),
                (ArrayList<String>)window.getIngredients());
        
        // on crée un écrivain spécialisé et on lui passe le dish
        DishFileWriterController writer = new DishFileWriterController(dish);
        
        // on fait écrire l'écrivain
        Writer.WriteStatus status = writer.tryWrite();// si il y a une erreur, c'est ici dedans que ça se passe
        
        // on fait afficher le feedback 
        MessagesForWriting.showMessage(status); 
        status = hoverWrite(status, writer);
        feedBack(status);
        MessagesForWriting.showMessage(status); 
    }
    
    private Writer.WriteStatus hoverWrite(Writer.WriteStatus status,DishFileWriterController writer){
        if(status == Writer.WriteStatus.ALLREADY_EXISTS){
            if(MessagesForWriting.showYesNoQuestion("Voulez vous quand même ajouter le plat ?")){
               return writer.hoverwrite();
            }
        }
        return Writer.WriteStatus.READY;
    }
    
    private void feedBack(Writer.WriteStatus status){
        if(status == Writer.WriteStatus.SUCEED){
            window.hide();
        }
    }

    public void cancelEvent() {
        this.window.hide();
    }

    @Override
    public void handleNavigation(Object args) {
        this.window.show();
    }
}
