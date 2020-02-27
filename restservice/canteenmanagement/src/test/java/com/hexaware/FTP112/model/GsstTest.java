package com.hexaware.FTP112.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
  /**
     * to test gsst.
     */
public class GsstTest {

  private Gsst gsst;
    /**
     * to test wallet.
     */

  @Before
    public final void setUp() {
    gsst = new Gsst(10.00, 10.00, 20.00);
  }  /**
     * to test constuctor.
     */
  @Test
    public final void testGsstConstructor() {

    assertEquals(10.00, gsst.getStateGst(), 0);
    assertEquals(10.00, gsst.getCentralGst(), 0);
    assertEquals(20.00, gsst.getTotalGst(), 0);
  }
      /**
     * to test state_gst.
     */
  @Test
    public final void testSetStateGst() {
    assertEquals(10.00, gsst.getStateGst(), 0);
    gsst.setStateGst(56.00);
    assertNotEquals(10.00, gsst.getStateGst(), 0);
    assertEquals(56.00, gsst.getStateGst(), 0);
  }
      /**
     * to test central_gst.
     */
  @Test
    public final void testSetCentralGst() {
    assertEquals(10.00, gsst.getCentralGst(), 0);
    gsst.setCentralGst(56.00);
    assertNotEquals(10.00, gsst.getCentralGst(), 0);
    assertEquals(56.00, gsst.getCentralGst(), 0);
  }
      /**
     * to test total_gst.
     */
  @Test
    public final void testSetTotalGst() {
    assertEquals(20.00, gsst.getTotalGst(), 0);
    gsst.setTotalGst(56.00);
    assertNotEquals(20.00, gsst.getTotalGst(), 0);
    assertEquals(56.00, gsst.getTotalGst(), 0);
  }
     /**
     * to test constructor.
     */
  @Test
    public final void testGsstConstructortwo() {
    assertNotNull(new Gsst());
  }
    /**
     * to test equals.
     */
  @Test
    public final void testEquals() {
    Gsst x = new Gsst(10.00, 10.00, 20.00);
    Gsst y = new Gsst(10.00, 10.00, 20.00);
    assertTrue(x.equals(y) && y.equals(x));
  }
    /**
     * to test Not-equals.
     */
  @Test
    public final void testNotEquals() {
    Gsst x = new Gsst(10.00, 10.00, 20.00);
    Gsst y = new Gsst(12.00, 30.00, 30.00);
    assertFalse(x.equals(y) && y.equals(x));
  }
    /**
     * to test hashcode.
     */
  @Test
    public final void testHashCodeTrue() {
    Gsst x = new Gsst(10.00, 10.00, 20.00);
    Gsst y = new Gsst(10.00, 10.00, 20.00);
    assertTrue(x.hashCode() == y.hashCode());
  }
    /**
     * to test hashcode.
     */
  @Test
    public final void testHashCodeFalse() {
    Gsst x = new Gsst(10.00, 10.00, 20.00);
    Gsst y = new Gsst(12.00, 30.00, 30.00);
    assertFalse((x.hashCode()) == (y.hashCode()));
  }
    /**
     * to test method.
     */
  @Test
  public final void testObjectIsNull() {
    assertNotEquals(gsst, null);
  }
    /**
     * to test method.
     */
  @Test
  public final void testGetClass() {
    Vendor vendor = new Vendor();
    Gsst gsst1 = new Gsst();
    assertFalse(gsst1.equals(vendor));
  }
}
