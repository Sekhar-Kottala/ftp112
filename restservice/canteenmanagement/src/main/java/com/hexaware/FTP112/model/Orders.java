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
   * @param argCusId to initialize customer Id.
   * @param argVenId to initialize vendor Id.
   * @param argTotalOrderPrice to initialize Total Order Price.
   * @param argWalId to initialize Wallet Id.
   * used to get details through constructor.
   */
  public Orders(final int argCusId, final int argVenId, final double argTotalOrderPrice, final int argWalId) {
    this.cusId = argCusId;
    this.venId = argVenId;
    this.totalOrderPrice = argTotalOrderPrice;
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
  * @param argOrderDate gets the order date.
  */
  public final void setOrderDate(final Date argOrderDate) {
    this.orderDate = argOrderDate;
  }
/**
  * @return this order Date.
  */
  public final Date getOrderDate() {
    return new Date(this.orderDate.getTime());
  }
/**
  * @param argOrderId gets the order Id.
  */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
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
