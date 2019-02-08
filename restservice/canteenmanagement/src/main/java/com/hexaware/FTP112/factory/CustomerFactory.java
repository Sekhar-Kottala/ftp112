package com.hexaware.FTP112.factory;

import com.hexaware.FTP112.persistence.CustomerDAO;
import com.hexaware.FTP112.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP112.model.Customer;
import com.hexaware.FTP112.util.Validators;
/**
 * CustomerFactory class used to fetch menu data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Customer[] showCustomer() {
    List<Customer> customer = dao().show();
    return customer.toArray(new Customer[customer.size()]);
  }
  /**
   * Call the data base connection.
   * @return the customerId.
   * @param cusId to initialize customer Id.
   * @param password to initialize customer password.
   */
  public static int findByCustomerId(final int cusId, final String password) {
    int count = dao().fetchCustomerId(cusId,password);
    return count;
  }
  /**
   * Call the data base connection.
   * @param cusId to initialize customer Id.
   */
  public static void authenticateCustomer(final int cusId,  final String password) {
     Validators.validateCustomer(cusId, password);
  }


}

