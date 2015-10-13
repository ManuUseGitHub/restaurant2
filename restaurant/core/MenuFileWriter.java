/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.core;

import java.util.Iterator;
import restaurant.models.StringRessources;
import restaurant.models.work.IteratorTransformer;
import restaurant.models.work.Menu;
import restaurant.models.work.TypePlat;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.Writer;

/**
 *
 * @author MAZE2
 */
public class MenuFileWriter extends FileWriter {

    private Menu menu;

    public MenuFileWriter(String menuFilePath) {
        super(menuFilePath);
    }

    public Writer.WriteStatus tryWrite() {
        WriteStatus status = super.prepareFolder(menu.getId());
        try {
            if (menu.getCourses(TypePlat.PRINCIPAL.toString()).isEmpty()) {
                super.write((Iterator<String>) null);    // va provoquer l'exception car on n'a pas assez de données
            }
            if (status == Writer.WriteStatus.SUCEED) {   // si 'écriture du dossier à réussi : repertoir non utilisé
                status = super.write(IteratorTransformer.getFrom(menu));  // écrire toutes les lignes
            }
        } catch (NullPointerException ex) {
            status = Writer.WriteStatus.TERMINATE_BADLY.addMessage(StringRessources.MENU_IS_NULL.toString());
        }
        return status;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
