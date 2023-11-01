package noapplet.JavaChatUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatUI extends JPanel{

    public ChatUI(){

        setLayout(new FlowLayout(FlowLayout.LEFT));
        var button = new JButton("Connect");
        var s = new JTextField("Server", 20);
        var p = new JTextField("Port", 5);

        JTextArea text = new JTextArea();
        JScrollPane scroll = new JScrollPane(text);
        scroll.setPreferredSize(new Dimension(378, 290));
        scroll.createVerticalScrollBar().setUnitIncrement(30);

        JTextField message = new JTextField("Enter a Message.", 32);

        JButton send = new JButton("Send");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = message.getText();
                if(!user.isEmpty()){
                    text.append(user + "\n");
                    message.setText("");
                }
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(button.getText().equals("Connect")) {
                    button.setText("Disconnect");
                    JOptionPane.showMessageDialog(button, "Not connected to a server!");
                }
                else if(button.getText().equals("Disconnect")){
                    button.setText("Connect");
                }
            }
        });

        add(button);
        add(s);
        add(p);
        add(scroll);
        add(message);
        add(send);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JavaChat");
        frame.setSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChatUI());
        frame.setVisible(true);
    }
}
