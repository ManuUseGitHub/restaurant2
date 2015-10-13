/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 *
 * @author MAZE2
 */
public class FileWriter extends Writer {

    public FileWriter(String path) {
        super(path);
    }
    
    private void cleanFolder(WriteStatus status) {
        if (status != WriteStatus.SUCEED) {
            // le dossier pour l'enregistrement sera supprimmé si il est vide (dossier vide = enregistrement avorté)
            FolderSuppresser.SuppressIfExists(new File(getPath()).getParent()); 
        }
    }

    public WriteStatus prepareFolder(long id) {

        FolderWriter folderW = new FolderWriter(getPath(), id);     // creation de l'arborescence
        setPath(folderW.getOutfilePath());                          // récupération du chemin de destination
        return folderW.write();                                     // écriture du dossier

    }
    @Override
    public WriteStatus write(Iterator<String> contenu) {
        WriteStatus status = WriteStatus.SUCEED;
        if (contenu != null) {
            Path outFilePath = Paths.get(getPath());
            try (final OutputStreamWriter out = new OutputStreamWriter(Files.newOutputStream(outFilePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE), "UTF-8")) {
                while (contenu.hasNext()) {
                    String line = contenu.next() + "\r\n";
                    out.write(line);
                }
                status.addMessage("Sauvegarde effectuée");
            } catch (IOException ex) {
                status = WriteStatus.OUT_FILE_PATH_NOT_FOUND.addMessage(ex.getMessage());
            } catch (Exception ex) {
                status = WriteStatus.TERMINATE_BADLY.addMessage(ex.getMessage());
            }
        }else{
            status = WriteStatus.NOTHING_TO_WRITE.addMessage("Il n'y a rien à écrire suite au manque de données");
        }
        cleanFolder(status);
        return status;
    }

    @Override
    public WriteStatus write(String content) {
        return write((Iterator<String>) null); // provoquera une erreur car la méthode n'est pas encore définie
    }

    @Override
    public WriteStatus write() {
        return write((Iterator<String>) null); // provoquera une erreur car la méthode n'est pas encore définie
    }
}