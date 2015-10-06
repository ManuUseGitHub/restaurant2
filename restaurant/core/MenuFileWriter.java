/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.core;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import restaurant.crosplatformPathing.PathTranslator;
import restaurant.models.Actions;
import restaurant.models.StringRessources;
import restaurant.models.work.Menu;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.FolderWriter;
import restaurant.models.writers.Writer;

/**
 *
 * @author MAZE2
 */
public class MenuFileWriter implements Observer {

    private final Writer menuW;
    private Menu menu;
    private FolderWriter folderW;

    public MenuFileWriter(Menu menu, String menuFilePath) {
        StringBuilder sb = new StringBuilder(menuFilePath);
        sb
                .append(menuFilePath)
                .append("\\").append(menu.getId())
                .append("\\").append(menu.getId());

        String finalFilePath = PathTranslator.translate(sb.toString()); // le chemin final 
        menuW = new FileWriter(finalFilePath);
        this.menu = menu;

    }

    public Writer.WriteStatus write() {
        Writer.WriteStatus status;
        if (menu == null) {
            return Writer.WriteStatus.TERMINATE_BADLY.addMessage(StringRessources.MENU_IS_NULL.toString());
        }

        String destination = new File(menuW.getPath()).getParent(); // le dossier de destination
        folderW = new FolderWriter(destination);

        folderW.write();

        if ((status = folderW.write(menuW.getPath())) == Writer.WriteStatus.SUCEED) {
            status = menuW.write(menu.iterator());
        }
        return status;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Actions) {
            switch ((Actions) arg) {
                case SAVE:
                    write();
            }
        }
    }
}
