package com.hexaware.FTP112.model;


import java.util.Objects;
import java.util.Date;

/**
 * Orders class used to display Orders information.
 * @author hexware
 */
public class Orders {
  private int orderId;
  private int cusId;
  private int venId;
  private double totalOrderPrice;
  private OrderStatus orderStatus;
  private String orderComments;
  private Date orderDate;
  private int walId;
  /**
   * Default Constructor.
   */
  public Orders() {

  }
  /**
   * @param argOrderPrice to initialize orderPrice.
   * @param argCusId to initialize cusId.
   * @param argVenId to initialize venId.
   * used to get details through constructor.
   */
  public Orders(final int argCusId, final int argVenId, final double argOrderPrice) {
    this.totalOrderPrice = argOrderPrice;
    this.cusId = argCusId;
    this.venId = argVenId;

  }
/**
 *
 @param argsOrderId to initialize orderId.
 @param argsCusId to initialize cusId.
 @param argsvenId to initialize venId.
 @param argsOrderDate to initialize orderdate.
 @param argsOrderPrice to initialize orderPrice.
 @param argsOrderStatus to initialize orderStatus.
 * used to get details through constructor.
 */
  public Orders(int argCusId, int argVenId, double argTotalOrderPrice, final int argWalId) {
    this.cusId = argCusId;
    this.venId = argVenId;
    this.totalOrderPrice = argTotalOrderPrice;
    this.walId = argWalId;
  }

  public Orders(final int argOrderId, final int argCusId, final int argVenId, final Date argOrderDate,final double argTotalOrderPrice,final OrderStatus argOrderStatus,
  final String argOrderComments, final int argWalId) {
    this.orderId = argOrderId;
    this.cusId = argCusId;
    this.venId = argVenId;
    this.orderDate = argOrderDate;
    this.totalOrderPrice = argTotalOrderPrice;
    this.orderStatus = argOrderStatus;
    this.orderComments = argOrderComments;
    this.walId = argWalId;
  }
  /**
   * @param argCusId gets the customer Id.
   */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
  /**
     * @return this customer Id.
     */
  public final int getCusId() {
    return this.cusId;
  }
      /**
     * @param argVenId gets the vendor Id.
     */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
 /**
     * @return this vendor Id.
     */
  public final int getVenId() {
    return this.venId;
  }
      /**
     * @param argTotalOrderPrice gets the order Price.
     */
  public final void setOrderPrice(final double argTotalOrderPrice) {
    this.totalOrderPrice = argTotalOrderPrice;
  }
 /**
     * @return this order price.
     */
  public final double getTotalOrderPrice() {
    return this.totalOrderPrice;
  }
      /**
     * @param argOrderStatus gets the order comments.
     */
  public final void setOrderStatus(final OrderStatus argOrderStatus) {
    this.orderStatus = argOrderStatus;
  }
    /**
       * @return this order Comments.
       */
  public final OrderStatus getOrderStatus() {
    return this.orderStatus;
  }
    /**
       * @return this order Date.
       */
  public final Date getOrderDate() {
    return this.orderDate;
  }
    /**
       * @return this order Id.
       */
  public final int getOrderId() {
    return this.orderId;
  }
      /**
     * @param argOrderComments gets the order comments.
     */
  public final void setOrderComments(final String argOrderComments) {
    this.orderComments = argOrderComments;
  }
  /**
     * @return this order Comments.
     */
  public final String getOrderComments() {
    return this.orderComments;
  }
/**
 * @param argWalId gets the wallet id.
 */
  public final void setWalletId(final int argWalId) {
    this.walId = argWalId;
  }
/**
 * @return this order Comments.
 */
  public final int getWalletId() {
    return this.walId;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders orders = (Orders) obj;
    if (Objects.equals(cusId, orders.getCusId())
        && Objects.equals(venId, orders.getVenId())
        && Objects.equals(totalOrderPrice, orders.getTotalOrderPrice())
        && Objects.equals(orderStatus, orders.getOrderStatus())
        && Objects.equals(orderComments, orders.getOrderComments())
        && Objects.equals(walId, orders.getWalletId())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, venId, totalOrderPrice, orderStatus, orderComments, walId);
  }

}
