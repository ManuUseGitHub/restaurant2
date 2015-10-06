/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.demo;

import java.util.ArrayList;
import java.util.Arrays;
import restaurant.crosplatformPathing.PathTranslator;
import restaurant.models.work.Dish;
import restaurant.core.DishFileWriterController;
import restaurant.models.writers.Writer;

/**
 *
 * @author MAZE2
 */
public class DemoDishFileWriter {

    public static void main(String[] args) throws Exception {
        ArrayList<String> ingredients = new ArrayList<>(
                Arrays.asList("tomates", "basilique", "patates", "crème")
        );
        
        String name = "XXX"; 
        Dish dish = new Dish(name.hashCode(),name,5.5f,ingredients);
        
        String outFilePath = String.format("Exemples\\generated\\%d\\%s",dish.getId(),dish.getNom());

        DishFileWriterController writer = new DishFileWriterController(outFilePath);
        writer.setDish(dish);
        Writer.WriteStatus status;

        if ((status = writer.tryWrite()) == Writer.WriteStatus.OUT_FILE_PATH_NOT_FOUND) {
            throw new Exception(String.format("Le fichier à l'adresse :%s est introuvable", outFilePath));

        } else {
            System.out.println(status);
        }

    }
}
