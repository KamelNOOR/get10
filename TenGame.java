package tendroid.model;

public class TenGame extends TenGrid{
	
	private PositionList selectedGroup;
	
	public TenGame() { super(); }
	
	public TenGame(int[] ns) { super(ns); }
	
	public PositionList getSelectedGroup() {
		
		return (selectedGroup);
	}
	
	public void transition(Position p) {
			if(selectedGroup != null && selectedGroup.contains(p)) {
				collapseGroup(p);
				pack();
				selectedGroup = null;
			}
			else {
				selectedGroup = getGroup(p);
			}
				
	}
}
