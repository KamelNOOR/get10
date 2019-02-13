package tendroid.model;

public class TenGrid extends Grid{
	
	public TenGrid() {
		super(5,5);
	}
	
	public TenGrid(int[] ns) {
		
		super(5,5);
		int k=0; 
		
		for (int y = 0; y < nbLig(); y++) {
			for (int x = 0; x < nbCol(); x++) {
				set(new Position(x,y),ns[k]);
				k++;
			}	
		}
	}
	
	/*
	** getGroup() returns a PositionList that contains every position where its value equals the one in the given position
	** p, and is either adjacent to p or recursively adjacent to p through other positions that are also contained in the
	** list (which values are equal to p as well). If there are no adjacent position to p with equal values, getGroup()
	** returns an empty PositionList instead.
	*/
	
	public PositionList getGroup(Position p) {
		
		PositionList group = new PositionList();
		
		getSubGroup(p, group);
		return (group.size() > 1 ? group : new PositionList());
	}
	
	/*
	** getSubGroup() is a sub-method used by getGroup(). It is called on a specific position and takes a second parameter
	** being the current list of positions in the group. If adjacent positions with values equal to the given position
	** are found and not yet in the list, they are added to it. After adding new positions to the list, getSubGroup() is
	** called on all the newly added positions. Thus, it will recursively add to the positionList every position that is
	** part of the group. 
	*/
	
	private void getSubGroup(Position p, PositionList group) {
		
		PositionList tmp;
		PositionList eqadj;
		
		tmp = adjPositions(p);
		eqadj = new PositionList();
		for (int i = 0; i < tmp.size(); i++) {
			if (get(tmp.get(i)) == get(p) && !(group.contains(p)))
				eqadj.add(tmp.get(i));
		}
		group.add(p);
		for (int j = 0; j < eqadj.size(); j++) {
			if (!(group.contains(eqadj.get(j))))
				getSubGroup(eqadj.get(j), group);
		}
	}

	public void collapseGroup(Position p) {
		
		PositionList group = getGroup(p);
		
		if (group.size() == 0)
			return ;
		for (int i = 0; i < group.size(); i++) {
			if (!(p.equals(group.get(i))))
				unset(group.get(i));
		}
		set(p,get(p)+1);
	}
	
	public void pack() {
		
		for(int i=0; i<nbCol();i++) {
			for(int j=0; j<nbLig();j++) {
				if (get(new Position(i,j)) == null) {
					for(int k=j; k > 0;k--) {
						set(new Position(i, k), get(new Position(i, k - 1)));
						unset(new Position(i, k - 1));
					}
				}
			}
		}
	}
	
	public void refill(int[] ns) {
		
		PositionList emptyList = emptyPositions();
		
		for(int i=0; i<ns.length;i++)
			set(emptyList.get(i), ns[i]);
	}
	
	public PositionList emptyPositions() {
		
		PositionList emptyList = new PositionList();
		PositionList allPositions = allPositions();
		
		for(int i=0; i<allPositions.size(); i++) {
			if (get(allPositions.get(i)) == null)
				emptyList.add(allPositions.get(i));
		}
		return emptyList;
	}
}
