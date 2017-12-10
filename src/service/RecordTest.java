package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordTest {

    @Test
    public void testToString() {
        assertEquals("1 090-1234-0001", new Record("1 090-1234-0001").toString());
    }

    @Test
    public void testGetRecordCode() {
        assertEquals('1', new Record("1 090-1234-0001").getRecordCode());
    }

    @Test
    public void testGetOwnerTelNumber() {
        assertEquals("090-1234-0001", new Record("1 090-1234-0001").getOwnerTelNumber());
    }

    @Test
    public void testGetServiceCode() {
        assertEquals("E1", new Record("2 E1").getServiceCode());
        assertEquals("C1", new Record("2 C1 090-1234-0002").getServiceCode());
    }

    @Test
    public void testGetServiceOption() {
        assertNull(new Record("2 E1").getServiceOption());
        assertEquals("090-1234-0002", new Record("2 C1 090-1234-0002").getServiceOption());
    }

    @Test
    public void testGetStartHour() {
        assertEquals(3, new Record("5 2004/06/04 03:34 003 090-1234-0002").getStartHour());
    }

    @Test
    public void testGetCallMinutes() {
        assertEquals(3, new Record("5 2004/06/04 03:34 003 090-1234-0002").getCallMinutes());
    }

    @Test
    public void testGetTelNumber() {
        assertEquals("090-1234-0002", new Record("5 2004/06/04 03:34 003 090-1234-0002").getCallNumber());
    }

}
