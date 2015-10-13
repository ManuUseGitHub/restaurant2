package restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import restaurant.core.ApplicationController;
import restaurant.menus.controllers.*;
import restaurant.menus.views.*;
import restaurant.models.work.TypePlat;

public class Restaurant {

    public static void main(String[] args) {
        ApplicationController appController = new ApplicationController();
        MainWindow mainWindow = new MainWindow();
        EditMenuWindow editMenuWindow = new EditMenuWindow(mainWindow);
        editMenuWindow.setDishTypes(TypePlat.getAllTypes());
        
        // TODO: generer les fichiers à partir de l'index est les passer ici à la place de cette liste
        List<String> dishsRegistered = Arrays.asList("Navais","Choux Farcis","gelée de betterave","Purrée aux amandes");
        
        editMenuWindow.setDishList(dishsRegistered);
        
        editMenuWindow.setDishes(new TreeMap<String, List<String>>());
        appController.register(new MainWindowController(mainWindow));
        appController.register(new EditDishController(new EditDishWindow(mainWindow)));
        appController.register(new EditMenuController(editMenuWindow));
        mainWindow.setVisible(true);
    }
    
}