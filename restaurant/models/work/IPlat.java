/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.work;

import java.util.ArrayList;
import java.util.List;
import restaurant.models.IConsommable;

/**
 *
 * @author MAZE2
 */
public interface IPlat extends IConsommable{

    List<String> getIngredients();

    void setIngredients(List<String> ingredients);

    
}
