package restaurant.core;

//Contient les classes Files, Paths, etc.
import java.io.File;
import restaurant.crosplatformPathing.PathTranslator;
import restaurant.models.work.Dish;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.FolderWriter;
import restaurant.models.writers.Writer;

public class DishFileWriter {

    private Dish dish;
    private final FileWriter dishW;
    private FolderWriter folderW;

    public DishFileWriter(Dish dish,String directoryStringPathFile) {
        StringBuilder sb = new StringBuilder(directoryStringPathFile);
        sb
                .append(directoryStringPathFile)
                .append("\\").append(dish.getId())
                .append("\\").append(dish.getId());
                
        String finalFilePath = PathTranslator.translate(sb.toString()); // le chemin final 
        dishW = new FileWriter(finalFilePath);
        this.dish = dish;
    }

    public Writer.WriteStatus tryWrite() {
        Writer.WriteStatus status;
        try {
            String destination = new File(dishW.getPath()).getParent(); // le dossier de destination
            folderW = new FolderWriter(destination);
            
            status = folderW.write();                   // écriture du dossier
            
            if( status == Writer.WriteStatus.SUCEED){   // si 'écriture du dossier à réussi : repertoir non utilisé
                status = dishW.write(dish.iterator());  // écrire toutes les lignes
            }
        } catch (NullPointerException ex) {
            status = Writer.WriteStatus.TERMINATE_BADLY.addMessage(ex.getMessage());
        }
        return status;
    }

    /**
     * @param dish the dish to set
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Writer.WriteStatus hoverwrite() {
        return dishW.write(dish.iterator());
    }
}
