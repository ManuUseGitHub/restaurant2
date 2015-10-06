/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.core;

//Contient les classes Files, Paths, etc.
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import restaurant.models.work.Dish;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.FolderWriter;
import restaurant.models.writers.Writer;

public class DishFileWriterController{

    private Dish dish;
    private final FileWriter dishW;

    public DishFileWriterController(String filePath) {
        dishW = new FileWriter(filePath);
    }

    public DishFileWriterController(Dish dish) {
        this(String.format("Exemples\\generated\\%d\\%s", dish.getId(), dish.getNom()));
        this.dish = dish;
    }

    public Writer.WriteStatus tryWrite() {
        // vérification que Dish n'est pas null
        if (dish == null) {
            return Writer.WriteStatus.TERMINATE_BADLY.addMessage("Dish is null ...");
        }

        // le dossier 
        String folderPath = dishW.getFolderPath(); // !! could be null if have no directory name as parent ...

        return write();
        // le dossier est - il utilisé : pré-existance du plat
        /*if(new File (folderPath).exists()){
         return Writer.WriteStatus.ALLREADY_EXISTS.addMessage("The dish allready exist");
         }
        
         return write(folderPath);*/
    }

    /**
     * @param dish the dish to set
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    private Writer.WriteStatus write() {
        String folderPath = dishW.getFolderPath();

        FolderWriter folderW = new FolderWriter();
        folderW.setPath(folderPath);
        Writer.WriteStatus status;
        if ((status = folderW.write(dishW.getPath())) == Writer.WriteStatus.SUCEED) {
            status = dishW.write(dish.iterator());
        }

        return status;
    }

    public Writer.WriteStatus hoverwrite() {
        String folderPath = ((FileWriter) dishW).getFolderPath();
        FolderWriter folderW = new FolderWriter();
        folderW.setPath(folderPath);

        return dishW.write(dish.iterator());
    }
}
