/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.core;

/**
 *
 * @author Nicolas
 */
public abstract class Controller {

    private ApplicationController appController;

    public abstract void handleNavigation(Object args);

    public String getControllerName() {
        String className = this.getClass().getSimpleName();
        return className.substring(0, className.indexOf("Controller"));
    }

    public void setAppController(ApplicationController appController) {
        this.appController = appController;
    }

    public void requestNavigationTo(String controllerName, Object args) {
        this.appController.navigateTo(controllerName, args);
    }
}
