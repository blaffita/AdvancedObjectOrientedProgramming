package noapplet.CounterApp;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Counter extends NoApplet {

    private CounterModel model = new CounterModel();

    public Counter(){
        this(new String[0]);
    }
    public Counter(String[] params){
        super(params);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("value: "));
        var display = new JTextField(5);

        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setText(Integer.toString(model.value()));

        var incrButton = new JButton("Increment");
        var decrButton = new JButton("Decrement");
        var zeroButton = new JButton("Zero");
        Color color = incrButton.getBackground();
        incrButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                incrButton.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                incrButton.setBackground(color);
            }
        });


        incrButton.addActionListener(e -> {
            model.incr();
            display.setText(Integer.toString(model.value()));
        });
        decrButton.addActionListener(e -> {
            model.decr();
            display.setText(Integer.toString(model.value()));
        });
        zeroButton.addActionListener(e -> {
            model.zero();
            display.setText(Integer.toString(model.value()));
        });

        add(display);
        add(incrButton);
        add(decrButton);
        add(zeroButton);
    }

    public static void main(String[] args){
        new Counter().run();
    }
}
class CounterModel{
    private int value;

    public void incr(){

        value++;
    }
    public int value(){

        return value;
    }
    public void decr(){
        if(value > 0)
        value--;
    }
    public void zero(){
        value = 0;
    }

}
