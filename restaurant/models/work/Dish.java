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
public class Dish extends Consommable implements IPlat {

    private List<String> ingredients;

    public Dish(long id, String name, float price, List<String> ingredients) {
        super(id, name, price);
        this.ingredients = new ArrayList<>();

        for (String ingredient : ingredients) {
            if (ingredient.trim().length() > 2) {        // un ingrédient doit au moins avoir 3 lettres 
                this.ingredients.add(ingredient.trim());
            }
        }
    }

    public Dish(String name, float price, List<String> ingredients) {
        this(name.hashCode(), name, price, ingredients);
    }

    public Dish() {
        ingredients = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Iterator<String> iter = IteratorTransformer.getFrom(this);
        while (iter.hasNext()) {
            sb.append(iter.next()).append('\n');
        }
        return sb.toString();
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }
}
