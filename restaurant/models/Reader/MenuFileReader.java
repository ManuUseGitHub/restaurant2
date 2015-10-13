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
import restaurant.models.work.Dish;
import restaurant.models.work.Menu;

/**
 *
 * @author MAZE2
 */
public class MenuFileReader extends Reader {

    private Menu current;

    public MenuFileReader(String inFilePath) {
        super(inFilePath);
        current = new Menu();
    }

    @Override
    public ReadStatus read() {
        ReadStatus status = ReadStatus.READY;                   // état par défaut
        Path cheminFichierEntree = Paths.get(getInFilePath());  // le fichier à lire
        try (BufferedReader entree = Files.newBufferedReader(cheminFichierEntree, Charset.forName("utf-8"));) {
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

    @Override
    public Object getResult() {
        return current;
    }

    public void setInstance(String line, BufferedReader r) throws IOException {
        if (line.matches(String.format(".*(Menu).*"))) {
            current = new Menu();
        } else if (line.matches(".*(Id|Name|Price|Entrée|Principal|Dessert|Boisson).*")) {
            String[] subs = line.split(":");
            MenuEnumKeys key = MenuEnumKeys.parse(subs[0].trim());

            switch (key) {
                case ID:
                    current.setId(Integer.parseInt(subs[1]));
                    break;
                case NAME:
                    current.setNom(subs[1]);
                    break;
                case PRICE:
                    current.setPrix(Float.parseFloat(subs[1]));
                    break;
                default:
                    treatMenuCourses(key, r);
                    break;
            }
        }
    }

    private void treatMenuCourses(MenuEnumKeys key, BufferedReader reader) throws IOException {
        if (key == MenuEnumKeys.AFTER_COURSE || key == MenuEnumKeys.DRINK
                || key == MenuEnumKeys.ENTRY || key == MenuEnumKeys.MAIN_COURSE) {
            String course = reader.readLine().trim();
            DishFileReader dishR;
            while (course != null && !course.equals("")) {

                dishR = new DishFileReader("Exemples\\" + course + "\\" + course);
                dishR.read();
                String regKey = key.getValue();
                current.AddDish(regKey, ((Dish)dishR.getResult()));
                course = reader.readLine().trim();
            }
        }
    }
}
