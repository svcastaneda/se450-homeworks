package myhw1;

// TODO: complete the methods
/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * <p><b>Class Type:</b> Immutable Data Class</p>
 * <p><b>Object Invariant:</b></p>
 *   Title is non-null, no leading or final spaces, not empty string.
 * <p><b>Object Invariant:</b></p>
 *   Year is greater than 1800, less than 5000.
 * <p><b>Object Invariant:</b></p>
 *   Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable<VideoObj> {
	/** <p><b>Invariant:</b> non-null, no leading or final spaces, not empty string </p>*/
	private final String title;
	/** <p><b>Invariant:</b> greater than 1800, less than 5000 </p>*/
	private final int    year;
	/** <p><b>Invariant:</b> non-null, no leading or final spaces, not empty string </p>*/
	private final String director;

	/**
	 * Initialize all object attributes.
	 * Title and director are "trimmed" to remove leading and final space.
	 * @throws IllegalArgumentException if any object invariant is violated.
	 */
	VideoObj(String title, int year, String director) {
		if (title == null || title.trim().length() == 0) {
			throw new IllegalArgumentException("Title must be longer than 1 character and not null");
		} else {
			this.title = title.trim();
		}
		
		if (year <= 1800 || year >= 5000) {
			throw new IllegalArgumentException("Year must be greater than 1800 and less than 5000");
		} else {
			this.year = year;
		}
		if (director == null || director.trim().length() == 0) {
			throw new IllegalArgumentException("Director must be longer than 1 character and not null");
		} else {
			this.director = director.trim();
		}
		 
	}

	/**
	 * Return the value of the attribute.
	 */
	public String director() {
		return director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String title() {
		return title;
	}

	/**
	 * Return the value of the attribute.
	 */
	public int year() {
		return year;
	}

	/**
	 * Compare the attributes of this object with those of thatObject.
	 * @param thatObject the Object to be compared.
	 * @return deep equality test between this and thatObject.
	 */
	@Override
	public boolean equals(Object thatObject) {
		if (thatObject == null) return false;
		if (this.getClass() != thatObject.getClass()) return false;
		if (this == thatObject) return true;
		
		VideoObj other = (VideoObj) thatObject;
		return	title() == other.title() &&
				director() == other.director() &&
				year() == other.year();
	}

	/**
	 * Return a hash code value for this object using the algorithm from Bloch:
	 * fields are added in the following order: title, year, director.
	 */
	public int hashCode() {
		int hash = 17;
		hash = hash * 37 + title().hashCode();
		hash = hash * 37 + year();
		hash = hash * 37 + director().hashCode();
		return hash;
	}

	/**
	 * Compares the attributes of this object with those of thatObject, in
	 * the following order: title, year, director.
	 * @param that the VideoObj to be compared.
	 * @return a negative integer, zero, or a positive integer as this
	 *  object is less than, equal to, or greater than that object.
	 */
	public int compareTo(VideoObj that) {
		return this.toString().compareTo(that.toString());
	}

	/**
	 * Return a string representation of the object in the following format:
	 * <code>"title (year) : director"</code>.
	 */
	public String toString() {
//		format: "Title (year) : Director";
		return title() + " (" + year() + ") : " + director();
	}
}
