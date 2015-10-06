/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.Reader;

import java.util.List;

/**
 *
 * @author MAZE2
 */
class Reader  implements IReader{

    private String inFilePath;

    public Reader(){
    }
    public Reader(String inFilePath){
    }
    
    String getInFilePath() {
        return inFilePath;
    }
    
    public void setInFilePath(String inFilePath) {
       this.inFilePath  = inFilePath;
    }

    @Override
    public List getContentRead() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReadStatus read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum ReadStatus {
        SUCCED,
        FILE_NOT_FOUND,
        TERMINATE_BADLY, READY
    }
}
