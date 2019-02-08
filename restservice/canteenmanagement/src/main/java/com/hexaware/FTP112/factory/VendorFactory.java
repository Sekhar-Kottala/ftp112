
package com.hexaware.FTP112.factory;

import com.hexaware.FTP112.persistence.VendorDAO;
import com.hexaware.FTP112.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP112.model.Vendor;
import com.hexaware.FTP112.util.Validators;

/**
 * MenuFactory class used to fetch vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of vendor object.
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
  /**
   * Call the data base connection.
   * @return vendor balance.
   * @param venId to initialize vendor Id.
   */
  public static double getVendorBalance(final int venId) {
    double vendorBalance = dao().vendorBalance(venId);
    return vendorBalance;
  }

  /**
   * Call the data base connection.
   * @param venId to initialize vendor Id.
   * @param totalOrderPrice to initialize total Order Price.
   */
  public static void updateVendorWallet(final double totalOrderPrice, final int venId) {
    dao().vendorWallet(totalOrderPrice, venId);
  }

  /**
   * Call the data base connection.
   * @param vendorId to initialize total vendor Id.
   * @param price to initialize price.
   */
  public static void updateRefund(final double price, final int vendorId) {
    dao().refund(price, vendorId);
  }
  /**
   * Call the data base connection.
   * @return the vendorId.
   * @param venId to initialize vendor Id.
   */
  public static void authenticateVendor(final int vendorId, final String vendorPassword) {
    Validators. validateVendor(vendorId, vendorPassword);
  }

  public static int findVendor(final int vendorId, final String vendorPassword) {
    int authentication = dao().authenticateVendor(vendorId, vendorPassword);
    return authentication;
  }
}
