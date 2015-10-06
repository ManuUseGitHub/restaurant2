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
public interface IMenu extends IConsommable{

    List<String> getSteps(TypePlat step);

    void setSteps(TypePlat step,List<String> etape );
    
}
