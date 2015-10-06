/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.core;

import java.util.*;

/**
 *
 * @author Nicolas
 */
public class ApplicationController {
    private final Map<String, Controller> controllers;

    public ApplicationController() {
        controllers = new HashMap<>();
    }
    
    public void register(Controller controller) {
        if(controller==null) {
            throw new IllegalArgumentException("controller is not defined");
        }
        
        controller.setAppController(this);
        controllers.putIfAbsent(controller.getControllerName(), controller);   
    }
    
    public void navigateTo(String controllerName, Object args) {
        if(controllers.containsKey(controllerName)) {
            controllers.get(controllerName).handleNavigation(args);
        } else {
            throw new ControllerNotFoundException(controllerName);
        }
    }
}
