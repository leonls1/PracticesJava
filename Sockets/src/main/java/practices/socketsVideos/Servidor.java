package practices.socketsVideos;

import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoServidor mimarco = new MarcoServidor();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoServidor extends JFrame implements Runnable {

    public MarcoServidor() {

        setBounds(1200, 300, 280, 350);

        JPanel milamina = new JPanel();

        milamina.setLayout(new BorderLayout());

        areatexto = new JTextArea();

        milamina.add(areatexto, BorderLayout.CENTER);

        add(milamina);

        setVisible(true);

        Thread hiloEscucha = new Thread(this);

        hiloEscucha.start();

    }

    private JTextArea areatexto;

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9999);

            String nick, ip, mensaje;

            PaqueteEnviado paqueteRecivido;
            while (true) {
                Socket mySocket = server.accept();

                ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());

                paqueteRecivido = (PaqueteEnviado) ois.readObject();

                //cargando los campos que recibo desde mi cliente 1 al servidor
                nick = paqueteRecivido.getNick();
                ip = paqueteRecivido.getIp();
                mensaje = paqueteRecivido.getMensaje();
                /*
                DataInputStream inputStream = new DataInputStream(mySocket.getInputStream());
                String message = inputStream.readUTF();

                areatexto.append("\n" + message);
                 */
                
                areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);
                mySocket.close();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
