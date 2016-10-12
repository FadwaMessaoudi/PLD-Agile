package modele;

public class Section {
	private String name;
	private int length;
	private int averageSpeed;
	private Intersection intersectionStart;
	private Intersection intersectionEnd;
	
	Section(String name, int length, int averageSpeed, Intersection intersectionStart, Intersection intersectionEnd) {
		this.name = name;
		this.length = length;
		this.averageSpeed = averageSpeed;
		this.intersectionStart = intersectionStart;
		this.intersectionEnd = intersectionEnd;
	}
	
	int getPassageDuration() {
		int passageDuration = length / averageSpeed;	
		return passageDuration;
	}
	
	String getName() {
		return name;
	}

}
