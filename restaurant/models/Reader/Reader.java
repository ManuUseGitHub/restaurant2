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
public abstract class Reader  implements IReader{

    private String inFilePath;

    public Reader(){
    }
    public Reader(String inFilePath){
        this.inFilePath = inFilePath;
    }
    
    String getInFilePath() {
        return inFilePath;
    }
    
    @Override
    public void setInFilePath(String inFilePath) {
       this.inFilePath  = inFilePath;
    }

    @Override
    public abstract Object getResult();

    @Override
    public abstract ReadStatus read();

    public enum ReadStatus {
        SUCCED,
        FILE_NOT_FOUND,
        TERMINATE_BADLY, READY
    }
}
