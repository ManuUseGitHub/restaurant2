/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.Reader;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author MAZE2
 */
public enum MenuEnumKeys {

    ID("Id"),
    NAME("Name"),
    PRICE("Price"),
    ENTRY("Entrée"),
    MAIN_COURSE("Principal"),
    AFTER_COURSE("Dessert"),
    DRINK("Boisson");
    
    private final String value;
     

    MenuEnumKeys(String value) {
        this.value = value;
    }

    public static MenuEnumKeys parse(String s) {
        Iterator<MenuEnumKeys> iter = Arrays.asList(values()).iterator();
        while (iter.hasNext()) {
            MenuEnumKeys k = iter.next();
            if (k.value.equals(s)) // l'argument est le même que la valeur réelle 
            {
                return k;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
