import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Componentes extends JFrame {

    private JPanel panel;
    public JScrollPane bar;
    public JTextField opcion;
    public JTextField can;
    private JButton acepOP;
    private JButton salirB;
    private JButton acepDep;
    private JLabel mp;
    private JLabel saldo;
    private JLabel deF;
    private JLabel salir;
    private JLabel ingOp;
    private JLabel conSaldo;
    private JLabel deposito;
    private JLabel salirS;
    private JLabel depEx;

    public Componentes()
    {
        this.setSize(500, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("ATM");
        this.setResizable(false);

        iniciarComponentes();
    }

    private void iniciarComponentes()
    {   
        panel();
        colocarEtiquetas();
        opAcep();
        scroll();
        op();
    }

    private void panel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panel);
    }

    private void scroll()
    {
        bar = new JScrollPane();
        bar.setBounds(5, 10, 300, 900);
        bar.setViewportView(panel);
        panel.setPreferredSize(new Dimension(550, 1000));
        add(bar);
    }

    private void colocarEtiquetas()
    {           
        JLabel welc = new JLabel("¡Bienvenidos ATM!");
        welc.setFont(new Font("Consolas", Font.BOLD, 20));
        welc.setBounds(140, 50, 350, 20);
        panel.add(welc);

        mp = new JLabel();
        mp.setText("Menu principal");
        mp.setFont(new Font("Arial", Font.PLAIN, 14));
        mp.setBounds(50, 150, 175, 20);
        panel.add(mp);

        saldo = new JLabel();
        saldo.setText("1.- Saldo");
        saldo.setFont(new Font("Arial", Font.PLAIN, 14));
        saldo.setBounds(50, 175, 175, 20);
        panel.add(saldo);

        deF = new JLabel();
        deF.setText("2.- Depositar fondos");
        deF.setFont(new Font("Arial", Font.PLAIN, 14));
        deF.setBounds(50, 200, 175, 20);
        panel.add(deF);

        salir = new JLabel();
        salir.setText("3.- Salir");
        salir.setFont(new Font("Arial", Font.PLAIN, 14));
        salir.setBounds(50, 225, 175, 20);
        panel.add(salir);

        ingOp = new JLabel();
        ingOp.setText("Ingrese la opcion que desea: ");
        ingOp.setFont(new Font("Arial", Font.PLAIN,14));
        ingOp.setBounds(50, 260, 200, 20);
        panel.add(ingOp);
        
        conSaldo = new  JLabel();
        conSaldo.setFont(new Font("Arial", 0, 14));
        conSaldo.setBounds(50, 320, 150, 20);
        panel.add(conSaldo);

        deposito = new JLabel();
        deposito.setFont(new Font("Arial", 0, 14));
        deposito.setBounds(50, 320, 200, 20);
        panel.add(deposito);

        salirS = new JLabel();
        salirS.setFont(new Font("Arial", 0, 14));
        salirS.setBounds(150, 320, 250, 20);
        panel.add(salirS);

        depEx = new JLabel();
        depEx.setFont(new Font("Arial", 0, 14));
        depEx.setBounds(50, 380, 250, 25);
        panel.add(depEx);
    }

    private void op()
    {
        opcion = new JTextField();
        opcion.setBounds(240, 260, 50, 20);
        
        opcion.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent eP) {
                char carac = eP.getKeyChar();

                if(((carac < '0') || (carac > '9')) && (carac !='\b' ))
                {
                    eP.consume();
                }


            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }
            
        });
        panel.add(opcion);
    }

    private void jtCant()
    {
        can = new JTextField(10);
        can.setBounds(235, 320, 50, 20);
        can.setVisible(false);

        can.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent eC) {
                
                char carac = eC.getKeyChar();

                if(((carac < '0') || (carac > '9')) && (carac !='\b' ))
                {
                    eC.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }
            
        });
        panel.add(can);
        
       
    }

    private void opAcep()
    {
        acepOP = new JButton("Aceptar");
        acepOP.setBounds(300, 255, 90, 28);
        acepOP.setBackground(Color.LIGHT_GRAY);
        acepOP.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(acepOP);

          ActionListener opM = new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent opt){
                
                switch(opcion.getText()) {
                    
                    case "1": 
                        conSaldo.setText("Su saldo es: ");
                        deposito.setText("");
                        can.setVisible(false);
                        acepDep.setVisible(false);
                        salirS.setText("");
                        salirB.setVisible(false);
                        break;

                    case "2":
                        deposito.setText("Ingrese su saldo a depositar:");
                        // JFormattedTextField textField1 = new JFormattedTextField (new Integer(3));
                        //can = new JTextField();
                        /*can = new JFormattedTextField(new Integer(5));
                        can.setBounds(235, 320, 50, 20);
                        can.setVisible(true);
                        panel.add(can);*/
                        jtCant();
                        can.setVisible(true);
                        acepDeposito();
                        acepDep.setVisible(true);
                        conSaldo.setText("");
                        break;

                    case "3":
                        salirS.setText("¡Gracias por su preferencia!");
                        salirP();
                        salirB.setVisible(true);
                        conSaldo.setText("");
                        break;
                    
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida por favor vuelva a intentarlo");
                        conSaldo.setVisible(false);
                        deposito.setVisible(false);
                        salirS.setVisible(false);
                }
            }
        }; acepOP.addActionListener(opM);
    }

    private void salirP()
    {
        salirB = new JButton("Salir");
        salirB.setBounds(200, 350, 75, 20);
        salirB.setBackground(Color.LIGHT_GRAY);
        salirB.setFont(new Font("Arial", 0, 12));
        panel.add(salirB);
        salirB.setVisible(false);

            /*Este evento ayuda a que el boton salir cierre la 
            ventana y para que el programa deje de ejecutarse*/
            ActionListener sal = new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent ext) {
                    System.exit(0);
                }
            }; salirB.addActionListener(sal);
    }

    private void acepDeposito()
    {
        acepDep = new JButton("Aceptar");
        acepDep.setBounds(300, 320, 95, 25);
        acepDep.setBackground(Color.LIGHT_GRAY);
        acepDep.setFont(new Font("Arial", 1, 12));
        acepDep.setVisible(false);
        panel.add(acepDep);

            /* En este evento se hace la validacion del deposito si se ingresa oh no un dato*/
            ActionListener okDep = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ok) {
                    
                    String text = can.getText();
                    text = text.replaceAll(" ", " ");

                        if(text.length() == 0)
                        {
                            JOptionPane.showMessageDialog(null, "No se ah ingresado la cantidad");
                        }
                         else {
                             depEx.setText("¡El deposito se a realizado con exito!");
                         }
				}
            }; acepDep.addActionListener(okDep);
    } 
}