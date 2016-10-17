package modele;

public class Intersection {
	/**
	 * @brief The x coordinate of the intersection
	 */
	private int x;
	
	/**
	 * @brief The y coordinate of the intersection
	 */
	private int y;
	
	/**
	 * @brief The id designating the intersection
	 */
	private int id;
	
	/**
	 * @brief The constructor of a intersection
	 * @param x The x coordinate of the intersection
	 * @param y The y coordinate of the intersection
	 * @param id The id  designating the intersection
	 */
	public Intersection(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	/**
	 * @brief Get the x coordinate of the intersection
	 * @return The x coordinate of the intersection
	 */
	int getX() {
		return x;
	}
	
	/**
	 * @brief Get the y coordinate of the intersection
	 * @return The y coordinate of the intersection
	 */
	int getY() {
		return y;
	}
	
	/**
	 * @brief Get the id of the intersection
	 * @return The id of the intersection
	 */
	int getId() {
		return id;
	}

}
