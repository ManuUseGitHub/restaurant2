/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models;

/**
 *
 * @author MAZE2
 */
public enum StringRessources {
    DISH_ALLREADY_EXISTS("Ce plat existe déjà"),
    HOVERWRITE_DISH_QUESTION("Voulez-vous écraser le plat existant"),
    DISH_IS_NULL("dish is NULL ..."),
    
    MENU_ALLREADY_EXISTS("Ce menu existe déjà"),
    HOVERWRITE_MENU_QUESTION("Voulez-vous écraser le menu existant"), 
    MENU_IS_NULL("menu is NULL ..."), 
    
    SUCCEEDED_OPERATION("Opération réussie"), 
    FILE_NOT_FOUND("Fichier introuvable");
    private final String message;
    
    @Override
    public String toString(){
        return message;
    }
    StringRessources(String message){
        this.message = message;
    }
}
