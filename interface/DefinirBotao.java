import java.awt.Dimension;
import javax.swing.*;

public class DefinirBotao{
    public void definebutton(JButton button, Dimension buttonDimension){
        button.setPreferredSize(buttonDimension);
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
    }
}