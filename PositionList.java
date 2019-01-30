package tendroid.model;

import java.util.ArrayList;

public class PositionList extends ArrayList<Position>{
	
	
	public PositionList() {		
		super();		
	}
	
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
