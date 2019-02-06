package tendroid.model;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] tab = {2,4,3,1,1,
					 1,3,2,1,1,
					 3,3,1,1,1,
					 3,2,2,3,1,
					 1,3,1,2,3};
		
		int[] fillit = {1,2,3,4,5,6,7};
		
		TenGrid tGrid = new TenGrid(tab);
		
		System.out.print("\n");
		for (int y = 0; y < tGrid.nbLig(); y++) {
			for (int u = 0; u < tGrid.nbCol(); u++) 
				System.out.print(tGrid.get(new Position(u, y)));
			System.out.print("\n");
		}
		System.out.print("\n");
		tGrid.collapseGroup(new Position(4,0));
		for (int y = 0; y < tGrid.nbLig(); y++) {
			for (int u = 0; u < tGrid.nbCol(); u++) 
				System.out.print(tGrid.get(new Position(u, y)));
			System.out.print("\n");
		}
		System.out.print("\n");
		tGrid.pack();
		for (int y = 0; y < tGrid.nbLig(); y++) {
			for (int u = 0; u < tGrid.nbCol(); u++) 
				System.out.print(tGrid.get(new Position(u, y)));
			System.out.print("\n");
		}
		System.out.print("\n");
		tGrid.refill(fillit);
		for (int y = 0; y < tGrid.nbLig(); y++) {
			for (int u = 0; u < tGrid.nbCol(); u++) 
				System.out.print(tGrid.get(new Position(u, y)));
			System.out.print("\n");
		}
	}
}
