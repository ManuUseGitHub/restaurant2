/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import restaurant.models.Consommable;

/**
 *
 * @author MAZE2
 */
public class Dish extends Consommable implements IPlat,Iterable<String> {
    private List<String> ingredients;

    public Dish(long id, String name, float price, ArrayList<String> ingredients) {
        super(id, name, price);
        this.ingredients = ingredients;
    }

    public Dish(String name, float price, ArrayList<String> ingredients) {
        this(name.hashCode(), name, price, ingredients);
    }

    public Dish() {
        ingredients = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        Iterator<String> iter = iterator();
        while(iter.hasNext()){
            sb.append(iter.next()).append('\n');
        }
        return sb.toString();
    }

    @Override
    public Iterator<String> iterator() {
        ArrayList<String> lignes = new ArrayList<>();
        lignes.add("Plat");
        lignes.add("\t\tId:" + getId());
        lignes.add("\t\tName:" + getNom());
        lignes.add("\t\tPrice:" + getPrix());
        lignes.add("\t\tIngredients:");

        Iterator<String> navigator = ingredients.iterator();
        while (navigator.hasNext()) {
            lignes.add("\t\t\t" + navigator.next());
        }
        //lignes.add("\u001a"); // EOF

        return lignes.iterator();
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public void setIngredients(List<String> ingredients) {
        this.ingredients = (ArrayList<String>) ingredients;
    }
}
