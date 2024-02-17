

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

public FortuneTellerFrame()
{

  super("Fortune Teller");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(1000,1000);
  setResizable(false);
  setLocationRelativeTo(null);

        //fortunes generated via chatgpt
                    fortunes = new ArrayList<>();
                    fortunes.add("Opportunities are everywhere, seize them with confidence.");
                    fortunes.add("Your kindness will be repaid tenfold in unexpected ways.");
                    fortunes.add("Believe in the magic within yourself, it holds the key to your dreams.");
                    fortunes.add("Believe in the magic within yourself, it holds the key to your dreams.");
                    fortunes.add("Embrace change, for it is the only constant in life.");
                    fortunes.add("A smile is your best accessory; wear it often.");
                    fortunes.add("Your creativity knows no bounds; let it flow freely.");
                    fortunes.add("The present moment is a gift; cherish it fully.");
                    fortunes.add("Success is not measured by material wealth but by the lives you touch.");
                    fortunes.add("Forgive others, not because they deserve forgiveness, but because you deserve peace.");
                    fortunes.add("Your positive attitude will lead to favorable outcomes.");
                    fortunes.add("Courage is not the absence of fear, but the triumph over it.");


        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        ImageIcon icon = new ImageIcon("C:\\Users\\rmsmi\\IdeaProjects\\Lab4\\src");
        titleLabel.setIcon(icon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 36));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("Arial", Font.BOLD, 36));
        readButton.addActionListener((ActionEvent e) ->
        {
            String fortune = getRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 36));
        quitButton.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });


        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }



    private String getRandomFortune()
    {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex)
        {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}
