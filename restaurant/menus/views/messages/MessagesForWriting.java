package restaurant.menus.views.messages;

import javax.swing.JOptionPane;
import restaurant.models.StringRessources;
import static restaurant.models.StringRessources.SUCCEEDED_OPERATION;
import restaurant.models.writers.Writer;

/**
 *
 * @author MAZE2
 */
public class MessagesForWriting {

    public static void showMessage(Writer.WriteStatus status) {

        String title;
        int iconMessageBox;
        switch (status) {
            case OUT_FILE_PATH_NOT_FOUND:
                title = StringRessources.FILE_NOT_FOUND.toString();
                iconMessageBox = JOptionPane.ERROR_MESSAGE;
                break;
            case SUCEED:
                title = SUCCEEDED_OPERATION.toString();
                iconMessageBox = JOptionPane.INFORMATION_MESSAGE;
                break;
            case TERMINATE_BADLY:
                title = "Les opérations se sont mal terminées";
                iconMessageBox = JOptionPane.ERROR_MESSAGE;
                break;
            default:
                title = "erreur inconnue";
                iconMessageBox = JOptionPane.ERROR_MESSAGE;
                break;
        }
        javax.swing.JOptionPane.showMessageDialog(null, status.getMessage(), title, iconMessageBox);

    }

    public static boolean showYesNoQuestion(String question) {
        final JOptionPane optionPane = new JOptionPane(
                question,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);
        return JOptionPane.showConfirmDialog(optionPane, question) == JOptionPane.YES_OPTION;
        
    }
}
