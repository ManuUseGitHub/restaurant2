package restaurant.models.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import restaurant.models.Consommable;

public class Menu extends Consommable {

    private Map<String, List<String>> etapes;
    private Map<String, List<Dish>> realCourses;

    public Menu(long id, String nom, float prix, Map<String, List<String>> etapes) {
        super(id, nom, prix);
        this.setId(nom.hashCode());
        this.etapes = etapes;
        this.realCourses = new HashMap<>();
        for(String keys : etapes.keySet()){
            realCourses.put(keys, new ArrayList<>());
        }
    }

    public Menu() {
        this.realCourses = new HashMap<>();
        for(String keys : TypePlat.getAllTypes()){
            realCourses.put(keys, new ArrayList<>());
        }
        this.etapes = new HashMap<>();
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

    /**
     * While adding a real dish is not possible, add it's name to courses 
     * @param step
     * @param dish 
     */
    public void AddDish(String step, String dish) {
        etapes.get(step).add(dish);
    }
    
    /**
     * While adding a real dish is not possible, add it's name to courses 
     * @param step
     * @param dish 
     */
    public void AddDish(String step, Dish dish) {
        realCourses.get(step).add(dish);
    }

    public void AddToSteps(String step, List<String> ingredients) {
        etapes.put(step, ingredients);
    }

    public void setSteps(Map<String, List<String>> etapes) {
        this.etapes = etapes;
    }

    public List<String> getSteps(String step) {
        return etapes.get(step);
    }

    public List<Dish> getCourses(String courseKey) {
        return realCourses.get(courseKey);
    }
}
