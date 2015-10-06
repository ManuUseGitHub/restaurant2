/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import restaurant.models.parsers.DishParser;

/**
 *
 * @author MAZE2
 */
public class DishFileReader extends Reader {

    private List contents;
    private DishParser pars;

    public DishFileReader() {
        super();
        pars = new DishParser();
    }

    public DishFileReader(String inFilePath) {
        super("Exemples\\generated\\2026687372\\Soupe aux cressons");     // hardcodé !
        pars = new DishParser();
    }

    @Override
    public ReadStatus read() {

        ReadStatus status = ReadStatus.READY;                   // état par défaut
        Path cheminFichierEntree = Paths.get(getInFilePath());  // le fichier à lire

        try (BufferedReader entree = Files.newBufferedReader(cheminFichierEntree, StandardCharsets.UTF_8)) {
            
            String lignelue;
            while ((lignelue = entree.readLine()) != null) {    // lecture jusqu'à la fin du fichier
                completeModel(lignelue, lignelue.split(":"));   // remplissage d'un modèle WORK grâce à un parsage
            }

        } catch (IOException ex) {
            status = ReadStatus.FILE_NOT_FOUND;                 // erreur d'un chemin vers un fichier incorrect ou innexistant
        }
        return status;
    }

    private void completeModel(String lignelue, String[] lignesAvecColonnes) {
        if (lignesAvecColonnes.length > 1) {                    // plusieurs colones après le split de ":" sur la chaine
            pars.completeEtudiant(lignelue, lignesAvecColonnes[1]);
        } else if (lignesAvecColonnes.length == 1) {            // si le split ne renvoit qu'une information => pas de colonne ":"
            pars.completeEtudiant(lignelue.trim(), lignesAvecColonnes[0]);  // trim pour retirer les tabulations !!!
        }
    }

    /**
     * @return the target
     */
    @Override
    public List getContentRead() {
        return contents;
    }
}
