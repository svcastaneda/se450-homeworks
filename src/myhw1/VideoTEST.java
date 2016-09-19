package myhw1;
import static org.junit.Assert.*;
import org.junit.Test;

// TODO: complete the tests
public class VideoTEST {
	@Test
	public void testConstructorAndAttributes() {
		String title1 = "XX";
		String director1 = "XY";
		String title2 = " XX ";
		String director2 = " XY ";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		assertSame(title1, v1.title());
		assertEquals(year, v1.year());
		assertSame(director1, v1.director());

		VideoObj v2 = new VideoObj(title2, year, director2);
		assertEquals(title1, v2.title());
		assertEquals(director1, v2.director());
	}

	@Test
	public void testConstructorExceptionYear() {
		try {
			new VideoObj("X", 1800, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 5000, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 1801, "Y");
			new VideoObj("X", 4999, "Y");
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void testConstructorExceptionTitle() {
		try {
			new VideoObj(null, 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("", 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj(" ", 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
	}

	@Test
	public void testConstructorExceptionDirector() {
		try {
			new VideoObj("A", 2002, null);
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("A", 2002, "");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("A", 2002, " ");
			fail();
		} catch (IllegalArgumentException e) { }
	}

	@Test
	public void testHashCode() {
		assertEquals
		(-875826552,
				new VideoObj("None", 2009, "Zebra").hashCode());
		assertEquals
		(-1391078111,
				new VideoObj("Blah", 1954, "Cante").hashCode());
	}

	@Test
	public void testEquals() {
		String title1 = "Title 1";
		String director1 = "Director 1";
		String title2 = "Title 2";
		String director2 = " Director 2";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		VideoObj same1 = new VideoObj(title1, year, director1);
		VideoObj v2 = new VideoObj(title2, year, director2);
		VideoObj same2 = new VideoObj(title2, year, director2);
		
		assertEquals(0, v1.compareTo(v1));
		assertEquals(0, v2.compareTo(v2));
		assertEquals(0, v1.compareTo(same1));
		assertEquals(0, v2.compareTo(same2));
		assertEquals(-1, v1.compareTo(v2));
		assertEquals(1, v2.compareTo(v1));
	}

	@Test
	public void testCompareTo() {
		String title1 = "Title 1";
		String director1 = "Director 1";
		String title2 = "Title 2";
		String director2 = " Director 2";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		VideoObj v2 = new VideoObj(title2, year, director2);
		
		VideoObj obj = new VideoObj(title1, year, director1);
		Record rec = new Record(v1, 1, 1, 1);
		
		assertTrue(v1.equals(obj));
		assertFalse(v2.equals(obj));
		assertFalse(v1.equals(rec));
		assertFalse(v2.equals(rec));
	}

	@Test
	public void testToString() {
		String s = new VideoObj("A",2000,"B").toString();
		assertEquals( "A (2000) : B", s );
		s = new VideoObj(" A ",2000," B ").toString();
		assertEquals( "A (2000) : B", s );
	}
}
