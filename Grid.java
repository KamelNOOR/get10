package tendroid.model;

public class Grid {
	
	private Integer[][] grille;
	
	public Grid(int nbCol, int nbLig) {
		grille = new Integer[nbLig][nbCol];
	}
	
	public int nbCol() {
		return grille[0].length;
	}
	
	public int nbLig() {
		return grille.length;
	}
	
	public PositionList allPosition() {
		PositionList listePos = new PositionList();
		for (int y = 0; y < nbLig(); y++) {
			for (int x = 0; x < nbCol(); x++) 
				listePos.add(new Position(y, x));
		}
		return listePos;
	}
	
	public boolean regularPosition(Position p) {
		return allPosition().contains(p);
	}
	
	public boolean isEmpty(Position p) {
		return (regularPosition(p) && grille[p.getLig()][p.getCol()] == null);
	}
	
	public Integer get(Position p) {
		return grille[p.getLig()][p.getCol()];
	}
	
	public void set(Position p, Integer v) {
		grille[p.getLig()][p.getCol()] = v;
	}
	
	public void unset(Position p) {
		grille[p.getLig()][p.getCol()] = null;
	}
	
	public PositionList adjPositions(Position p) {
		PositionList listePos = new PositionList();
		if (p.getCol() > 0)
			listePos.add(new Position(p.getLig(), p.getCol() - 1));
		if (p.getCol() < nbCol() - 1)
			listePos.add(new Position(p.getLig(), p.getCol() + 1));
		if (p.getLig() > 0)
			listePos.add(new Position(p.getLig() - 1, p.getCol()));
		if (p.getLig() < nbLig() - 1)
			listePos.add(new Position(p.getLig() + 1, p.getCol()));
		return listePos;
	}
}
