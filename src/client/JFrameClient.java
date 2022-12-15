package client;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import player.Player;

@SuppressWarnings("serial")
public class JFrameClient extends JFrame {
	
	private Player player;
	private static JTextField textField = new JTextField();
	
	public JFrameClient(Player player) {
		this.player = player;
	}
	
	public void charStateWindow() {

		//JLAbel icon represents the "visual state" of the character
		ImageIcon characterImage = player.getAppearance();
		JLabel image = new JLabel();
		image.setBounds(0, 0, 500, 400);
		image.setIcon(characterImage);
		
		//setting JFrame and initial configuration
		JFrame frame = new JFrame("Character state test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(900, 700);
		
		//JPanel for character context
		JPanel context = new JPanel();
		context.setBounds(0, 0, 900, 500);
		context.setBackground(Color.GRAY);
		
		//adding the image to the context
        context.add(image); 
        
        //JPanel for textField with character state description
        JPanel charStats = new JPanel();
        charStats.setBounds(0, 500, 900, 70);
        charStats.setLayout(new BoxLayout(charStats, BoxLayout.X_AXIS));
        charStats.add(textField);
        
		//JPanel for buttons
		JPanel testBar = new JPanel();
		testBar.setBounds(0, 570, 900, 100);

		//Buttons configurations
		JButton doDamage = new JButton("Do damage");
        doDamage.addActionListener(e -> {
        	player.getState().takeDamage();
        	image.setIcon(player.getAppearance());
        	textField.setText(player.toString());
        });
        
        JButton recieveHealth = new JButton("Recover health");
        recieveHealth.addActionListener(e -> {
        	player.getState().heal();
        	image.setIcon(player.getAppearance());
        	textField.setText(player.toString());
        });
        
        JButton recievePoison = new JButton("Recieve poison");
        recievePoison.addActionListener(e -> {
        	player.getState().takePoison();
        	image.setIcon(player.getAppearance());
        	textField.setText(player.toString());
        });
        
        JButton curePoison = new JButton("Cure poison");
        curePoison.addActionListener(e -> {
        	player.curePoison();
        	image.setIcon(player.getAppearance());
        	textField.setText(player.toString());
        });
        
        JButton revive = new JButton("Revive character");
        revive.addActionListener(e -> {
        	this.player.reviveCharacter();
        	image.setIcon(player.getAppearance());
        	textField.setText(player.toString());
        });
        
        //adding buttons to the JPanel testBar
        testBar.add(doDamage);
        testBar.add(recieveHealth);
        testBar.add(recievePoison);
        testBar.add(curePoison);
        testBar.add(revive);
        
        //adding JPanels to the JFrame
        frame.add(context);
        frame.add(charStats);
        frame.add(testBar);
	}
}
