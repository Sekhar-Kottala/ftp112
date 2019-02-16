package com.hexaware.FTP112.model;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 Test class for customer.
 */
public class CustomerTest {
  private Customer customer;
  /**
  Default values for testing customer.
 */
  @Before
    public final void setUp() {
    customer = new Customer(12, "HARI PRIYA", "9876543210", "HARIPRIYA22");
  }
  /**
   Test for customer constructor.
   */
  @Test
    public final void testCustomerConstructor() {
    assertEquals(12, customer.getCusId());
    assertEquals("HARI PRIYA", customer.getCusName());
    assertEquals("9876543210", customer.getCusPhoneNo());
    assertEquals("HARIPRIYA22", customer.getCusUserName());
  }
  /**
  Test for setting customer Id.
  */
  @Test
    public final void testSetCusId() {
    assertEquals(12, customer.getCusId());
    customer.setCusId(22);
    assertNotEquals(12, customer.getCusId());
    assertEquals(22, customer.getCusId());
  }
  /**
  Test for setting customer name.
  */
  @Test
    public final void testSetCusName() {
    assertEquals("HARI PRIYA", customer.getCusName());
    customer.setCusName("PREETHI");
    assertNotEquals("HARI PRIYA", customer.getCusName());
    assertEquals("PREETHI", customer.getCusName());
  }
  /**
  Test for setting customer phone number.
  */
  @Test
    public final void testSetCusPhoneNo() {
    assertEquals("9876543210", customer.getCusPhoneNo());
    customer.setCusPhoneNo("9897870034");
    assertNotEquals("9876543210", customer.getCusPhoneNo());
    assertEquals("9897870034", customer.getCusPhoneNo());
  }
  /**
  Test for setting customer user name.
  */
  @Test
    public final void testCusUserName() {
    assertEquals("HARIPRIYA22", customer.getCusUserName());
    customer.setCusUserName("PREETHI33");
    assertNotEquals("HARIPRIYA22", customer.getCusUserName());
    assertEquals("PREETHI33", customer.getCusUserName());
  }
  /**
  Test for checking equals.
  */
  @Test
    public final void testEquals() {
    Customer a = new Customer(12, "HARI PRIYA", "9876543210", "HARIPRIYA22");
    Customer b = new Customer(12, "HARI PRIYA", "9876543210", "HARIPRIYA22");
    assertTrue(a.equals(b) && b.equals(a));
  }
  /**
  Test for checking Notequals.
  */

  @Test
    public final void testNotEquals() {
    Customer a = new Customer(15, "HARI PRIYA", "9876543210", "HARIPRIYA32");
    Customer b = new Customer(12, "HARI PRIYA", "9876543210", "HARIPRIYA22");
    assertFalse(a.equals(b) && b.equals(a));
  }
  /**
  Test for checking Hash code equals.
  */

  @Test
    public final void testHashCodeEquals() {
    Customer a = new Customer(12, "HARI PRIYA", "9876543210", "HARIPRIYA22");
    Customer b = new Customer(12, "HARI PRIYA", "9876543210", "HARIPRIYA22");
    assertTrue(a.hashCode() == b.hashCode());
  }
  /**
  Test for checking Hash code Not equals.
  */

  @Test
    public final void testHashCodeNotEquals() {
    Customer a = new Customer(15, "HARI PRIYA", "9876543210", "HARIPRIYA32");
    Customer b = new Customer(12, "HARI PRIYA", "9876543210", "HARIPRIYA22");
    assertFalse(a.hashCode() == b.hashCode());
  }
 /**
  Test for default constructor.
  */

  @Test
    public final void defaultconstructor() {
    customer = new Customer();
    assertNotNull(new Customer());
  }
  /**
  Testing getclass.
  */
  @Test
    public final void testGetClass() {
    Customer customer2 = new Customer();
    Menu menu = new Menu();
    assertFalse(customer2.equals(menu));
  }
  /**
  Test for object is null or not.
  */
  @Test
    public final void testObjectNull() {
    assertFalse(customer.equals(null));
  }
}
