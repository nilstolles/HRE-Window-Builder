package hre.code;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.graphics.Rectangle;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FillLayout;

public class MainWindow {

	protected Shell shlHreMain;
	public int lg;
	static MainWindow MW = null;
	static LoginWindow dialog;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Test Login -  MainWindow");
			dialog = new LoginWindow();  
			dialog.open();
			dialog.setLocationRelativeTo(null);
			//System.out.println("Test 1 - Initiate MainWindow");
			dialog.setVisible(true);
			dialog.dispose();
			dialog = null;

			System.out.println("Test 1 - Main in MainWindow");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setLanguage(int lg) {
		Main_Messages locale = new Main_Messages();
		locale.setLocale(lg);
	}
	
	
	/**
	 * Open the Main HRE window.
	 */
	
	public void open() {
		System.out.println("Test 2 - open in MainWindow");
		Display display = Display.getDefault();
		
		// Set Messages
		setLanguage(lg);
		
		createContents();
		// Ensure HRE Window is centred on primary monitor
		// so then the splash screen is centred within this window
		shlHreMain.setSize(800,500);
	    Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shlHreMain.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;		
		shlHreMain.setLocation(x, y);
		System.out.println("Test 7 - shell initiated - MainWindow");
		// Setup a composite using stacklayout in the MainWindow under the menu
		Composite Parent = new Composite(shlHreMain, SWT.BORDER);
		Parent.setLayout(new StackLayout());

		// Display the MainWindow
		System.out.println("Test 8 - diplay shell - MainWindow");
		shlHreMain.open();
		shlHreMain.layout();
		while (!shlHreMain.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		System.out.println("Test - shell Closed - MainWindow");
	}
	
	/**
	 * Setup heading and icon
	 */
	protected void createContents() {
		System.out.println("Test 3 - createContent - MainWindow");
		shlHreMain = new Shell();

		shlHreMain.setImage(SWTResourceManager.getImage(MainWindow.class, "/hre/images/HRE-32.png"));
		shlHreMain.setSize(611, 373);
		System.out.println("Test 4 - shellCreated - MainWindow");		
		shlHreMain.setText(Main_Messages.MainWindow_1);
		System.out.println("Test 5 - setupMenu - MainWindow");		
		shlHreMain.setLayout(new FillLayout(SWT.HORIZONTAL));
		Menu menu = new Menu(shlHreMain, SWT.BAR);
		shlHreMain.setMenuBar(menu);
			
		/**
		 * Setup all menus
		 */
		
		MenuItem mntmProject = new MenuItem(menu, SWT.CASCADE);
		mntmProject.setToolTipText(Main_Messages.MainWindow_2);
		mntmProject.setText(Main_Messages.MainWindow_3);
		
		Menu menu_1 = new Menu(mntmProject);
		mntmProject.setMenu(menu_1);
		
		MenuItem mntmOpenProject = new MenuItem(menu_1, SWT.NONE);
		mntmOpenProject.setText(Main_Messages.MainWindow_4);
		
		MenuItem mntmRecentlyUsed = new MenuItem(menu_1, SWT.NONE);
		mntmRecentlyUsed.setText(Main_Messages.MainWindow_5);
		
		MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem.setText(Main_Messages.MainWindow_6);
		
		MenuItem mntmBackup = new MenuItem(menu_1, SWT.NONE);
		mntmBackup.setText(Main_Messages.MainWindow_7);
				
		MenuItem mntmRestore = new MenuItem(menu_1, SWT.NONE);
		mntmRestore.setText(Main_Messages.MainWindow_8);
				
		MenuItem mntmClose = new MenuItem(menu_1, SWT.NONE);
		mntmClose.setText(Main_Messages.MainWindow_9);
				
		MenuItem mntmCopyAs = new MenuItem(menu_1, SWT.NONE);
		mntmCopyAs.setText(Main_Messages.MainWindow_10);
				
		MenuItem mntmRename = new MenuItem(menu_1, SWT.NONE);
		mntmRename.setText(Main_Messages.MainWindow_11);
				
		MenuItem mntmDelete = new MenuItem(menu_1, SWT.NONE);
		mntmDelete.setText(Main_Messages.MainWindow_12);
				
		MenuItem mntmExportToXml = new MenuItem(menu_1, SWT.NONE);
		mntmExportToXml.setText(Main_Messages.MainWindow_13);
				
		MenuItem mntmExportFromHre = new MenuItem(menu_1, SWT.NONE);
		mntmExportFromHre.setText(Main_Messages.MainWindow_14);
		
		MenuItem mntmCloseExit = new MenuItem(menu_1, SWT.NONE);
		mntmCloseExit.setText(Main_Messages.MainWindow_15);
		
		MenuItem mntmPerson = new MenuItem(menu, SWT.CASCADE);
		mntmPerson.setText(Main_Messages.MainWindow_16);
		
		Menu menu_4 = new Menu(mntmPerson);
		mntmPerson.setMenu(menu_4);
		
		MenuItem mntmSelectBy = new MenuItem(menu_4, SWT.NONE);
		mntmSelectBy.setText(Main_Messages.MainWindow_17);
		
		MenuItem mntmRecentlyUsed_1 = new MenuItem(menu_4, SWT.NONE);
		mntmRecentlyUsed_1.setText(Main_Messages.MainWindow_18);
		
		MenuItem mntmManagePersons = new MenuItem(menu_4, SWT.CASCADE);
		mntmManagePersons.setText(Main_Messages.MainWindow_19);
		
		Menu menu_2 = new Menu(mntmManagePersons);
		mntmManagePersons.setMenu(menu_2);
		
		MenuItem mntmAdd = new MenuItem(menu_2, SWT.NONE);
		mntmAdd.setText(Main_Messages.MainWindow_20);
		
		MenuItem mntmDelete_1 = new MenuItem(menu_2, SWT.NONE);
		mntmDelete_1.setText(Main_Messages.MainWindow_21);
		
		MenuItem mntmEdit = new MenuItem(menu_2, SWT.NONE);
		mntmEdit.setText(Main_Messages.MainWindow_22);
		
		MenuItem mntmManagePersonName = new MenuItem(menu_4, SWT.CASCADE);
		mntmManagePersonName.setText(Main_Messages.MainWindow_23);
		
		Menu menu_3 = new Menu(mntmManagePersonName);
		mntmManagePersonName.setMenu(menu_3);
		
		MenuItem menuItem_3 = new MenuItem(menu_3, SWT.NONE);
		menuItem_3.setText(Main_Messages.MainWindow_24);
		
		MenuItem menuItem_4 = new MenuItem(menu_3, SWT.NONE);
		menuItem_4.setText(Main_Messages.MainWindow_25);
		
		MenuItem menuItem_5 = new MenuItem(menu_3, SWT.NONE);
		menuItem_5.setText(Main_Messages.MainWindow_26);
		
		MenuItem mntmManagePersonFlags = new MenuItem(menu_4, SWT.CASCADE);
		mntmManagePersonFlags.setText(Main_Messages.MainWindow_27);
		
		Menu menu_29 = new Menu(mntmManagePersonFlags);
		mntmManagePersonFlags.setMenu(menu_29);
		
		MenuItem mntmAdd_1 = new MenuItem(menu_29, SWT.NONE);
		mntmAdd_1.setText(Main_Messages.MainWindow_28);
		
		MenuItem mntmDelete_2 = new MenuItem(menu_29, SWT.NONE);
		mntmDelete_2.setText(Main_Messages.MainWindow_29);
		
		MenuItem mntmEdit_1 = new MenuItem(menu_29, SWT.NONE);
		mntmEdit_1.setText(Main_Messages.MainWindow_30);
		
		MenuItem mntmManagePersonNotepads = new MenuItem(menu_4, SWT.CASCADE);
		mntmManagePersonNotepads.setText(Main_Messages.MainWindow_31);
		
		Menu menu_30 = new Menu(mntmManagePersonNotepads);
		mntmManagePersonNotepads.setMenu(menu_30);
		
		MenuItem mntmAdd_2 = new MenuItem(menu_30, SWT.NONE);
		mntmAdd_2.setText(Main_Messages.MainWindow_32);
		
		MenuItem mntmDelete_3 = new MenuItem(menu_30, SWT.NONE);
		mntmDelete_3.setText(Main_Messages.MainWindow_33);
		
		MenuItem mntmEdit_2 = new MenuItem(menu_30, SWT.NONE);
		mntmEdit_2.setText(Main_Messages.MainWindow_34);
		
		MenuItem mntmAssociates = new MenuItem(menu_4, SWT.CASCADE);
		mntmAssociates.setText(Main_Messages.MainWindow_35);
		
		Menu menu_5 = new Menu(mntmAssociates);
		mntmAssociates.setMenu(menu_5);
		
		MenuItem menuItem_8 = new MenuItem(menu_5, SWT.NONE);
		menuItem_8.setText(Main_Messages.MainWindow_36);
		
		MenuItem menuItem_9 = new MenuItem(menu_5, SWT.NONE);
		menuItem_9.setText(Main_Messages.MainWindow_37);
		
		MenuItem menuItem_10 = new MenuItem(menu_5, SWT.NONE);
		menuItem_10.setText(Main_Messages.MainWindow_38);
		
		MenuItem mntmAssociates_1 = new MenuItem(menu_4, SWT.CASCADE);
		mntmAssociates_1.setText(Main_Messages.MainWindow_39);
		
		Menu menu_28 = new Menu(mntmAssociates_1);
		mntmAssociates_1.setMenu(menu_28);
		
		MenuItem mntmManageEventAssociates = new MenuItem(menu_28, SWT.NONE);
		mntmManageEventAssociates.setText(Main_Messages.MainWindow_40);
		
		MenuItem mntmManageEventAssociate = new MenuItem(menu_28, SWT.NONE);
		mntmManageEventAssociate.setText(Main_Messages.MainWindow_41);
		
		MenuItem mntmManageEventAssociate_1 = new MenuItem(menu_28, SWT.NONE);
		mntmManageEventAssociate_1.setText(Main_Messages.MainWindow_42);
		
		MenuItem mntmManageTaskAssociates = new MenuItem(menu_28, SWT.NONE);
		mntmManageTaskAssociates.setText(Main_Messages.MainWindow_43);
		
		MenuItem mntmManageTaskAssociate = new MenuItem(menu_28, SWT.NONE);
		mntmManageTaskAssociate.setText(Main_Messages.MainWindow_44);
		
		MenuItem mntmManageTaskAssociate_1 = new MenuItem(menu_28, SWT.NONE);
		mntmManageTaskAssociate_1.setText(Main_Messages.MainWindow_45);
		
		MenuItem mntmOtherRt = new MenuItem(menu, SWT.CASCADE);
		mntmOtherRt.setText(Main_Messages.MainWindow_46);
		
		Menu menu_6 = new Menu(mntmOtherRt);
		mntmOtherRt.setMenu(menu_6);
		
		MenuItem mntmEvent = new MenuItem(menu, SWT.CASCADE);
		mntmEvent.setText(Main_Messages.MainWindow_47);
		
		Menu menu_7 = new Menu(mntmEvent);
		mntmEvent.setMenu(menu_7);
		
		MenuItem mntmEvents = new MenuItem(menu_7, SWT.CASCADE);
		mntmEvents.setText(Main_Messages.MainWindow_48);
		
		Menu menu_10 = new Menu(mntmEvents);
		mntmEvents.setMenu(menu_10);
		
		MenuItem mntmSelectBy_1 = new MenuItem(menu_10, SWT.NONE);
		mntmSelectBy_1.setText(Main_Messages.MainWindow_49);
		
		MenuItem mntmRecentlyUsed_3 = new MenuItem(menu_10, SWT.NONE);
		mntmRecentlyUsed_3.setText(Main_Messages.MainWindow_50);
		
		MenuItem mntmPickList = new MenuItem(menu_10, SWT.NONE);
		mntmPickList.setText(Main_Messages.MainWindow_51);
		
		MenuItem mntmManageEvents = new MenuItem(menu_10, SWT.NONE);
		mntmManageEvents.setText(Main_Messages.MainWindow_52);
		
		MenuItem mntmManageEventFlags = new MenuItem(menu_10, SWT.NONE);
		mntmManageEventFlags.setText(Main_Messages.MainWindow_53);
		
		MenuItem mntmManageEventNotepads = new MenuItem(menu_10, SWT.NONE);
		mntmManageEventNotepads.setText(Main_Messages.MainWindow_54);
		
		MenuItem mntmTasks = new MenuItem(menu_7, SWT.CASCADE);
		mntmTasks.setText(Main_Messages.MainWindow_55);
		
		Menu menu_16 = new Menu(mntmTasks);
		mntmTasks.setMenu(menu_16);
		
		MenuItem mntmSelectBy_2 = new MenuItem(menu_16, SWT.NONE);
		mntmSelectBy_2.setText(Main_Messages.MainWindow_56);
		
		MenuItem mntmRecentlyUsed_4 = new MenuItem(menu_16, SWT.NONE);
		mntmRecentlyUsed_4.setText(Main_Messages.MainWindow_57);
		
		MenuItem mntmPickList_1 = new MenuItem(menu_16, SWT.NONE);
		mntmPickList_1.setText(Main_Messages.MainWindow_58);
		
		MenuItem mntmManageTasks = new MenuItem(menu_16, SWT.NONE);
		mntmManageTasks.setText(Main_Messages.MainWindow_59);
		
		MenuItem mntmWherewhen = new MenuItem(menu, SWT.CASCADE);
		mntmWherewhen.setText(Main_Messages.MainWindow_60);
		
		Menu menu_17 = new Menu(mntmWherewhen);
		mntmWherewhen.setMenu(menu_17);
		
		MenuItem mntmLocations = new MenuItem(menu_17, SWT.CASCADE);
		mntmLocations.setText(Main_Messages.MainWindow_61);
		
		Menu menu_8 = new Menu(mntmLocations);
		mntmLocations.setMenu(menu_8);
		
		MenuItem mntmSelectBy_3 = new MenuItem(menu_8, SWT.NONE);
		mntmSelectBy_3.setText(Main_Messages.MainWindow_62);
		
		MenuItem mntmRecentlyUsed_5 = new MenuItem(menu_8, SWT.NONE);
		mntmRecentlyUsed_5.setText(Main_Messages.MainWindow_63);
		
		MenuItem mntmManageLocations = new MenuItem(menu_8, SWT.NONE);
		mntmManageLocations.setText(Main_Messages.MainWindow_64);
		
		MenuItem mntmManageLocationName = new MenuItem(menu_8, SWT.NONE);
		mntmManageLocationName.setText(Main_Messages.MainWindow_65);
		
		MenuItem mntmManageLocationFlags = new MenuItem(menu_8, SWT.NONE);
		mntmManageLocationFlags.setText(Main_Messages.MainWindow_66);
		
		MenuItem mntmManageLocationNotepads = new MenuItem(menu_8, SWT.NONE);
		mntmManageLocationNotepads.setText(Main_Messages.MainWindow_67);
		
		MenuItem mntmOccasions = new MenuItem(menu_17, SWT.CASCADE);
		mntmOccasions.setText(Main_Messages.MainWindow_68);
		
		Menu menu_18 = new Menu(mntmOccasions);
		mntmOccasions.setMenu(menu_18);
		
		MenuItem mntmSelectBy_5 = new MenuItem(menu_18, SWT.NONE);
		mntmSelectBy_5.setText(Main_Messages.MainWindow_69);
		
		MenuItem mntmRecentlyUsed_6 = new MenuItem(menu_18, SWT.NONE);
		mntmRecentlyUsed_6.setText(Main_Messages.MainWindow_70);
		
		MenuItem mntmIckList = new MenuItem(menu_18, SWT.NONE);
		mntmIckList.setText(Main_Messages.MainWindow_71);
		
		MenuItem mntmManageOccasions = new MenuItem(menu_18, SWT.NONE);
		mntmManageOccasions.setText(Main_Messages.MainWindow_72);
		
		MenuItem mntmHistoricalDates = new MenuItem(menu_17, SWT.CASCADE);
		mntmHistoricalDates.setText(Main_Messages.MainWindow_73);
		
		Menu menu_19 = new Menu(mntmHistoricalDates);
		mntmHistoricalDates.setMenu(menu_19);
		
		MenuItem mntmSelectBy_4 = new MenuItem(menu_19, SWT.NONE);
		mntmSelectBy_4.setText(Main_Messages.MainWindow_74);
		
		MenuItem mntmManageHistoricalDates = new MenuItem(menu_19, SWT.NONE);
		mntmManageHistoricalDates.setText(Main_Messages.MainWindow_75);
		
		MenuItem mntmDateConverter = new MenuItem(menu_19, SWT.NONE);
		mntmDateConverter.setText(Main_Messages.MainWindow_76);
		
		MenuItem mntmDateCalculator = new MenuItem(menu_19, SWT.NONE);
		mntmDateCalculator.setText(Main_Messages.MainWindow_77);
		
		MenuItem mntmSource = new MenuItem(menu, SWT.CASCADE);
		mntmSource.setText(Main_Messages.MainWindow_78);
		
		Menu menu_9 = new Menu(mntmSource);
		mntmSource.setMenu(menu_9);
		
		MenuItem mntmSources = new MenuItem(menu_9, SWT.CASCADE);
		mntmSources.setText(Main_Messages.MainWindow_79);
		
		Menu menu_22 = new Menu(mntmSources);
		mntmSources.setMenu(menu_22);
		
		MenuItem mntmSelectBy_6 = new MenuItem(menu_22, SWT.NONE);
		mntmSelectBy_6.setText(Main_Messages.MainWindow_80);
		
		MenuItem mntmRecentlyUsed_7 = new MenuItem(menu_22, SWT.NONE);
		mntmRecentlyUsed_7.setText(Main_Messages.MainWindow_81);
		
		MenuItem mntmPickList_2 = new MenuItem(menu_22, SWT.NONE);
		mntmPickList_2.setText(Main_Messages.MainWindow_82);
		
		MenuItem mntmManageSources = new MenuItem(menu_22, SWT.NONE);
		mntmManageSources.setText(Main_Messages.MainWindow_83);
		
		MenuItem mntmManageSourceName = new MenuItem(menu_22, SWT.NONE);
		mntmManageSourceName.setText(Main_Messages.MainWindow_84);
		
		MenuItem mntmManageSourceFlags = new MenuItem(menu_22, SWT.NONE);
		mntmManageSourceFlags.setText(Main_Messages.MainWindow_85);
		
		MenuItem mntmManageSourceNotepads = new MenuItem(menu_22, SWT.NONE);
		mntmManageSourceNotepads.setText(Main_Messages.MainWindow_86);
		
		MenuItem mntmManageSourcerepositoryLinks = new MenuItem(menu_22, SWT.NONE);
		mntmManageSourcerepositoryLinks.setText(Main_Messages.MainWindow_87);
		
		MenuItem mntmCitations_1 = new MenuItem(menu_9, SWT.CASCADE);
		mntmCitations_1.setText(Main_Messages.MainWindow_88);
		
		Menu menu_23 = new Menu(mntmCitations_1);
		mntmCitations_1.setMenu(menu_23);
		
		MenuItem mntmSelectBy_7 = new MenuItem(menu_23, SWT.NONE);
		mntmSelectBy_7.setText(Main_Messages.MainWindow_89);
		
		MenuItem mntmPickList_3 = new MenuItem(menu_23, SWT.NONE);
		mntmPickList_3.setText(Main_Messages.MainWindow_90);
		
		MenuItem mntmRecentlyUsed_8 = new MenuItem(menu_23, SWT.NONE);
		mntmRecentlyUsed_8.setText(Main_Messages.MainWindow_91);
		
		MenuItem mntmManageCitations = new MenuItem(menu_23, SWT.NONE);
		mntmManageCitations.setText(Main_Messages.MainWindow_92);
		
		MenuItem mntmManageCitationFlags = new MenuItem(menu_23, SWT.NONE);
		mntmManageCitationFlags.setText(Main_Messages.MainWindow_93);
		
		MenuItem mntmManageCitationNotepads = new MenuItem(menu_23, SWT.NONE);
		mntmManageCitationNotepads.setText(Main_Messages.MainWindow_94);
		
		MenuItem mntmRepositories_1 = new MenuItem(menu_9, SWT.CASCADE);
		mntmRepositories_1.setText(Main_Messages.MainWindow_95);
		
		Menu menu_24 = new Menu(mntmRepositories_1);
		mntmRepositories_1.setMenu(menu_24);
		
		MenuItem mntmSelectBy_8 = new MenuItem(menu_24, SWT.NONE);
		mntmSelectBy_8.setText(Main_Messages.MainWindow_96);
		
		MenuItem mntmPickList_4 = new MenuItem(menu_24, SWT.NONE);
		mntmPickList_4.setText(Main_Messages.MainWindow_97);
		
		MenuItem mntmRecentlyUsed_9 = new MenuItem(menu_24, SWT.NONE);
		mntmRecentlyUsed_9.setText(Main_Messages.MainWindow_98);
		
		MenuItem mntmManageRepositories = new MenuItem(menu_24, SWT.NONE);
		mntmManageRepositories.setText(Main_Messages.MainWindow_99);
		
		MenuItem mntmManageRepositoryFlags = new MenuItem(menu_24, SWT.NONE);
		mntmManageRepositoryFlags.setText(Main_Messages.MainWindow_100);
		
		MenuItem mntmManageRepositoryNotepads = new MenuItem(menu_24, SWT.NONE);
		mntmManageRepositoryNotepads.setText(Main_Messages.MainWindow_101);
		
		MenuItem mntmManageRepositorysourceLinks = new MenuItem(menu_24, SWT.NONE);
		mntmManageRepositorysourceLinks.setText(Main_Messages.MainWindow_102);
		
		MenuItem mntmManageRepositoryLink = new MenuItem(menu_24, SWT.NONE);
		mntmManageRepositoryLink.setText(Main_Messages.MainWindow_103);
		
		MenuItem mntmManageRepositoryLink_1 = new MenuItem(menu_24, SWT.NONE);
		mntmManageRepositoryLink_1.setText(Main_Messages.MainWindow_104);
		
		MenuItem mntmImages_1 = new MenuItem(menu_9, SWT.CASCADE);
		mntmImages_1.setText(Main_Messages.MainWindow_105);
		
		Menu menu_31 = new Menu(mntmImages_1);
		mntmImages_1.setMenu(menu_31);
		
		MenuItem mntmSelectBy_9 = new MenuItem(menu_31, SWT.NONE);
		mntmSelectBy_9.setText(Main_Messages.MainWindow_106);
		
		MenuItem mntmPickList_5 = new MenuItem(menu_31, SWT.NONE);
		mntmPickList_5.setText(Main_Messages.MainWindow_107);
		
		MenuItem mntmEcentlyUsed = new MenuItem(menu_31, SWT.NONE);
		mntmEcentlyUsed.setText(Main_Messages.MainWindow_108);
		
		MenuItem mntmManageImages = new MenuItem(menu_31, SWT.NONE);
		mntmManageImages.setText(Main_Messages.MainWindow_109);
		
		MenuItem mntmManageImageFlags = new MenuItem(menu_31, SWT.NONE);
		mntmManageImageFlags.setText(Main_Messages.MainWindow_110);
		
		MenuItem mntmManageImageNotepads = new MenuItem(menu_31, SWT.NONE);
		mntmManageImageNotepads.setText(Main_Messages.MainWindow_111);
		
		MenuItem mntmElectLinksTo = new MenuItem(menu_31, SWT.NONE);
		mntmElectLinksTo.setText(Main_Messages.MainWindow_112);
		
		MenuItem mntmManageLinksTo = new MenuItem(menu_31, SWT.NONE);
		mntmManageLinksTo.setText(Main_Messages.MainWindow_113);
		
		MenuItem mntmExternalFiles_1 = new MenuItem(menu_9, SWT.CASCADE);
		mntmExternalFiles_1.setText(Main_Messages.MainWindow_114);
		
		Menu menu_32 = new Menu(mntmExternalFiles_1);
		mntmExternalFiles_1.setMenu(menu_32);
		
		MenuItem mntmSelectBy_10 = new MenuItem(menu_32, SWT.NONE);
		mntmSelectBy_10.setText(Main_Messages.MainWindow_115);
		
		MenuItem mntmPickList_6 = new MenuItem(menu_32, SWT.NONE);
		mntmPickList_6.setText(Main_Messages.MainWindow_116);
		
		MenuItem mntmRecentlyUsed_10 = new MenuItem(menu_32, SWT.NONE);
		mntmRecentlyUsed_10.setText(Main_Messages.MainWindow_117);
		
		MenuItem mntmAnageFiles = new MenuItem(menu_32, SWT.NONE);
		mntmAnageFiles.setText(Main_Messages.MainWindow_118);
		
		MenuItem mntmManageFileFlags = new MenuItem(menu_32, SWT.NONE);
		mntmManageFileFlags.setText(Main_Messages.MainWindow_119);
		
		MenuItem mntmManageFileNotepads = new MenuItem(menu_32, SWT.NONE);
		mntmManageFileNotepads.setText(Main_Messages.MainWindow_120);
		
		MenuItem mntmSelectLinksTo = new MenuItem(menu_32, SWT.NONE);
		mntmSelectLinksTo.setText(Main_Messages.MainWindow_121);
		
		MenuItem mntmManageLinksTo_1 = new MenuItem(menu_32, SWT.NONE);
		mntmManageLinksTo_1.setText(Main_Messages.MainWindow_122);
		
		MenuItem mntmInternalText_1 = new MenuItem(menu_9, SWT.CASCADE);
		mntmInternalText_1.setText(Main_Messages.MainWindow_123);
		
		Menu menu_33 = new Menu(mntmInternalText_1);
		mntmInternalText_1.setMenu(menu_33);
		
		MenuItem mntmSelectBy_11 = new MenuItem(menu_33, SWT.NONE);
		mntmSelectBy_11.setText(Main_Messages.MainWindow_124);
		
		MenuItem mntmIckList_1 = new MenuItem(menu_33, SWT.NONE);
		mntmIckList_1.setText(Main_Messages.MainWindow_125);
		
		MenuItem mntmRecentlyUsed_11 = new MenuItem(menu_33, SWT.NONE);
		mntmRecentlyUsed_11.setText(Main_Messages.MainWindow_126);
		
		MenuItem mntmManageInternalText = new MenuItem(menu_33, SWT.NONE);
		mntmManageInternalText.setText(Main_Messages.MainWindow_127);
		
		MenuItem mntmManageInternalText_1 = new MenuItem(menu_33, SWT.NONE);
		mntmManageInternalText_1.setText(Main_Messages.MainWindow_128);
		
		MenuItem mntmManageInternalText_2 = new MenuItem(menu_33, SWT.NONE);
		mntmManageInternalText_2.setText(Main_Messages.MainWindow_129);
		
		MenuItem mntmSelectLinksTo_1 = new MenuItem(menu_33, SWT.NONE);
		mntmSelectLinksTo_1.setText(Main_Messages.MainWindow_130);
		
		MenuItem mntmManageLinksTo_2 = new MenuItem(menu_33, SWT.NONE);
		mntmManageLinksTo_2.setText(Main_Messages.MainWindow_131);
		
		MenuItem mntmReport = new MenuItem(menu, SWT.CASCADE);
		mntmReport.setText(Main_Messages.MainWindow_132);
		
		Menu menu_11 = new Menu(mntmReport);
		mntmReport.setMenu(menu_11);
		
		MenuItem mntmRecentlyUsed_2 = new MenuItem(menu_11, SWT.NONE);
		mntmRecentlyUsed_2.setText(Main_Messages.MainWindow_133);
		
		MenuItem mntmListOf = new MenuItem(menu_11, SWT.CASCADE);
		mntmListOf.setText(Main_Messages.MainWindow_134);
		
		Menu menu_25 = new Menu(mntmListOf);
		mntmListOf.setMenu(menu_25);
		
		MenuItem mntmPersons = new MenuItem(menu_25, SWT.NONE);
		mntmPersons.setText(Main_Messages.MainWindow_135);
		
		MenuItem mntmLocations_1 = new MenuItem(menu_25, SWT.NONE);
		mntmLocations_1.setText(Main_Messages.MainWindow_136);
		
		MenuItem mntmEvents_1 = new MenuItem(menu_25, SWT.NONE);
		mntmEvents_1.setText(Main_Messages.MainWindow_137);
		
		MenuItem mntmTasks_1 = new MenuItem(menu_25, SWT.NONE);
		mntmTasks_1.setText(Main_Messages.MainWindow_138);
		
		MenuItem mntmOurces = new MenuItem(menu_25, SWT.NONE);
		mntmOurces.setText(Main_Messages.MainWindow_139);
		
		MenuItem mntmRepositories = new MenuItem(menu_25, SWT.NONE);
		mntmRepositories.setText(Main_Messages.MainWindow_140);
		
		MenuItem mntmCitations = new MenuItem(menu_25, SWT.NONE);
		mntmCitations.setText(Main_Messages.MainWindow_141);
		
		MenuItem mntmImages = new MenuItem(menu_25, SWT.NONE);
		mntmImages.setText(Main_Messages.MainWindow_142);
		
		MenuItem mntmExternalFiles = new MenuItem(menu_25, SWT.NONE);
		mntmExternalFiles.setText(Main_Messages.MainWindow_143);
		
		MenuItem mntmInternalText = new MenuItem(menu_25, SWT.NONE);
		mntmInternalText.setText(Main_Messages.MainWindow_144);
		
		MenuItem mntmManage = new MenuItem(menu, SWT.CASCADE);
		mntmManage.setText(Main_Messages.MainWindow_145);
		
		Menu menu_12 = new Menu(mntmManage);
		mntmManage.setMenu(menu_12);
		
		MenuItem mntmProjSettings = new MenuItem(menu_12, SWT.CASCADE);
		mntmProjSettings.setText(Main_Messages.MainWindow_146);
		
		Menu menu_13 = new Menu(mntmProjSettings);
		mntmProjSettings.setMenu(menu_13);
		
		MenuItem mntmProjectSetting = new MenuItem(menu_13, SWT.NONE);
		mntmProjectSetting.setText(Main_Messages.MainWindow_147);
		
		MenuItem mntmComputer = new MenuItem(menu_13, SWT.NONE);
		mntmComputer.setText(Main_Messages.MainWindow_148);
		
		MenuItem mntmServer = new MenuItem(menu_13, SWT.NONE);
		mntmServer.setText(Main_Messages.MainWindow_149);
		
		MenuItem mntmScreen = new MenuItem(menu_13, SWT.NONE);
		mntmScreen.setText(Main_Messages.MainWindow_150);
		
		MenuItem mntmUser = new MenuItem(menu_13, SWT.NONE);
		mntmUser.setText(Main_Messages.MainWindow_151);
		
		MenuItem mntmAdmin = new MenuItem(menu_13, SWT.NONE);
		mntmAdmin.setText(Main_Messages.MainWindow_152);
		
		MenuItem mntmProject_1 = new MenuItem(menu_13, SWT.NONE);
		mntmProject_1.setText(Main_Messages.MainWindow_153);
		
		MenuItem mntmLocation_1 = new MenuItem(menu_13, SWT.NONE);
		mntmLocation_1.setText(Main_Messages.MainWindow_154);
		
		MenuItem mntmHistoricalDates_1 = new MenuItem(menu_13, SWT.NONE);
		mntmHistoricalDates_1.setText(Main_Messages.MainWindow_155);
		
		MenuItem mntmEvents_2 = new MenuItem(menu_13, SWT.NONE);
		mntmEvents_2.setText(Main_Messages.MainWindow_156);
		
		MenuItem mntmTasks_2 = new MenuItem(menu_13, SWT.NONE);
		mntmTasks_2.setText(Main_Messages.MainWindow_157);
		
		MenuItem mntmOccasions_1 = new MenuItem(menu_13, SWT.NONE);
		mntmOccasions_1.setText(Main_Messages.MainWindow_158);
		
		MenuItem mntmSources_1 = new MenuItem(menu_13, SWT.NONE);
		mntmSources_1.setText(Main_Messages.MainWindow_159);
		
		MenuItem mntmSourceNameStyles = new MenuItem(menu_13, SWT.NONE);
		mntmSourceNameStyles.setText(Main_Messages.MainWindow_160);
		
		MenuItem mntmRepositories_2 = new MenuItem(menu_13, SWT.NONE);
		mntmRepositories_2.setText(Main_Messages.MainWindow_161);
		
		MenuItem mntmRepositorySource = new MenuItem(menu_13, SWT.NONE);
		mntmRepositorySource.setText(Main_Messages.MainWindow_162);
		
		MenuItem mntmTools = new MenuItem(menu_12, SWT.CASCADE);
		mntmTools.setText(Main_Messages.MainWindow_163);
		
		Menu menu_14 = new Menu(mntmTools);
		mntmTools.setMenu(menu_14);
		
		MenuItem mntmApplicationLanguage = new MenuItem(menu_14, SWT.CASCADE);
		mntmApplicationLanguage.setText(Main_Messages.MainWindow_164);
		
		Menu menu_26 = new Menu(mntmApplicationLanguage);
		mntmApplicationLanguage.setMenu(menu_26);
		
		MenuItem mntmUserLanguage = new MenuItem(menu_14, SWT.CASCADE);
		mntmUserLanguage.setText(Main_Messages.MainWindow_165);
		
		Menu menu_27 = new Menu(mntmUserLanguage);
		mntmUserLanguage.setMenu(menu_27);
		
		MenuItem mntmEdit_3 = new MenuItem(menu_14, SWT.NONE);
		mntmEdit_3.setText(Main_Messages.MainWindow_166);
		
		MenuItem mntmUserLanguage_1 = new MenuItem(menu_12, SWT.CASCADE);
		mntmUserLanguage_1.setText(Main_Messages.MainWindow_167);
		
		Menu menu_20 = new Menu(mntmUserLanguage_1);
		mntmUserLanguage_1.setMenu(menu_20);
		
		MenuItem mntmSelect = new MenuItem(menu_20, SWT.NONE);
		mntmSelect.setText(Main_Messages.MainWindow_168);
		
		MenuItem mntmDelete_4 = new MenuItem(menu_20, SWT.NONE);
		mntmDelete_4.setText(Main_Messages.MainWindow_169);
		
		MenuItem mntmDit = new MenuItem(menu_20, SWT.NONE);
		mntmDit.setText(Main_Messages.MainWindow_170);
		
		MenuItem mntmViewpoints = new MenuItem(menu_12, SWT.CASCADE);
		mntmViewpoints.setText(Main_Messages.MainWindow_171);
		
		Menu menu_21 = new Menu(mntmViewpoints);
		mntmViewpoints.setMenu(menu_21);
		
		MenuItem mntmSelect_1 = new MenuItem(menu_21, SWT.NONE);
		mntmSelect_1.setText(Main_Messages.MainWindow_172);
		
		MenuItem mntmAdd_3 = new MenuItem(menu_21, SWT.NONE);
		mntmAdd_3.setText(Main_Messages.MainWindow_173);
		
		MenuItem mntmDelete_5 = new MenuItem(menu_21, SWT.NONE);
		mntmDelete_5.setText(Main_Messages.MainWindow_174);
		
		MenuItem mntmEdit_4 = new MenuItem(menu_21, SWT.NONE);
		mntmEdit_4.setText(Main_Messages.MainWindow_175);
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText(Main_Messages.MainWindow_176);
		
		Menu menu_15 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_15);
		
		MenuItem mntmSearchHelp = new MenuItem(menu_15, SWT.NONE);
		mntmSearchHelp.setText(Main_Messages.MainWindow_177);
		
		MenuItem mntmEditHelp = new MenuItem(menu_15, SWT.NONE);
		mntmEditHelp.setText(Main_Messages.MainWindow_178);
		
		MenuItem mntmWebsite = new MenuItem(menu_15, SWT.NONE);
		mntmWebsite.setText(Main_Messages.MainWindow_179);
		
		MenuItem mntmAbout = new MenuItem(menu_15, SWT.NONE);
		mntmAbout.setText(Main_Messages.MainWindow_180);
		
		// Project, Close & Exit
		mntmCloseExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			//
			//**  So far, this just closes program - will need to add code here to close project files etc	
			//    as per Specification xxx.
			//    Same code applies to use of 'X' button on MainWindow.
			System.out.println("Test Exit - Closed - MainWindow");
			dialog.dispose();
			dialog = null;
			System.exit(0);}
		});
		
				
		// For Help Menus //
		// Help, Website (go to)
		mntmWebsite.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			if(Desktop.isDesktopSupported())
				{
				  try {
					Desktop.getDesktop().browse(new URI(Main_Messages.MainWindow_181));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}    
			}
		});
		// Help, About
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			HelpAbout splashscreen=new HelpAbout();  
			splashscreen.setLocationRelativeTo(null);
			splashscreen.setVisible(true);}
		});		
		
		System.out.println("Test 6 - contentCreated - MainWindow");
		//new LoginWindow();
		/**
		 * Show the Help, About screen at program startup as a Splash screen
		 */
		//
		//  Bug - when splash closed, MainWindow doesn't get focus again 
		//
		/*
		HelpAbout splashscreen=new HelpAbout();  
		splashscreen.setLocationRelativeTo(null);
		splashscreen.setVisible(true);
		*/
		
	}
}
