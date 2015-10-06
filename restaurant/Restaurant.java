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
        editMenuWindow.setDishList(Arrays.asList("d","e","f"));
        editMenuWindow.setDishes(new TreeMap<String, List<String>>());
        appController.register(new MainWindowController(mainWindow));
        appController.register(new EditDishController(new EditDishWindow(mainWindow)));
        appController.register(new EditMenuController(editMenuWindow));
        mainWindow.setVisible(true);
    }
    
}