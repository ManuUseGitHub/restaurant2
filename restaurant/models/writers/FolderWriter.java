/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers;

import java.io.File;
import java.util.Iterator;
import restaurant.crosplatformPathing.PathTranslator;

/**
 *
 * @author MAZE2
 */
public class FolderWriter extends Writer {

    /**
     * Crée une arborescence
     * @param contenu
     * @return 
     */
    @Override
    public Writer.WriteStatus write(Iterator<String> contenu) {
        WriteStatus status = WriteStatus.READY;
        while (contenu.hasNext()) {
            status = write(contenu.next());
            if (status != WriteStatus.READY || status != WriteStatus.SUCEED) {
                break;
            }
        }
        return status;
    }

    @Override
    public WriteStatus write(String content) {
        if (!new File(PathTranslator.translate(getPath())).mkdirs()) {
            return WriteStatus.ALLREADY_EXISTS.addMessage("Entry allready exists !");
        }
        return WriteStatus.SUCEED;
    }
}
