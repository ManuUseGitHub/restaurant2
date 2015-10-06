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
import restaurant.crosplatformPathing.PathTranslator;

/**
 *
 * @author MAZE2
 */
public class FileWriter extends Writer {

    public FileWriter(String path) {
        super(path);
    }

    /**
     * 
     * @return 
     */
    public String getFolderPath() {
        return new File(path).getParent();
    }

    @Override
    public WriteStatus write(Iterator<String> contenu) {
        Path outFilePath = Paths.get(getPath());
        try (final OutputStreamWriter out = new OutputStreamWriter(Files.newOutputStream(outFilePath, StandardOpenOption.CREATE,StandardOpenOption.WRITE), "UTF-8")) {
            while (contenu.hasNext()) {
//                if (!contenu.next().equals("\u001a")) {
                    String line = contenu.next() + "\r\n";
                    out.write(line);
//                }
//                else{
//                    out.write("\u001a".getBytes());
//                }
            }
            return WriteStatus.SUCEED;
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
}
