package hre.code;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
//import org.eclipse.swt.custom.CLabel;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//import javax.swing.JComboBox;

//import java.awt.EventQueue;

import javax.swing.JDialog;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
//import org.eclipse.swt.events.KeyAdapter;
//import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//import swing2swt.layout.BorderLayout;
//import javax.swing.JLabel;
import org.eclipse.swt.graphics.Rectangle;

public class LoginWindow extends JDialog {
	
	/**
	 * Set Version ID
	 */
	private static final long serialVersionUID = 002L;

	protected Shell shlHreLogin;
	public Text text;
	private Text text_1;

	private Button btnNewButton;
	public int lgnr;
	
	//private MainWindow MW;
	
	/**
	 * @wbp.nonvisual location=191,289
	 */
	
	
	/**
	 * Launch the application.
	 * @param args
	
	*/
	//public static void main(String[] args) {
	public LoginWindow() {
		//this.MW = mw;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlHreLogin.setSize(400,300);
	    Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shlHreLogin.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;		
	    shlHreLogin.setLocation(x, y);
		shlHreLogin.open();
		shlHreLogin.layout();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		while (!shlHreLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHreLogin = new Shell();
		shlHreLogin.setImage(SWTResourceManager.getImage(LoginWindow.class, "/hre/images/HRE-32.png")); //$NON-NLS-1$
		shlHreLogin.setText(Login_Messages.LoginWindow_1);
		
		Label lblNewLabel = new Label(shlHreLogin, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(LoginWindow.class, "/hre/images/HRE-32.png")); //$NON-NLS-1$
		lblNewLabel.setBounds(205, 26, 32, 50);
		
		Label lblNewLabel_1 = new Label(shlHreLogin, SWT.NONE);
		lblNewLabel_1.setBounds(101, 94, 55, 15);
		lblNewLabel_1.setText(Login_Messages.LoginWindow_3);
		
		text = new Text(shlHreLogin, SWT.BORDER);
		text.setBounds(191, 94, 76, 25);
		
		Label lblNewLabel_2 = new Label(shlHreLogin, SWT.NONE);
		lblNewLabel_2.setBounds(101, 125, 55, 15);
		lblNewLabel_2.setText(Login_Messages.LoginWindow_4);
		
		text_1 = new Text(shlHreLogin, SWT.BORDER);
		text_1.setBounds(191, 125, 76, 25);

		Label lblNewLabel_3 = new Label(shlHreLogin, SWT.NONE);
		lblNewLabel_3.setBounds(101, 160, 55, 15);
		lblNewLabel_3.setText(Login_Messages.LoginWindow_5);
		
		
		//Combo languageSelect;
		String[] languages = { " En/Us"," Norsk"}; //$NON-NLS-1$ //$NON-NLS-2$
		Combo languageSelect = new Combo(shlHreLogin, SWT.BORDER);
		languageSelect.setItems(languages);
		languageSelect.setBounds(191, 160, 76, 25);
		languageSelect.setText(Login_Messages.LoginWindow_8);
		languageSelect.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        if (languageSelect.getText().equals(languages[0])) {
		        	lgnr = 1;
		        } else if (languageSelect.getText().equals(languages[1])) {
		        	lgnr = 2;
		        } else {
		          languageSelect.setText(Login_Messages.LoginWindow_9);
		        }
		      }
		    });
		
		btnNewButton = new Button(shlHreLogin, SWT.NONE);
		btnNewButton.setBounds(192, 200, 75, 25);
		btnNewButton.setText(Login_Messages.LoginWindow_10);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				System.out.println("Test Login - LoginWindow"); //$NON-NLS-1$
				// Close Login Window before control to Main Window
				shlHreLogin.close();
				MainWindow window = new MainWindow();
				window.lg = lgnr;
				window.open();
			}
		});

	}

}
