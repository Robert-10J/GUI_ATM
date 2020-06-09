import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.File;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Login extends JFrame {

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Registro";

    private JPanel panel;
    private JTextField user;
    private JTextField nip;
    private JButton regis;

    public Login() {
        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Inicio ATM");
        this.setResizable(false);

        inicializarCom();
    }

    private void inicializarCom() {
        establecerPanel();
        labels();
        jtUser();
        jtNip();
        btnAcep();
        btnRegistro();
    }

    private void establecerPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panel);
    }

    private void labels() {
        ImageIcon img = new ImageIcon("Logo.jpg");
        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(150, 25, 200, 80);
        etiqueta.setIcon(new ImageIcon(img.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH)));
        panel.add(etiqueta);

        JLabel userEt = new JLabel();
        userEt.setText("Ingrese su usuario:");
        userEt.setFont(new Font("Arial", Font.BOLD, 14));
        userEt.setBounds(50, 180, 175, 20);
        panel.add(userEt);

        JLabel nipEt = new JLabel();
        nipEt.setText("Ingrese su nip:");
        nipEt.setFont(new Font("Arial", Font.BOLD, 14));
        nipEt.setBounds(50, 220, 175, 20);
        panel.add(nipEt);
    }

    private void jtUser() {
        user = new JTextField(10);
        user.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ev) {
                char caracter = ev.getKeyChar();

                if(((caracter < '0') || (caracter > '9')) && (caracter !='\b' ))
                {
                    ev.consume();
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
        user.setBounds(200, 175, 100, 25);
        user.setFont(new Font("Consolas", 1, 12));
        panel.add(user);
    }

    private void jtNip()
    {
        nip = new JTextField(10);
        nip.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent eNip) {
                
                char caracter = eNip.getKeyChar();

                if(((caracter < '0') || (caracter > '9')) && (caracter !='\b' ))
                {
                    eNip.consume();
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
        nip.setBounds(200, 215, 100, 25);
        nip.setFont(new Font("Consolas", 1, 12));
        panel.add(nip);
    }  

    /* En este metodo se manda a llamar el JFrame donde se encuetra el menu
    y se usa este metodo en el siguiente en el evento aceptar */
    public void frame()
    {
        Componentes menu = new Componentes();
        menu.setVisible(true);
    }

    private void btnAcep()
    {
        final JButton acep = new JButton("Aceptar");
        acep.setBounds(340, 160, 90, 30);
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
                   frame();
                 }
            }
        }; acep.addActionListener(acept);   
    } 

    private void btnRegistro()
    {
        regis = new JButton("Registrar");
        regis.setBounds(340, 220, 90, 30);
        regis.setBackground(Color.lightGray);
        regis.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(regis);
  
            final ActionListener save = new ActionListener() {

            @Override
            public void actionPerformed(final java.awt.event.ActionEvent ae) {
                
                final String archivo = user.getText() + "Registros";
                final File crearUbicaFile = new File(ubicacion);
                final File crearArchivo = new File (ubicacion + archivo);

                    if(user.getText().equals("") || nip.getText().equals("")) {
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
}