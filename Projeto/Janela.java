import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class Janela {
    JButton botao;
    JTextField campoTexto;
    JTextArea area;
    JFrame janela;
    JLabel label;

    public Janela(String nomeTela, String nomeBotao, String descricao) {
        botao = new JButton(nomeBotao);
        campoTexto = new JTextField(10);
		area = new JTextArea();
        janela = new JFrame(nomeTela);
        janela.setSize(1000, 10000);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.add(botao);
		painel.add(campoTexto);
        painel.add(area);
        
        if (descricao.length() > 0) {
            label = new JLabel(descricao);
            painel.add(label);
        }
        janela.getContentPane().add(painel);


        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                try {
                    id = Integer.parseInt(campoTexto.getText());
                } catch (Exception exp) {
                    System.out.println("Algo de errado aconteceu");
                }
                if (id > 0) {
                    ArrayList<Mensagem> messages = getMessagesFromDB(id);

                    String print = "";
                    for (Mensagem msg : messages) {
                        print = print + msg.toString();
                        print = print + "\n";
                    }
                    area.setText(print);
                } else {
                    String text = campoTexto.getText();
                    if (text.contains("exit")) janela.dispose();
                }
            }
        };

        botao.addActionListener(action);

        janela.setVisible(true);
    };

    public ArrayList<Mensagem> getMessagesFromDB(int grupoId) {
        ArrayList<Mensagem> messages = new ArrayList<Mensagem>();
        String groupDB = "dataBase/grupos/" + grupoId;
        File fileGroupDB = new File(groupDB);
        File[] messageFiles = fileGroupDB.listFiles();

        for (int i = 0; i < messageFiles.length; i++) {
            String file = groupDB + "/" + messageFiles[i].getName();
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));

                Mensagem msg = (Mensagem) input.readObject();
                messages.add(msg);
                input.close();
            } catch (EOFException e) {
                return null;
            } catch (ClassNotFoundException er) {
                System.err.print("Classe incompatível");
                System.exit(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (messages.size() > 0)
            return messages;

        return null;
    }
}