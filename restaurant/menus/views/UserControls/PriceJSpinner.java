/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.menus.views.UserControls;

import java.text.DecimalFormat;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author MAZE2
 */
public class PriceJSpinner extends JSpinner {

    public PriceJSpinner(float min, float val, float max) {
        this.setValue(val);
        float stepSize = 1.00f;
        SpinnerNumberModel model = new SpinnerNumberModel(val, min, max, stepSize);
        this.setModel(model);

        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) this.getEditor();;
        DecimalFormat format = editor.getFormat();
        format.setMinimumFractionDigits(2);
    }
    
    @Override
    public String toString(){
        JTextField field = ((JSpinner.DefaultEditor) this.getEditor()).getTextField();
        return field.getText().replace(".", "").replaceAll("\\,", ".") + "f";
    }
}
