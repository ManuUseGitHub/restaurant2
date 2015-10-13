/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import restaurant.models.work.Dish;

/**
 *
 * @author MAZE2
 */
public class DishFileReader extends Reader {

    private List contents;
    private Dish current;

    public DishFileReader(String inFilePath) {
        super(inFilePath);     
        current = new Dish();
    }

    @Override
    public ReadStatus read() {

        ReadStatus status = ReadStatus.READY;                   // état par défaut
        Path cheminFichierEntree = Paths.get(getInFilePath());  // le fichier à lire

        try (BufferedReader entree = Files.newBufferedReader(cheminFichierEntree, Charset.forName("utf-8"))) {
            String lignelue = entree.readLine();
            while (lignelue != null) {              // lecture jusqu'à la fin du fichier
                setInstance(lignelue, entree);      // remplissage d'un modèle WORK grâce à un parsage
                lignelue = entree.readLine();
            }

        } catch (IOException ex) {
            status = ReadStatus.FILE_NOT_FOUND;                 // erreur d'un chemin vers un fichier incorrect ou innexistant
        }
        return status;
    }

    public void setInstance(String line, BufferedReader r) throws IOException {
        if (line.matches(String.format(".*(Plat).*"))) {
            current = new Dish();
        } else if (line.matches(".*(Id|Name|Price|Ingredients).*")) {
            String[] subs = line.split(":");
            DishEnumKeys key = DishEnumKeys.parse(subs[0].trim());
            switch (key) {
                case ID:
                    ((Dish)getResult()).setId(Integer.parseInt(subs[1]));
                    break;
                case NAME:
                    ((Dish)getResult()).setNom(subs[1]);
                    break;
                case PRICE:
                    ((Dish)getResult()).setPrix(Float.parseFloat(subs[1]));
                    break;
                case INGREDIENTS:
                    String ingredient;
                    while ((ingredient = r.readLine()) != null && !ingredient.equals("")) {
                        ((Dish)getResult()).addIngredient(ingredient.trim());
                    }
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * @return the target
     */
    public List getContentRead() {
        return contents;
    }

    @Override
    public Object getResult() {
        return current;
    }
}
