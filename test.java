package get10;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i1 = 10;
		int i2 = 5;
		Position p = new Position(10,5);
		
		System.out.println((p).getCol() == i1);
		System.out.println((p).getLig() == i2);
		
		System.out.println(p.equals(p) == true);
		//System.out.println();
		
		if(p.getCol() == i1 && p.getLig() == i2)
			System.out.println(p.equals(new Position(i1,i2)) == true);
		if(p.getCol() != i1 || p.getLig() != i2)
			System.out.println(p.equals(new Position(i1,i2)) == false);
	}

}
