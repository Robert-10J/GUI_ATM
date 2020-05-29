import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Componentes extends JFrame {

    public JPanel panel;
    public JTextField user;
    public JTextField nip;
    public JTextField opcion;
    private JButton acepOP;

    private JLabel mp;
    private JLabel saldo;
    private JLabel deF;
    private JLabel salir;
    private JLabel ingOp;
    private JLabel op;

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
    }

    private void panel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void colocarEtiquetas()
    {
        final JLabel  etiqueta = new JLabel();
        etiqueta.setText("¡Bienvenidos a ATM!");
        etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
        etiqueta.setBounds(130, 25, 200, 25);
        panel.add(etiqueta);
        
        final JLabel userEt = new JLabel();
        userEt.setText("Ingrese su usuario:");
        userEt.setFont(new Font("Arial", Font.BOLD, 14));
        userEt.setBounds(50, 120, 175, 20);
        panel.add(userEt);
        
        final JLabel nipEt = new JLabel();
        nipEt.setText("Ingrese su nip:");
        nipEt.setFont(new Font("Arial", Font.BOLD, 14));
        nipEt.setBounds(50, 170, 175, 20);
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
        ingOp.setBounds(50, 460, 200, 20);
        panel.add(ingOp);
        
    }

    private void jtUser()
    {
        user = new JTextField();
        user.setBounds(200, 120, 100, 25);
        panel.add(user);
    }

    private void jtNip()
    {
        nip = new JTextField();
        nip.setBounds(200, 165, 100, 25);
        panel.add(nip);
    }

    private void btnAcep()
    {
        final JButton acep = new JButton("Aceptar");
        acep.setBounds(100, 250, 90, 35);
        acep.setBackground(Color.lightGray);
        acep.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(acep);

            final ActionListener acept = new ActionListener(){
        
            @Override
            public void actionPerformed(final ActionEvent ap){
                
                mp.setText("Menu principal:");
                saldo.setText("1.- Saldo:");
                deF.setText("2.- Depositar fondos:");
                salir.setText("3.- Salir:");

                ingOp.setText("Ingrese la opcion que desea: ");
                
                opcion = new JTextField();
                opcion.setBounds(235, 460, 50, 20);
                panel.add(opcion);

                acepOP.setVisible(true);
            }
        }; acep.addActionListener(acept);           
    }

    private void btnRegistro()
    {
        final JButton regis = new JButton("Registrar");
        regis.setBounds(250, 250, 90, 35);
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
        acepOP.setBounds(300, 453, 90, 28);
        acepOP.setBackground(Color.LIGHT_GRAY);
        acepOP.setFont(new Font("Arial", Font.BOLD, 12));
        acepOP.setVisible(false);
        panel.add(acepOP);
    }
}