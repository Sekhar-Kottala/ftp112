package com.hexaware.FTP112.factory;

import com.hexaware.FTP112.persistence.OrdersDAO;
import com.hexaware.FTP112.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.model.OrderStatus;
import com.hexaware.FTP112.model.OrderItems;
import com.hexaware.FTP112.util.Validators;

/**
 * OrderFactory class used to fetch Orders data from database.
 * @author hexware
 */
public class OrdersFactory {
  /**
   *  Protected constructor.
   */
  protected OrdersFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }
    public static void showPendingOrdId(final int orderItemId) {
    Validators. validateOrderItemId(orderItemId);
    }
  public static int findByOrderItemId(final int orderItemId) {
    int authentication = dao().fetchOrderItemId(orderItemId);
    return authentication;
  }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param vendorId to initialize customer Id.
   */
  public static List<OrderItems> showPendingOrders(final int vendorId) {
    List<OrderItems> orders = dao().show(vendorId);
    return orders;
  }
  /**
   * Call the data base connection.
   * @return the list of customers.
   * @param customerId to initialize customer Id.
   */
  public static List<Orders> showCustomerHistory(final int customerId) {
    List<Orders> customerHistory = dao().customerHistory(customerId);
    return customerHistory;
  }
  /**
   * Call the data base connection.
   * @param order to initialize oder object.
   * @return the result.
   */
  public static int setPlaceOrder(final Orders order) {
    int result =  dao().placeOrder(order);
    return result;
  }
  /**
   * @param orderItem to initialize orderitem.
   */
  public static void updateOrderItems(final OrderItems orderItem) {
    dao().updateOrderItems(orderItem);
  }
  /**
   * @param orderItemId to initialize order item id.
   * @param status to initialize status.
   */
  public static void updateStatus(final int  orderItemId, final OrderStatus status) {
    dao().updateOrderStatus(orderItemId, status);
  }
  /**
   * @param vendorId to initialize vendor Id.
   * @return the vendorHistory.
   */
  public static List<Orders> showVendorHistory(final int vendorId) {
    List<Orders> vendorHistory = dao().vendorHistory(vendorId);
    return vendorHistory;
  }
  /**
   * @param vendorId to initialize vendor Id.
   * @param orderItemId to initialize order Item Id.
   * @return the price.
   */
  public static double getPrice(final int vendorId, final int orderItemId) {
    double price = dao().getPrice(vendorId, orderItemId);
    return price;
  }
  /**
   * @param vendorId to initialize vendor Id.
   * @param orderItemId to initialize order Item Id.
   * @return the customerId.
   */
  public static int getCustomerId(final int vendorId, final int orderItemId) {
    int customerId = dao().getCustomerId(vendorId, orderItemId);
    return customerId;
  }
  /**
   * @param orderItemId to initialize order Item Id.
   * @return the walletId.
   */
  public static int getWalletId(final int orderItemId) {
    int walletId = dao().getWalletId(orderItemId);
    return walletId;
  }
  /**
   * @param price to initialize price.
   * @param orderItemId to initialize order Item Id.
   */
  public static void updateTotalPrice(final double price, final int orderItemId) {
    dao().updateTotalPrice(price, orderItemId);
  }
}
