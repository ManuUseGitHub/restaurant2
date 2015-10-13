/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers;

import java.io.File;

/**
 *
 * @author MAZE2
 */
public class FolderSuppresser {

    public static DirStates SuppressForce(String path) {
        DirStates status = DirStates.SUPPRESSION_SUCCEEDED;;
        File index = new File(path);
        try {
            if (index.exists()) {
                if (index.isDirectory()) {
                    String[] entries = index.list();
                    for (String s : entries) {
                        File currentFile = new File(index.getPath(), s);
                        currentFile.delete();
                    }
                    if(!index.delete()){
                        status = DirStates.TERMINATE_BADLY.addMessage("Les fichiers sont peut être ouverts quelquepart");
                    }
                } else {
                    status = DirStates.FILE_NOT_A_DIRECTORY;
                }
            } else {
                status = DirStates.DIRECTORY_NOT_FOUND;
            }
        } catch (Exception ex) {// On ne sait jamais
            status = DirStates.TERMINATE_BADLY.addMessage(ex.getMessage());
        }
        return status;
    }

    public static DirStates SuppressIfExists(String path) {
        DirStates status = DirStates.SUPPRESSION_SUCCEEDED;
        File index = new File(path);
        try{
        if (index.exists()) {
            if (index.isDirectory()) {
                if (!index.delete()) {// suppression ! effectuée ou non
                    status = DirStates.DIRECTORY_NOT_EMPTY;
                }
            } else {
                status = DirStates.FILE_NOT_A_DIRECTORY;
            }
        } else {
            status = DirStates.DIRECTORY_NOT_FOUND;
        }
        }catch(Exception ex){
            status = DirStates.TERMINATE_BADLY.addMessage(ex.getMessage());
        }
        return status;
    }
}
