package anaconda;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();

		//obj.setBounds(10, 10, 905, 700);
		
		obj.setBounds(0, 0, 918, 700);	//actual game
		//obj.setBounds(0, 0, 3840, 1200);	//my pc res
		obj.setBackground(Color.black);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		obj.add(gameplay);
		

	}

}
