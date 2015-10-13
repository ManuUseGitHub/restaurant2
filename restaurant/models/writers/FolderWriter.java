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
    private String outfilePath;

    public FolderWriter(String path) {
        super(path);
    }

    public FolderWriter(String path, long id) {
        this(path);
        StringBuilder sb = new StringBuilder(path);
        sb
                .append("\\").append(id)
                .append("\\").append(id);

        String finalFilePath = PathTranslator.translate(sb.toString()); // le chemin final
        setPath(new File(finalFilePath).getParent());
        outfilePath = sb.toString();
    }

    /**
     * Crée une arborescence
     *
     * @param folders
     * @return
     */
    @Override
    public Writer.WriteStatus write(Iterator<String> folders) {
        WriteStatus status = WriteStatus.READY;
        while (folders.hasNext()) {
            status = write(folders.next());
            if (status != WriteStatus.READY || status != WriteStatus.SUCEED) {
                break;
            }
        }
        return status;
    }

    @Override
    public WriteStatus write(String stringFilePath) {
        throw new UnsupportedOperationException("unimplemented");
    }

    @Override
    public WriteStatus write() {
        if (!new File(PathTranslator.translate(getPath())).mkdirs()) {
            return WriteStatus.ALLREADY_EXISTS.addMessage("Entry allready exists !");
        }
        return WriteStatus.SUCEED;
    }

    /**
     * @return the outfilePath
     */
    public String getOutfilePath() {
        return outfilePath;
    }
}
