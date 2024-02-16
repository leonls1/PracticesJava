package practices.socketsVideos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Cliente {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoCliente mimarco = new MarcoCliente();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(600, 300, 280, 350);

        LaminaMarcoCliente milamina = new LaminaMarcoCliente();

        add(milamina);

        setVisible(true);
    }

}

class LaminaMarcoCliente extends JPanel {

    public LaminaMarcoCliente() {
        
        nick = new JTextField(5);
        
        add(nick);

        JLabel texto = new JLabel("CHAT");

        add(texto);
        
        ip = new JTextField(8);
        
        add(ip);
        
        campochat = new JTextArea(12, 20);
        
        add(campochat);

        campo1 = new JTextField(20);

        add(campo1);

        miboton = new JButton("Enviar");
        
        SendMessage event = new SendMessage();
        
        miboton.addActionListener(event);

        add(miboton);

    }

    private class SendMessage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            try {
                Socket mySocket = new Socket("192.168.0.19",9999);
                
                //creando el objeto con los datos necesarios para enviar mi mensaje
                PaqueteEnviado datos = new PaqueteEnviado(campo1.getText(),
                        ip.getText(),
                        nick.getText());
                //creando el flujo por donde va a ir el objeto 
                ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
                //enviando el objeto
                oos.writeObject(datos);
                mySocket.close();
                
                
                /*
                DataOutputStream outStream = new DataOutputStream(mySocket.getOutputStream());
                
                outStream.writeUTF(campo1.getText());
                outStream.close();
                */
                
            } catch (IOException ex) {
                Logger.getLogger(LaminaMarcoCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

    private JTextField campo1, nick, ip;

    private JButton miboton;
    
    private JTextArea campochat;

     
}

class PaqueteEnviado implements Serializable{
    
    private static final long  SerialVersionUID = 1L;
    
    private String mensaje, ip, nick;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public PaqueteEnviado() {
    }

    public PaqueteEnviado(String mensaje, String ip, String nick) {
        this.mensaje = mensaje;
        this.ip = ip;
        this.nick = nick;
    }
    
    
}