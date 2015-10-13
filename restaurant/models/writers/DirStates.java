/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers;

/**
 *
 * @author MAZE2
 */
public enum DirStates {

    FILE_NOT_A_DIRECTORY,
    DIRECTORY_NOT_FOUND,
    DIRECTORY_NOT_EMPTY,
    SUPPRESSION_SUCCEEDED,
    TERMINATE_BADLY;

    private String message;

    public DirStates addMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }
}
