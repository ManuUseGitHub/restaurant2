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
    private String path;

    public Writer(String path) {
        this.path = path;
    }
    
    public final String getPath() {
        return path;
    }

    public final void setPath(String path) {
        this.path = path;
    }
    
    public abstract WriteStatus write(Iterator<String> content);

    public abstract WriteStatus write(String content);
    
    public abstract WriteStatus write();
    
    public enum WriteStatus{
        ALLREADY_EXISTS,
        SUCEED,
        OUT_FILE_PATH_NOT_FOUND,
        TERMINATE_BADLY, 
        READY, NOTHING_TO_WRITE;
        
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
