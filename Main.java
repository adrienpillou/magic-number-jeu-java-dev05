package fr.adrienpillou.tps;

import javax.swing.JOptionPane;

public class Main {
	
	static int min, max;
	static int magicNumber;
	static int mode;
	static int turns = 0;
	static int maxTurns = 0;
	
	/* Modes de jeu */
	final static int FACILE = 0;
	final static int NORMAL = 1;
	final static int DIFFICILE = 2;
	final static int HARD = 3;
	final static int CUSTOM = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mode = Integer.parseInt(JOptionPane.showInputDialog(null, "Choix du mode de jeu:"));
		System.out.println(mode);
		switch(mode) {
			case 0:
				min = 1;
				max = 20;
				maxTurns = -1;
					break;
			case 1:
				min = 1;
				max = 20;
				maxTurns = 5;
					break;
			case 2:
				min = 1;
				max = 20;
				maxTurns = 5;
					break;
			case 3: // HARD
				min = 1;
				max = 20;
				maxTurns = 5;
					break;
			case 4: // CUSTOM
				min = 1;
				max = Integer.parseInt(JOptionPane.showInputDialog(null, "Choix de la borne max: "));
					break;
			default: // ERREUR
				System.out.println("ERREUR MODE DE JEU");
				break;
		}

		game();
	}
	
	public static void game() {
		Boolean canPlay = true;
		magicNumber = getRandomNumber(min, max);
		turns = 0;
		
		/* Boucle */
		while(canPlay) {
			int playerNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez un nombre entre "+ min + " et " + max));
			Boolean win = guessNumber(playerNumber);
			if(win) {
				return;
			}else {
				turns ++;
				if (mode == FACILE) {
					// Rien
				}
			}
			
		}
	}
	
	public static Boolean guessNumber(int playerChoice) {
		if(playerChoice > magicNumber) {
			JOptionPane.showMessageDialog(null, "Trop Grand !");
			return false;
		}else if (playerChoice < magicNumber){
			JOptionPane.showMessageDialog(null, "Trop Petit !");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Tu as gagné !");
		return true;
	}
	
	public static int getRandomNumber(int min, int max) {
		return (int)(min + Math.random()*(max-min));
	}
}
