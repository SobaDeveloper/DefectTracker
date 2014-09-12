package edu.uci.java2.view;

import javax.swing.JDialog;
import javax.swing.JFrame;

import edu.uci.java2.model.Defect;

public class DefectDetailsDialog extends JDialog{

	private static final long serialVersionUID = -6906647210068034962L;
	private Defect mDefect = new Defect();
	protected MainMenu mainMenu;
	
	public DefectDetailsDialog(MainMenu mainMenu, JFrame parent, Defect d){
		super(parent, "Defect Details", true);
		mDefect = d;
		this.mainMenu = mainMenu;
		DefectDetailsPanel ddp = new DefectDetailsPanel(mainMenu, mDefect);
		getContentPane().add(ddp);
		setLocationRelativeTo(parent);
		pack();
	}
}
