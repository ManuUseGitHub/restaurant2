/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.parsers;

import java.util.ArrayList;
import restaurant.models.work.Dish;
import restaurant.models.work.IPlat;

/**
 *
 * @author MAZE2
 */
public class DishParser {
    private final ArrayList<IPlat> plats;
    private IPlat current;
    private boolean isReadingIngredients = false;

    /**
     * @return the etudiant
     */
    public ArrayList<IPlat> getPlats() {
        return plats;
    }

    private void registerMember(String line, String information) {
        
        if (line.matches(".*(Id|Name|Price).*")) {
            String[] keyStrings = new String[]{"Id", "Name", "Price"};
            Keys[] keys = Keys.values(); // in the declared order

            for (int i = 0, t = keyStrings.length; i < t; ++i) {
                if (line.matches(String.format(".*(%s).*", keyStrings[i]))) {
                    registerInfo(information, keys[i]);
                }
            }
        } else {
        }
    }

    public enum Keys {
        ID,
        NAME,
        PRICE,
        INGREDIENTS,
    }

    public DishParser() {
        plats = new ArrayList<>();
    }

    public void completeEtudiant(String line, String information) {

        registerMember(line, information);          // on est tombé sur un matricule, un nom ou un prénom (un membre)

        if (line.matches(String.format(".*(Plat).*"))) {
            isReadingIngredients = false;               // on a terminé avec les hobbies du précédent
            plats.add(current = new Dish()); // on passe au nouvel étudiant

        } else if (isReadingIngredients) {
            registerInfo(information, Keys.INGREDIENTS);// on ajoute aveuglément le nouvel hobby

        } else if (line.matches(String.format(".*(Ingredients).*"))) {
            isReadingIngredients = true;                // on va commencer à ajouter des hobbies
        }
    }

    void registerInfo(String information, Keys key) {
        switch (key) {
            case ID:
                current.setId(Integer.parseInt(information));
                break;
            case NAME:
                current.setNom(information);
                break;
            case PRICE:
                current.setPrix(Float.parseFloat(information));
                break;
            case INGREDIENTS:
                current.getIngredients().add(information.trim());
                break;
            default:
                break;
        }
    }
}
