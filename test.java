package tendroid.model;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i1 = 10;
		int i2 = 5;
		Position p = new Position(10,5);
		
		System.out.println((p).getCol() == i1);
		System.out.println((p).getLig() == i2);
		
		System.out.println(p.equals(p) == true);
		//System.out.println();
		
		if(p.getCol() == i1 && p.getLig() == i2)
			System.out.println(p.equals(new Position(i1,i2)) == true);
		if(p.getCol() != i1 || p.getLig() != i2)
			System.out.println(p.equals(new Position(i1,i2)) == false);
		
		PositionList ps = new PositionList();
		ps.add(p);
		System.out.println(ps.get(0).equals(p)==true);
		System.out.println(ps.contains(p)==true);
		ps.add(new Position(4,2));
		System.out.println(ps.get(1).equals(p)==false);
		System.out.println(ps.contains(new Position(5,2))==false);
		
		System.out.println((new Grid(i1,i2)).nbCol() == i1);
		System.out.println((new Grid(i1,i2)).nbLig() == i2);
		Grid g = new Grid(i1,i2);
		System.out.println(g.regularPosition(p) == false);
		Position p2 = new Position(2,1);
		g.set(p2, 4);
		System.out.println(g.regularPosition(p2) == true);
		System.out.println(g.get(p2) == 4);
		g.unset(p2);
		System.out.println(g.isEmpty(p2) == true);
		g.set(new Position(1,1), 1);
		g.set(new Position(2,2), 2);
		PositionList ladj = g.adjPositions(p2);
		PositionList allp = g.allPosition();
		System.out.println(ladj.contains(new Position(1,1)));
		System.out.println(ladj.contains(new Position(2,0)) == false);
		System.out.println(ladj.contains(new Position(3,1)) == false);
		System.out.println(ladj.contains(new Position(2,2)));
		System.out.println(ladj.contains(new Position(2,2)));
		System.out.println(allp.contains(p2) == g.regularPosition(p2));
		System.out.println(allp.get(6).getLig() <= allp.get(7).getLig());
		System.out.println((new TenGrid()).nbCol() == 5);
		System.out.println((new TenGrid()).nbLig() == 5);
		
		int[] tab = {1,2,1,1,1,
					 1,2,1,1,1,
					 1,2,2,1,1,
					 1,2,2,1,1,
					 1,1,3,3,3};
		
		TenGrid tGrid = new TenGrid(tab);		
		System.out.println((tGrid.nbCol() == 5));
		System.out.println((tGrid.nbLig() == 5));
		System.out.println((tGrid.get(new Position(11%5,11/5)) == tab[11]));
		System.out.println((tGrid.get(p2) == tab[p2.getLig()*5+p2.getCol()]));
		PositionList groupP = tGrid.getGroup(p2);
		int x = 0;
		while (x < groupP.size()) {
			if (g.get(groupP.get(x)) != g.get(p2))
				break ;
			x++;
		}
		System.out.println(x == groupP.size());
		
		System.out.print("\n");
		for (int y = 0; y < tGrid.nbLig(); y++) {
			for (int u = 0; u < tGrid.nbCol(); u++) 
				System.out.print(tGrid.get(new Position(u, y)));
			System.out.print("\n");
		}
		System.out.print("\n");
		tGrid.collapseGroup(new Position(3,4));
		for (int y = 0; y < tGrid.nbLig(); y++) {
			for (int u = 0; u < tGrid.nbCol(); u++) 
				System.out.print(tGrid.get(new Position(u, y)));
			System.out.print("\n");
		}
	}
}
