package edu.uci.java2.view;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class AddDefectDialog extends JDialog{

	private static final long serialVersionUID = 1530586885310492162L;
	MainMenu mainMenu;

	public AddDefectDialog (MainMenu mainMenu, JFrame parent){
		super(parent, "Defect Details", true);
		this.mainMenu = mainMenu;
		AddDefectPanel adp = new AddDefectPanel(mainMenu);
		getContentPane().add(adp);
		pack();
		setLocationRelativeTo(parent);
	}
}
