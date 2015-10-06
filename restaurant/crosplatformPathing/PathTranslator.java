/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.crosplatformPathing;

/**
 *
 * @author MAZE2
 */
public class PathTranslator {
    public static String translate(String path){
        String os = System.getProperty("os.name");
        boolean isAWindows = os.matches("(?i:.*(WINDOWS).*)");
        if(path.matches(".*/.*") && isAWindows ){   // on a windows but using '/'
            return path.replace('/', '\\');
        }
        else if(path.matches(".*\\\\.*") && !isAWindows){ // on an different machin than a windows but using '\'
            return path.replace('\\', '/');
        }
        //System.getProperties().list(System.out); // show all informations
        return path; // no translation if nothing has to change
    }
}
