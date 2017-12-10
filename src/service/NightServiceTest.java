package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class NightServiceTest {

    @Test
    public void testIsServiceTime() {
        NightService nightService = new NightService();

        assertFalse(nightService.isServiceTime(5));
        assertFalse(nightService.isServiceTime(6));
        assertFalse(nightService.isServiceTime(22));
        assertFalse(nightService.isServiceTime(23));

        // 夜トク割引に加入している場合、23:00～5:00に通話開始したものがサービス対象
        nightService.joined();
        assertTrue(nightService.isServiceTime(5));
        assertFalse(nightService.isServiceTime(6));
        assertFalse(nightService.isServiceTime(22));
        assertTrue(nightService.isServiceTime(23));
    }

    @Test
    public void testCheckService() {
        NightService nightService = new NightService();

        nightService.checkService(new Record("2 E1"));
        assertFalse(nightService.isJoined());

        nightService.checkService(new Record("2 E2"));
        assertTrue(nightService.isJoined());
    }

    @Test
    public void testCalcUnitPrice() {
        NightService nightService = new NightService();

        nightService.checkService(new Record("2 E2"));

        // 23:00前に通話を開始しても通話単価は変わらない
        int unitPrice = nightService.calcUnitPrice(new Record("5 2004/06/05 22:59 010 090-1234-0002"), 20);
        assertEquals(20, unitPrice);

        // 23:00以降に通話を開始すると通話単価は10円引き
        unitPrice = nightService.calcUnitPrice(new Record("5 2004/06/05 23:00 010 090-1234-0002"), 20);
        assertEquals(10, unitPrice);
        unitPrice = nightService.calcUnitPrice(new Record("5 2004/06/05 00:00 010 090-1234-0002"), 20);
        assertEquals(10, unitPrice);
    }

    @Test
    public void testCalcBasicCharge() {
        NightService nightService = new NightService();

        // 夜トク割引に加入している場合、基本料金は500円増し
        nightService.checkService(new Record("2 E2"));
        int basicCharge = nightService.calcBasicCharge(1000);
        assertEquals(1500, basicCharge);
    }
}
