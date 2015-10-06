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

    @Override
    public WriteStatus write(Iterator<String> contenu) {
        Path outFilePath = Paths.get(getPath());
        try (final OutputStreamWriter out = new OutputStreamWriter(Files.newOutputStream(outFilePath, StandardOpenOption.CREATE,StandardOpenOption.WRITE), "UTF-8")) {
            while (contenu.hasNext()) {
                    String line = contenu.next() + "\r\n";
                    out.write(line);
            }
            //out.write("\u001a");// EOF
            return WriteStatus.SUCEED.addMessage("Sauvegarde effectuée");
        } catch (IOException ex) {
            return WriteStatus.OUT_FILE_PATH_NOT_FOUND.addMessage(ex.getMessage());
        } catch (Exception ex) {
            return WriteStatus.TERMINATE_BADLY.addMessage(ex.getMessage());
        }
    }

    @Override
    public WriteStatus write(String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WriteStatus write() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
