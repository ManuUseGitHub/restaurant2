package restaurant.core;

//Contient les classes Files, Paths, etc.
import java.util.Iterator;
import restaurant.models.work.Dish;
import restaurant.models.work.IteratorTransformer;
import restaurant.models.work.TypePlat;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.Writer;

public class DishFileWriter extends FileWriter {

    private Dish dish;

    public DishFileWriter(String directoryStringPathFile) {
        super(directoryStringPathFile);
    }

    public Writer.WriteStatus tryWrite() {
        WriteStatus status = super.prepareFolder(dish.getId());
        try {
            if (dish.getIngredients().isEmpty()) {
                super.write((Iterator<String>) null);    // va provoquer l'exception car on n'a pas assez de données
            }
            if (status == Writer.WriteStatus.SUCEED) {                           // si 'écriture du dossier à réussi : repertoir non utilisé
                status = write(IteratorTransformer.getFrom(dish));        // écrire toutes les lignes
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
        return super.write(IteratorTransformer.getFrom(dish));
    }
}
