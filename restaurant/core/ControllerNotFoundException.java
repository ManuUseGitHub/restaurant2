package restaurant.core;

/**
 *
 * @author Nicolas
 */
class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String controllerName) {
        super(String.format("The controller %s was not found", controllerName));
    }
    
}
