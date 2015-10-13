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
public enum DishEnumKeys {
        ID("Id"),
        NAME("Name"),
        PRICE("Price"),
        INGREDIENTS("Ingredients");
        private final String value;
        
        DishEnumKeys(String value){
            this.value = value;
        }
        
        public static DishEnumKeys parse(String s){
            Iterator<DishEnumKeys> iter =  Arrays.asList(values()).iterator();
            while(iter.hasNext()){
                DishEnumKeys k = iter.next();
                if(k.value.equals(s))       // l'argument est le même que la valeur réelle 
                    return k;
            }
            return null;
        }
    }
