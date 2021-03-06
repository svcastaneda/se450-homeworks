package myhw1;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

// TODO: complete the tests
public class InventoryTEST {
	InventorySet s = new InventorySet();
	final VideoObj v1 = new VideoObj( "A", 2000, "B" );
	final VideoObj v1copy = new VideoObj( "A", 2000, "B" );
	final VideoObj v2 = new VideoObj( "B", 2000, "B" );

	@Test
	public void testAddNumOwned() {
		assertEquals( 0, s.size() );
		s.addNumOwned(v1, 1);     assertEquals( v1, s.get(v1).video );
		assertEquals( 1, s.get(v1).numOwned );
		s.addNumOwned(v1, 2);     assertEquals( 3, s.get(v1).numOwned );
		s.addNumOwned(v1, -1);    assertEquals( 2, s.get(v1).numOwned );
		s.addNumOwned(v2, 1);     assertEquals( 2, s.get(v1).numOwned );
		s.addNumOwned(v1copy, 1); assertEquals( 3, s.get(v1).numOwned );
		assertEquals( 2, s.size() );
		s.addNumOwned(v1, -3);
		assertEquals( 1, s.size() );
		try { s.addNumOwned(null, 1);   fail(); } catch ( IllegalArgumentException e ) {}
	}

	@Test
	public void testSize() {
		assertEquals( 0, s.size() );
		s.addNumOwned(v1,  1); assertEquals( 1, s.size() );
		s.addNumOwned(v1,  2); assertEquals( 1, s.size() );
		s.addNumOwned(v2,  1); assertEquals( 2, s.size() );
		s.addNumOwned(v2, -1); assertEquals( 1, s.size() );
		s.addNumOwned(v1, -3); assertEquals( 0, s.size() );
		try { s.addNumOwned(v1, -3); fail(); } catch ( IllegalArgumentException e ) {}
		assertEquals( 0, s.size() );
	}
	
	@Test
	public void testCheckOutCheckIn() {
		s.addNumOwned(v1, 1);
		s.checkOut(v1);
		assertEquals(1, s.get(v1).numOut);
		assertEquals(1, s.get(v1).numRentals);
		try { s.checkOut(v1); fail(); } catch ( IllegalArgumentException e ) {}
		try { s.checkOut(v2); fail(); } catch ( IllegalArgumentException e ) {}
		s.checkIn(v1);
		assertEquals(0, s.get(v1).numOut);
		try { s.checkIn(v2); fail(); } catch ( IllegalArgumentException e ) {}
		assertEquals(1, s.get(v1).numRentals);
	}

	@Test
	public void testClear() {
		s.addNumOwned(v1, 1);
		s.checkOut(v1);
		try { s.clear(); fail(); } catch ( IllegalArgumentException e ) {}
		s.checkIn(v1);
		s.clear();
		assertEquals(0, s.size());
	}

	@Test
	public void testGet() {
		// Get should return a COPY of the records, not the records themselves.
		s.addNumOwned(v1, 1);
		assertTrue(s.get(v1) != s.get(v1));
	}

	@Test
	public void testToCollection() {
		// Be sure to test that changing records in the returned
		// collection does not change the original records in the
		// inventory.  ToCollection should return a COPY of the records,
		// not the records themselves.
		Collection<Record> collection = s.toCollection();
		collection.add(s.get(v1));
		collection.add(s.get(v2));
		assertNotEquals(collection, s.toCollection());
		Record r = new Record( v1copy, 20, 10, 300 );
		collection.add(r);
		assertNotEquals(collection, s.toCollection());
	}
	
}
