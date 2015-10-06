/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers;

import java.util.Iterator;

/**
 *
 * @author MAZE2
 */
public abstract class Writer{
    protected String path;

    public Writer(String path) {
        this.path = path;
    }
    
    public Writer() {
    }
    
    public final String getPath() {
        return path;
    }

    public final void setPath(String path) {
        this.path = path;
    }

    public WriteStatus write(Iterator<String> content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public WriteStatus write(String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum WriteStatus{
        ALLREADY_EXISTS,
        SUCEED,
        OUT_FILE_PATH_NOT_FOUND,
        TERMINATE_BADLY, READY;
        
        private String message;
        
        public String getMessage(){
            return message;
        }
        
        public WriteStatus addMessage(String message){
            this.message = message; 
            return this;
        }
    }
}
