package get10;

import java.util.ArrayList;

public class PositionList extends ArrayList<Position>{
	
	private ArrayList<Position> listPos;
	
	public PositionList() {		
		super();		
	}
	
	public boolean add(int col, int lig) {
		try {
			listPos.add(new Position(col, lig));
			return true;
		}catch(Exception e) {return false;}
	}
	
	public boolean contains(Position p) {
		for (int i = 0; i < listPos.size(); i++) {
			if ((listPos.get(i)).equals(p))
				return true;
		}
		return false;
	}
}
