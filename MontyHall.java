import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.ImageIcon;
import java.util.concurrent.ThreadLocalRandom;

public class MontyHall implements ActionListener {
	JFrame F;
	JTextArea description;
	JButton card1, card2, card3, card4, card5, exit;

	MontyHall(){
		F = new JFrame("5 Card Monty Hall Demonstration");
		F.setResizable(false);
		F.setSize(600,400);  
		F.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 15)); 
		
		description = new JTextArea(5, 51);  
		description.setEditable(false);
		description.setWrapStyleWord(true);
		description.setLineWrap(true);
		description.setMargin(new Insets(10,10,10,10));
		description.setText("Description:\n" +
				"You are dealt 5 face down cards to choose from.\n" +
				"1 card is black and the other 4 are red.\n" +
				"You must pick the black card to win.");
		F.add(description);

		card1 = new JButton();
		card2 = new JButton();
		card3 = new JButton();
		card4 = new JButton();
		card5 = new JButton();
		exit = new JButton("exit");
		
		try {
		card1.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/card1.png")).getImage()));
		card2.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/card2.png")).getImage()));
		card3.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/card3.png")).getImage()));
		card4.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/card4.png")).getImage()));
		card5.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/card5.png")).getImage()));
		} catch (NullPointerException ex){
			JOptionPane.showMessageDialog(null, "Missing card image", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		card1.addActionListener(this);
		card2.addActionListener(this);
		card3.addActionListener(this);
		card4.addActionListener(this);
		card5.addActionListener(this);
		exit.addActionListener(this);

		card1.setActionCommand("card1");
		card2.setActionCommand("card2");
		card3.setActionCommand("card3");
		card4.setActionCommand("card4");
		card5.setActionCommand("card5");

		F.add(card1);
		F.add(card2);
		F.add(card3);
		F.add(card4);
		F.add(card5);
		
		F.setVisible(true);  
		F.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e){

		// This visual demonstration is essentially hard coded and doesn't randomly flip red cards or show a black card.
		// It is meant to convey the solution concept.
		// The simulation() function does run the randomized nature of the true game
		if(e.getActionCommand() == "card1") {
			
			card1.setActionCommand("remain");
			card1.setToolTipText("remain");
			
			card2.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card2.removeActionListener(this);
			
			card3.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card3.removeActionListener(this);
			
			card4.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card4.removeActionListener(this);
			
			card5.setActionCommand("repick");
			card5.setToolTipText("repick");
			
		} else if (e.getActionCommand() == "card2") {
			card1.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card1.removeActionListener(this);
			
			card2.setActionCommand("remain");
			card2.setToolTipText("remain");
			
			card3.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card3.removeActionListener(this);
			
			card4.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));	
			card4.removeActionListener(this);
			
			card5.setActionCommand("repick");
			card5.setToolTipText("repick");
			
		} else if (e.getActionCommand() == "card3") {
			
			card1.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card1.removeActionListener(this);
			
			card2.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card2.removeActionListener(this);
			
			card3.setActionCommand("remain");
			card3.setToolTipText("remain");
			
			card4.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card4.removeActionListener(this);
			
			card5.setActionCommand("repick");
			card5.setToolTipText("repick");
			
		} else if (e.getActionCommand() == "card4") {
			
			card1.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card1.removeActionListener(this);
			
			card2.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card2.removeActionListener(this);
			
			card3.setActionCommand("repick");
			card3.setToolTipText("repick");
			
			card4.setActionCommand("remain");
			card4.setToolTipText("remain");
			
			card5.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card5.removeActionListener(this);
			
		} else if (e.getActionCommand() == "card5") {
			
			card1.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card1.removeActionListener(this);
			
			card2.setActionCommand("repick");
			card2.setToolTipText("repick");
			
			card3.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card3.removeActionListener(this);
			
			card4.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/red_card.png")).getImage()));
			card4.removeActionListener(this);
			
			card5.setActionCommand("remain");
			card5.setToolTipText("remain");

		} 
		
		description.setText("After you pick a card, the dealer reveals 3 red cards and you are allowed to repick.\n" +
				"The question is, should you remain or repick?");
		
		if(e.getActionCommand()=="remain"){ 
			String remain = simulation(100000, false);
			description.setText("Choosing to stay is the worse course of action because the odds that your first pick was the black card is 1 out of 5 from the start.\n" +
					"Since 3 of the 4 red cards have been revealed, the chances that the other card is black increases to 4 of 5.\n" +
					"The decision to remain approaches a 20% win rate.\n\n" +
					"To further demonstrate, here are the results of choosing to remain after running a simulation of this game 100,000 times:\n" +
					remain);
			F.add(exit);
		} else if(e.getActionCommand()=="repick") {
			String repick = simulation(100000, true);
			description.setText("Choosing to repick is the best course of action because the odds that your first pick was the black card is 1 out of 5 from the start.\n" +
					"Since 3 of the 4 red cards have been revealed, the chances that the other card is black increases to 4 of 5.\n" +
					"The decision to repick approachs an 80% win rate.\n\n" +
					"To further demonstrate, here are the results of choosing to repick after running a simulation of this game 100,000 times:\n" +
					repick);
			F.add(exit);
		}
		
		if(e.getSource()==exit){
			System.exit(0);
		}
	}
	
	public static String simulation(int times, boolean repicked){

		int total_games = 0;
		int games_won_by_changing = 0;

		for(int i = 0; i < times; i++){
			String[] Cards = {"Red", "Red", "Red", "Red", "Red"};
			
			// randomly set 1 of the 5 cards to be the black card
			Cards[ThreadLocalRandom.current().nextInt(0, 5)] = "Black";

			// randomly pick a card between 0 and 4
			int pick = ThreadLocalRandom.current().nextInt(0, 5);

			// reveal 3 red cards out of the Cards array
			int revealed = 0;
			int offset = 0;
			while(revealed < 3){
				if(Cards[revealed+offset] == "Red"){
					Cards[revealed+offset] = "Revealed";
					revealed++;
				} else {
					offset++;
				}
			}

			// Count how often the remaining card was the black one
			if(Cards[pick] != "Black"){
				games_won_by_changing++;
			}
			total_games++;
		}
		
		if (repicked){
			return (games_won_by_changing + "/" + total_games + " games won by repicking.");
		} else {
			return ( (total_games - games_won_by_changing) + "/" + total_games + " games won by remaining.");
		}
	}

	public static void main(String[] args) {
		new MontyHall();
	}

}
