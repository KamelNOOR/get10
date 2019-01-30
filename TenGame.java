package tendroid.model;

import java.util.Scanner;

public class TenGame extends TenGrid{
	
	public TenGame() { super(); }
	
	public TenGame(int[] ns) { super(ns); }
	
	public PositionList getSelectedGroup() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir la ligne :");
		int lig = sc.nextInt();
		System.out.println("Veuillez choisir la colonne :");
		int col = sc.nextInt();
		sc.close();
		
		PositionList group = getGroup(new Position(col,lig));
		
		if (group.size()<2)
			return null;
		return group;
	}
	
	public void transition(Position p) {
		
		PositionList group = getGroup(p);
		if (group.size()<2)
			group=null;
		
		System.out.println("Vous avez sélectionnez le groupe :" + group);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Tapez 1 pour confirmer, 2 pour changer et 3 pour annuler :");
		int choix = sc.nextInt();
		sc.close();
		
		if (choix == 3)
			group = null;
		if (choix == 2)
			group = getSelectedGroup();
		collapseGroup(p);
		pack();
		
	}
}
