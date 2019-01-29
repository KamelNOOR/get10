package get10;

public class TenGrid extends Grid{
	
	public TenGrid() {
		super(5,5);
	}
	
	public TenGrid(int[] ns) {
		
		super(5,5);
		int k=0; 
		
		for (int y = 0; y < nbLig(); y++) {
			for (int x = 0; x < nbCol(); x++) {
				set(new Position(y,x),ns[k]);
				k++;
			}	
		}
	}
	
	public PositionList getGroup(Position p) {
		
		PositionList listPosAdj = adjPositions(p);
		PositionList group = new PositionList();
		
		group.add(p);
		for (int i = 0; i < listPosAdj.size(); i++) {
			Position v = listPosAdj.get(i);
			if (!(group.contains(v)) && (get(p)==get(v)))
				group.add(v);
		}
		int cpt = group.size();
		while (cpt>1){
			int j=1;
			PositionList ssGroupe = getSousGroup(group.get(j),group);
			for (int i = 0; i < ssGroupe.size(); i++) {
				if (!(group.contains(ssGroupe.get(i))) ) {
					group.add(ssGroupe.get(i));
					cpt++;
				}
			}
			j++;
			cpt--;
		}
		return group;			
	}
	

	public PositionList getSousGroup(Position p,PositionList group) {
		
		PositionList listPosAdj = adjPositions(p);
		for (int i = 0; i < listPosAdj.size(); i++) {
			Position v = listPosAdj.get(i);
			if (!(group.contains(v)) && (get(p)==get(v)))
				group.add(v);
		}
		return group;
	}
	
	public void collapseGroup(Position p) {
		
		PositionList group = getGroup(p);
		
		for (int i = 0; i < group.size(); i++) {
			if (!(p.equals(group.get(i))))
				unset(group.get(i));
		set(p,get(p)+1);
		}
	}
	
	public void pack() {
		
		for(int i=0; i<nbCol();i++) {
			for(int j=0; j<nbLig();j++) {
				if (get(new Position(i,j))==null) {
					for(int k=j; k<nbLig();k++) {
						if (get(new Position(i,k))!=null) {
							set(new Position(i,j),get(new Position(i,k)));
							unset(new Position(i,k));
						}
					}
				}
			}
		}
	}
	
	public void refill(int[] ns) {
		
		PositionList emptyList = emptyPosition();
		
		for(int i=0; i<ns.length;i++) {
			ns[i] = get(emptyList.get(i));
		}
	}
	
	public PositionList emptyPosition() {
		
		PositionList emptyList = new PositionList();
		PositionList allPosition = allPosition();
		for(int i=0; i<allPosition.size(); i++) {
			if (get(allPosition.get(i)) == null)
				emptyList.add(allPosition.get(i));
		}
		return emptyList;
	}
}
