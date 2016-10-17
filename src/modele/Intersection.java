package modele;

public class Intersection {
	private int x;
	private int y;
	private int id;
	
	Intersection(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
	
	int getId() {
		return id;
	}

}
