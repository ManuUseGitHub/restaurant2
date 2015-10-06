/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models;

import restaurant.models.work.IMenu;
import restaurant.models.work.IPlat;

/**
 *
 * @author nuKs
 */
public interface IIndex {
    public void addPlat(IPlat p);
    public void addMenu(IMenu m);
    
    public IPlat[] getAllPlats();
    public IPlat getPlatById(String id);
    
    public IMenu[] getAllMenus();
    public IMenu getMenuById(String id);
}
