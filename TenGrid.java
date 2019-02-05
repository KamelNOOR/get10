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

	public PositionList getGroup(Position p) {

		PositionList group = new PositionList();

		getSubGroup(p, group);
		return (group.size() > 1 ? group : new PositionList());
	}

	public void getSubGroup(Position p, PositionList group) {

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

		for (int i = 0; i < group.size(); i++) {
			if (!(p.equals(group.get(i))))
				unset(group.get(i));
			set(p,get(p)+1);
		}
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

		PositionList emptyList = emptyPosition();

		for(int i=0; i<ns.length;i++)
			set(emptyList.get(i), ns[i]);
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
