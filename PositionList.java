package tendroid.model;

import java.util.ArrayList;

public class PositionList extends ArrayList<Position>{
	
	public PositionList() {		
		super();		
	}
	
	/*
	** add() extends the eponym method from ArrayList, returning a boolean. Here, add() returns true when
	** it successfully added the given position in the PositionList, false otherwise.
	*/
	
	public boolean add(int col, int lig) {
		try {
			add(new Position(col, lig));
			return true;
		}catch(Exception e) {return false;}
	}
	
	public boolean contains(Position p) {
		for (int i = 0; i < size(); i++) {
			if ((get(i)).equals(p))
				return true;
		}
		return false;
	}
}