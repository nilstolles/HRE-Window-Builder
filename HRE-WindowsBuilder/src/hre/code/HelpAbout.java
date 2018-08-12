package hre.code;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Point;

public class HelpAbout extends JDialog {

	/**
	 * Set Version ID
	 */
	private static final long serialVersionUID = 002L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpAbout dialog = new HelpAbout();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public HelpAbout() {
		getContentPane().setLocation(new Point(30, 0));
		setResizable(false);
		setBackground(SystemColor.menu);
		setAlwaysOnTop(true);
		getContentPane().setBackground(SystemColor.menu);
		setTitle(Main_Messages.HelpAbout_0);
		setIconImage(Toolkit.getDefaultToolkit().getImage(HelpAbout.class.getResource("/hre/images/HRE-32.png"))); //$NON-NLS-1$
		setBounds(100, 100, 350, 360);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Calibri", Font.PLAIN, 12)); //$NON-NLS-1$
		textArea.setText(Main_Messages.HelpAbout_3);
		textArea.setBackground(SystemColor.menu);
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 3;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		getContentPane().add(textArea, gbc_textArea);
		
		JLabel lblNewLabel = new JLabel(Main_Messages.HelpAbout_4);
		lblNewLabel.setBackground(SystemColor.menu);
		lblNewLabel.setIcon(new ImageIcon(HelpAbout.class.getResource("/hre/images/HRE-144.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JTextArea txtrHistoryResearchEnvironment = new JTextArea();
		txtrHistoryResearchEnvironment.setEditable(false);
		txtrHistoryResearchEnvironment.setBackground(SystemColor.menu);
		txtrHistoryResearchEnvironment.setText(Main_Messages.HelpAbout_6);
		txtrHistoryResearchEnvironment.setLineWrap(true);
		txtrHistoryResearchEnvironment.setFont(new Font("Calibri", Font.BOLD, 14)); //$NON-NLS-1$
		GridBagConstraints gbc_txtrHistoryResearchEnvironment = new GridBagConstraints();
		gbc_txtrHistoryResearchEnvironment.insets = new Insets(0, 0, 5, 0);
		gbc_txtrHistoryResearchEnvironment.fill = GridBagConstraints.BOTH;
		gbc_txtrHistoryResearchEnvironment.gridx = 3;
		gbc_txtrHistoryResearchEnvironment.gridy = 0;
		getContentPane().add(txtrHistoryResearchEnvironment, gbc_txtrHistoryResearchEnvironment);
		
		JTextArea txtrHreCodeIs = new JTextArea();
		txtrHreCodeIs.setEditable(false);
		txtrHreCodeIs.setBackground(SystemColor.menu);
		txtrHreCodeIs.setText(Main_Messages.HelpAbout_8);
		txtrHreCodeIs.setFont(new Font("Calibri", Font.PLAIN, 12)); //$NON-NLS-1$
		GridBagConstraints gbc_txtrHreCodeIs = new GridBagConstraints();
		gbc_txtrHreCodeIs.gridwidth = 3;
		gbc_txtrHreCodeIs.gridheight = 2;
		gbc_txtrHreCodeIs.fill = GridBagConstraints.BOTH;
		gbc_txtrHreCodeIs.gridx = 1;
		gbc_txtrHreCodeIs.gridy = 1;
		getContentPane().add(txtrHreCodeIs, gbc_txtrHreCodeIs);

		
	}

}
