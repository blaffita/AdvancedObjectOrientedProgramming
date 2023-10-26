package noapplet.OmokuGUI;

import javax.swing.*;
import java.awt.*;

public class omoku {
    private JFrame frame;
    private JRadioButton computerRadioButton;
    private JRadioButton humanRadioButton;
    private ButtonGroup opponentGroup;
    private JButton playButton;
    private JLabel resultLabel;

    public omoku() {
        frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));

        computerRadioButton = new JRadioButton("Computer", true);
        humanRadioButton = new JRadioButton("Human", true);

        opponentGroup = new ButtonGroup();
        opponentGroup.add(computerRadioButton);
        opponentGroup.add(humanRadioButton);

        playButton = new JButton("Play");
        resultLabel = new JLabel();

        playButton.addActionListener(e -> {
            if (computerRadioButton.isSelected()) {
                resultLabel.setText("Computer selected!");
            } else if (humanRadioButton.isSelected()) {
                resultLabel.setText("Human selected!");
            }
        });

        panel.add(new JLabel("Select Opponent:"));
        panel.add(computerRadioButton);
        panel.add(humanRadioButton);
        panel.add(playButton);
        panel.add(resultLabel);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new omoku());
    }
}