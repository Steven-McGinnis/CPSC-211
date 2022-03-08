import java.util.ArrayList;

public class TextViewController {

	//Prints the menu String Array that it Recieves to the viewer
	public void printMyMenu(ArrayList<String> printMenu){
		for (int i = 0; i < printMenu.size(); i ++) {
			System.out.println(printMenu.get(i));
		}
	}
	
	//Prints the Descriptions Passed to it.
	public void displayDescription(ArrayList<String> des) {
		for (int i = 0; i < des.size(); i ++) {
			System.out.println(des.get(i));
		}
	}
	

	/**
	 * Receives Menu String and Sends to formatMenu
	 * Then on return after formatting it adds it to the ArrayList
	 * and Sends the Menu to the View Controller
	 * @param menu
	 * @return menulist
	 */
 	public ArrayList<String> printMenu (String [] menu)
	{
		String [] formattedMenu = formatMenu (menu);
		ArrayList<String> menulist = new ArrayList<String>();
		for (int i = 0; i < formattedMenu.length; i++)
		{
		    if (formattedMenu[i] != null)
		    	menulist.add(("" + i + ") " + formattedMenu[i]));
		        //System.out.println ("" + i + ") " + formattedMenu[i]);
		}
		//System.out.println(menulist);
		return menulist;
	}
	
	/**
	 * Takes Menu Catches Nulls and out or Range errors
	 * Sends menu to Format String
	 * @param menu
	 * @return formattedMenu
	 * 
	 */
	public String [] formatMenu (String [] menu)
	{
		int maxLength = 0;
		
		for (String item : menu)
			if (item != null && item.length() > maxLength)
				maxLength = item.length();
				
		String [] formattedMenu = new String [menu.length];
		
		for (int i = 0; i < formattedMenu.length; i++)
		    if (menu[i] != null)
		        formattedMenu [i] = formatString (menu[i], maxLength-menu[i].length());
		
		return formattedMenu;
	}
	
	/**
	 * Adds Spaces to the Menu Items formatting the output then returns it back to FormatMenu
	 * @param item
	 * @param spacesToAdd
	 * @return
	 */
	public String formatString (String item, int spacesToAdd)
	{
		if (spacesToAdd == 0)
			return item;
		
		return formatString (" " + item, spacesToAdd - 1);
	}
	
}
