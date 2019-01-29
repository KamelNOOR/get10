package get10;

public class Position {
	
	private int col;
	private int lig;
	
	public Position(int col, int lig) {
		this.col=col;
		this.lig=lig;
	}
	
	public int getCol() { return col;}
	
	public int getLig() { return lig;}
	
	public boolean equals(Position p) {
		return (p.getCol() == col && p.getLig() == lig);
	}
	
	
}
