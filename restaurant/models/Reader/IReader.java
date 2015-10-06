/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.Reader;

import java.util.List;
import restaurant.models.Reader.Reader.ReadStatus;

/**
 *
 * @author MAZE2
 */
public interface IReader {

    /**
     * @return the target
     */
    List getContentRead();

    ReadStatus read();

    /**
     * @param inFilePath the inFilePath to set
     */
    void setInFilePath(String inFilePath);
    
}
