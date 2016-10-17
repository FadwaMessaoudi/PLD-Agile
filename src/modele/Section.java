package modele;

public class Section {
	/**
	 * @brief The name of the section
	 */
	private String name;
	
	/**
	 * The length of the section
	 */
	private int length;
	
	/**
	 * @brief The average speed of the section
	 */
	private int averageSpeed;
	
	/**
	 * @brief The start intersection of the section
	 */
	private Intersection intersectionStart;
	
	/**
	 * @brief The end intersection of the section
	 */
	private Intersection intersectionEnd;
	
	/**
	 * @brief The constructor of a section
	 * @param name Name of the section
	 * @param length Length of the section
	 * @param averageSpeed Average speed of the section
	 * @param intersectionStart Start intersection of the section
	 * @param intersectionEnd End intersection of the section
	 */
	public Section(String name, int length, int averageSpeed, Intersection intersectionStart, Intersection intersectionEnd) {
		this.name = name;
		this.length = length;
		this.averageSpeed = averageSpeed;
		this.intersectionStart = intersectionStart;
		this.intersectionEnd = intersectionEnd;
	}
	
	/**
	 * @brief Get the duration of a passage in the section
	 * @return The duration of a passage in the section
	 */
	public int getPassageDuration() {
		int passageDuration = length / averageSpeed;	
		return passageDuration;
	}
	
	/**
	 * @brief Get the name of the section
	 * @return Name of the section
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @brief Get the start intersection of the section
	 * @return Start intersection of the section
	 */
	public Intersection getIntersectionStart() {
		return intersectionStart;
	}
	
	/**
	 * @brief Get the end intersection of the section
	 * @return End intersection of the section
	 */
	public Intersection getIntersectionEnd() {
		return intersectionEnd;
	}

}
