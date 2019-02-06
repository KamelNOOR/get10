package tendroid.model;

public class TenGame extends TenGrid{
	
	private PositionList currentGroup;
	
	public TenGame() { super(); }
	
	public TenGame(int[] ns) { super(ns); }
	
	public PositionList getSelectedGroup() {
		
		return (currentGroup);
	}
	
	public void transition(Position p) {
			if(currentGroup == null) 
				currentGroup = getGroup(p);
			else if(currentGroup.contains(p)) {
				collapseGroup(p);
				pack();
				currentGroup = null;
			}
			else {
				currentGroup = getGroup(p);
			}
				
	}
}
