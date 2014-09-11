package edu.uci.java2.view;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class AddDefectDialog extends JDialog{

	private static final long serialVersionUID = 1530586885310492162L;

	public AddDefectDialog (JFrame parent){
		super(parent, "Defect Details", true);
		AddDefectPanel adp = new AddDefectPanel();
		getContentPane().add(adp);
		setLocationRelativeTo(null);
		pack();
	}
}
