/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.work;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author MAZE2
 */
public class IteratorTransformer {
    
    public static Iterator<String> getFrom(Menu menu) {
        ArrayList<String> lignes = new ArrayList<>();
        lignes.add("Menu");
        lignes.add("\t\tId:" + menu.getId());
        lignes.add("\t\tName:" + menu.getNom());
        lignes.add("\t\tPrice:" + menu.getPrix());

        for (TypePlat t : TypePlat.values()) {
            lignes.add("\t\t" + t.toString() + ":");
            String k = t.toString();

            if (menu.getSteps(k) != null) {
                Iterator<String> navigator = menu.getSteps(k).iterator();
                while (navigator.hasNext()) {
                    lignes.add("\t\t\t" + navigator.next().hashCode());
                }
            }
            lignes.add(""); // ajoutera du blanc entre les différentes étapes/rubriques
        }
        //elements.add("\u001a"); // EOF

        return lignes.iterator();
    }
    
    public static Iterator<String> getFrom(Dish dish) {
        ArrayList<String> lignes = new ArrayList<>();
        lignes.add("Plat");
        lignes.add("\t\tId:" + dish.getId());
        lignes.add("\t\tName:" + dish.getNom());
        lignes.add("\t\tPrice:" + dish.getPrix());
        lignes.add("\t\tIngredients:");

        Iterator<String> navigator = dish.getIngredients().iterator();
        while (navigator.hasNext()) {
            lignes.add("\t\t\t" + navigator.next());
        }
        //lignes.add("\u001a"); // EOF

        return lignes.iterator();
    }
}
