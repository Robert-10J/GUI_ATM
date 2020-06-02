import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Componentes extends JFrame {

    public JPanel panel;
    public JScrollPane bar;
    public JTextField user;
    public JTextField nip;
    public JTextField opcion;
    public JTextField can;
    private JButton acepOP;
    private JButton salirB;
    private JButton acepDep;
    private JButton regis;

    private JLabel mp;
    private JLabel saldo;
    private JLabel deF;
    private JLabel salir;
    private JLabel ingOp;
    private JLabel conSaldo;
    private JLabel deposito;
    private JLabel salirS;

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Registro" + barra;

    public Componentes()
    {
        this.setSize(500, 900);
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
        btnAcep();
        btnRegistro();
        jtNip();
        jtUser();
        opAcep();
        scroll();
    }

    private void panel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        
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
        ImageIcon img = new ImageIcon("Logo.jpg");
        final JLabel  etiqueta = new JLabel();
        etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
        etiqueta.setBounds(130, 25, 200, 80);
        etiqueta.setIcon(new ImageIcon(img.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH)));
        panel.add(etiqueta);
        
        final JLabel userEt = new JLabel();
        userEt.setText("Ingrese su usuario:");
        userEt.setFont(new Font("Arial", Font.BOLD, 14));
        userEt.setBounds(50, 180, 175, 20);
        panel.add(userEt);
        
        final JLabel nipEt = new JLabel();
        nipEt.setText("Ingrese su nip:");
        nipEt.setFont(new Font("Arial", Font.BOLD, 14));
        nipEt.setBounds(50, 220, 175, 20);
        panel.add(nipEt);
                
        mp = new JLabel();
        mp.setFont(new Font("Arial", Font.PLAIN, 14));
        mp.setBounds(50, 350, 175, 20);
        panel.add(mp);

        saldo = new JLabel();
        saldo.setFont(new Font("Arial", Font.PLAIN, 14));
        saldo.setBounds(50, 375, 175, 20);
        panel.add(saldo);

        deF = new JLabel();
        deF.setFont(new Font("Arial", Font.PLAIN, 14));
        deF.setBounds(50, 400, 175, 20);
        panel.add(deF);

        salir = new JLabel();
        salir.setFont(new Font("Arial", Font.PLAIN, 14));
        salir.setBounds(50, 425, 175, 20);
        panel.add(salir);

        ingOp = new JLabel();
        ingOp.setFont(new Font("Arial", Font.PLAIN,14));
        ingOp.setBounds(50, 490, 200, 20);
        panel.add(ingOp);
        
        conSaldo = new  JLabel();
        conSaldo.setFont(new Font("Arial", 0, 14));
        conSaldo.setBounds(50, 550, 150, 20);
        panel.add(conSaldo);

        deposito = new JLabel();
        deposito.setFont(new Font("Arial", 0, 14));
        deposito.setBounds(50, 550, 200, 20);
        panel.add(deposito);

        salirS = new JLabel();
        salirS.setFont(new Font("Arial", 0, 14));
        salirS.setBounds(150, 570, 250, 20);
        panel.add(salirS);
    }

    private void jtUser()
    {
        user = new JTextField(10);
        user.setBounds(200, 175, 100, 25);
        user.setFont(new Font("Consolas", 1, 12));
        panel.add(user);
    }

    private void jtNip()
    {
        nip = new JTextField();
        nip.setBounds(200, 215, 100, 25);
        nip.setFont(new Font("Consolas", 1, 12));
        panel.add(nip);
    }
    private void btnAcep()
    {
        final JButton acep = new JButton("Aceptar");
        acep.setBounds(100, 280, 90, 30);
        acep.setBackground(Color.lightGray);
        acep.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(acep);

            final ActionListener acept = new ActionListener(){
        
            @Override
            public void actionPerformed(final ActionEvent ap){
                 
                String text = user.getText();
                String textN = nip.getText();
                textN = textN.replaceAll(" ", " ");
                text = text.replaceAll(" ", "");

                if(text.length() == 0 || textN.length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "No hay datos, intente de nuevo");;
                }
                 else { 
                    mp.setText("Menu principal:");
                    saldo.setText("1.- Saldo");
                    deF.setText("2.- Depositar fondos");
                    salir.setText("3.- Salir");

                    ingOp.setText("Ingrese la opcion que desea: ");
                    
                    opcion = new JTextField();
                    opcion.setBounds(235, 490, 50, 20);
                    panel.add(opcion);

                    acepOP.setVisible(true);
                    acep.setVisible(false);
                    regis.setVisible(false);
            }  
            }
        }; acep.addActionListener(acept);   
    }    

    private void btnRegistro()
    {
        regis = new JButton("Registrar");
        regis.setBounds(250, 280, 90, 30);
        regis.setBackground(Color.lightGray);
        regis.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(regis);
  
        final ActionListener save = new ActionListener() {

            @Override
            public void actionPerformed(final java.awt.event.ActionEvent ae) {
                
                final String archivo = user.getText() + "Registros";
                final File crearUbicaFile = new File(ubicacion);
                final File crearArchivo = new File (ubicacion + archivo);

                    if(user.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "No gay datos");
                    }
                     else {
                         try{
                             if(crearArchivo.exists()){
                                 JOptionPane.showMessageDialog(null, "El registro ya existe");
                             }
                             else {
                                 crearUbicaFile.mkdirs();
                                 final Formatter crea = new Formatter(ubicacion + archivo);
                                 crea.format("%s\r\n%s\r\n", "Usuario = " + user.getText(), "Nip = " + nip.getText());
                                 crea.close();
                                 JOptionPane.showMessageDialog(null, "Se ha creado el archivo");
                             }
                         }
                          catch(final Exception e) {
                            JOptionPane.showMessageDialog(null, "No se ha creado el archivo");
                          }
                     }
            }
        };
        regis.addActionListener(save);
    }

    private void opAcep()
    {
        acepOP = new JButton("Aceptar");
        acepOP.setBounds(300, 483, 90, 28);
        acepOP.setBackground(Color.LIGHT_GRAY);
        acepOP.setFont(new Font("Arial", Font.BOLD, 12));
        acepOP.setVisible(false);
        panel.add(acepOP);

          ActionListener opM = new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent opt){
                
                switch(opcion.getText()){
                    
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
                        can = new JTextField();
                        can.setBounds(235, 550, 50, 20);
                        can.setVisible(true);
                        panel.add(can);
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
        salirB.setBounds(200, 600, 75, 20);
        salirB.setBackground(Color.LIGHT_GRAY);
        salirB.setFont(new Font("Arial", 0, 12));
        panel.add(salirB);
        salirB.setVisible(false);

        /*Este evento ayuda a que el boton salir cierre la ventana
        y para de ejecutar el programa*/
        ActionListener sal = new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent ext) {
                System.exit(0);
            }
        }; salirB.addActionListener(sal);
    }

    private void acepDeposito()
    {
        acepDep = new JButton("Aceptar");
        acepDep.setBounds(300, 546, 95, 25);
        acepDep.setBackground(Color.LIGHT_GRAY);
        acepDep.setFont(new Font("Arial", 1, 12));
        acepDep.setVisible(false);
        panel.add(acepDep);
    } 
}