package edu.uci.java2.view;

import javax.swing.JDialog;
import javax.swing.JFrame;

import edu.uci.java2.model.Defect;

public class DefectDetailsDialog extends JDialog{

	private static final long serialVersionUID = -6906647210068034962L;
	private Defect mDefect = new Defect();
	
	public DefectDetailsDialog(JFrame parent, Defect d){
		super(parent, "Defect Details", true);
		mDefect = d;
		DefectDetailsPanel ddp = new DefectDetailsPanel(mDefect);
		getContentPane().add(ddp);
		setLocationRelativeTo(parent);
		pack();
	}
}
