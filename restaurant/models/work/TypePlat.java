/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.work;

/**
 *
 * @author MAZE2
 */
public enum TypePlat {

    ENTREE("Entrée"),
    PRINCIPAL("Principal"),
    DESSERT("Dessert"),
    BOISSON("Boisson");

    final String name;

    TypePlat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static String[] getAllTypes() {
        TypePlat[] all = values();
        String[] values = new String[all.length];
        int cpt = 0;
        for (TypePlat t : all) {
            values[cpt++] = t.toString();
        }
        return values;
    }
}
