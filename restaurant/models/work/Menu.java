package restaurant.models.work;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import restaurant.models.Consommable;

public class Menu extends Consommable implements IMenu,Iterable<String> {

    private EnumMap<TypePlat, List<String>> etapes;

    public Menu() {
        super();
        setNewEtapes(); // défniti les étapes du menu
    }

    public Menu(long id,String nom, float prix) {
        super(id,nom, prix);

        this.setId(nom.hashCode());
        this.setNewEtapes(); // défniti les étapes du menu
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
        lignes.add("Menu");
        lignes.add("\t\tId:" + getId());
        lignes.add("\t\tName:" + getNom());
        lignes.add("\t\tPrice:" +getPrix());

        for (TypePlat t : TypePlat.values()) {
            lignes.add("\t\t" + t.toString() + ":");
            Iterator<String> navigator = etapes.get(t).iterator();
            while (navigator.hasNext()) {
                lignes.add("\t\t\t" + navigator.next());
            }
        }
        //elements.add("\u001a"); // EOF

        return lignes.iterator();
    }

    @Override
    public ArrayList<String> getSteps(TypePlat step) {
        return (ArrayList<String>)etapes.get(step);
    }
    @Override
    public void setSteps(TypePlat step,List<String> ingredients) {
        etapes.put(step, ingredients);
    }

    /**
     * initialise la map des étapes du menu
     */
    private void setNewEtapes() {
        etapes = new EnumMap<>(TypePlat.class);
        for(TypePlat t : TypePlat.values()){
            etapes.put(t, new ArrayList<>());
        }
    }

}
