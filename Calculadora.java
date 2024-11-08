import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculadora extends JFrame {
    //Creo la lista pra los botones
    List<JButton> bntSimples = new ArrayList<>();
    List<JButton> bntComplejos = new ArrayList<>();

    public Calculadora() {
        setTitle("Calculadora");
        setLayout(new GridBagLayout());
        JPanel contentPane = (JPanel) getContentPane();
        JPanel panel = new JPanel(new GridLayout(4,5));
        JLabel pantalla = new JLabel("");
        add(pantalla);

            //Creacion de botones
        for(int i = 0; i < 10; i++){
        
            JButton btn = new JButton(""+ i);
        
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    pantalla.setText(pantalla.getText() + btn.getText());
                }
                
            });
            bntSimples.add(btn);
            panel.add(btn);

        }
        contentPane.add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
        JButton igual = new JButton("=");
        igual.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    calculos(pantalla.getText());
                }
        });

    }

    public double calculos(String cadena){

        Expression expresion = new ExpressionBuilder(cadena).build();
        return expresion.evaluate();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculadora();
            }
        });
    }
}
