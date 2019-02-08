package com.hexaware.FTP112.model;

import java.util.Objects;
/**
 * Customer class used to display Customer information.
 * @author hexaware
 */
public class Customer {
/*attributes in customer table*/
  private int cusId;
  private String cusName;
  private String cusPhoneNo;
  //private String cusEmail;
  private String cusUserName;
  //private String cusPassword;
  /**
   * Default Constructor.
   */
  public Customer() {

  }
/**
 * @param argscusId to initialize customer id.
 * @param argscusName to initialize customer name.
 * @param argscusPhoneNo to initialize customer phone number.
 * @param argscusUserName to initialize customer username.
 * used to get details through constructor.
 */
  public Customer(final int argscusId, final String argscusName,
      final String argscusPhoneNo,
      //final String argscusEmail,
      final String argscusUserName) {
    this.cusId = argscusId;
    this.cusName = argscusName;
    this.cusPhoneNo = argscusPhoneNo;
    //this.cusEmail = argscusEmail;
    this.cusUserName = argscusUserName;
    //this.cusPassword = argscusPassword;
  }
  /**
   * @param argscusId gets the cus id.
   */
  public final void setCusId(final int argscusId) {
    this.cusId = argscusId;
  }
  /**
   * @param argscusName gets the cus name.
   */
  public final void setCusName(final String argscusName) {
    this.cusName = argscusName;
  }
  /**
   * @param argscusPhoneNo gets the cus phone no.
   */
  public final void setCusPhoneNo(final String argscusPhoneNo) {
    this.cusPhoneNo = argscusPhoneNo;
  }
  /**
   * @param argscusEmail gets the cus email.
   */
  //public final void setCusEmail(final String argscusEmail) {
    //this.cusEmail = argscusEmail;
 // }
  /**
   * @param argscusUserName gets the cus user name.
   */
  public final void setCusUserName(final String argscusUserName) {
    this.cusUserName = argscusUserName;
  }
  /**
   * @param argscusPassword gets the cus password.
   */
 // public final void setCusPassword(final String argscusPassword) {
  //  this.cusPassword = argscusPassword;
 // }

    /**
     * @return this cus ID.
     */
  public final int getCusId() {
    return this.cusId;
  }
    /**
     * @return this cus name.
     */
  public final String getCusName() {
    return this.cusName;
  }
    /**
     * @return this phone no.
     */
  public final String getCusPhoneNo() {
    return this.cusPhoneNo;
  }
    /**
     * @return this cus email.
     */
  //public final String getCusEmail() {
    //return this.cusEmail;
  //}
     /**
     * @return this user name.
     */
  public final String getCusUserName() {
    return this.cusUserName;
  }
     /**
     * @return this cus password.
     */
  //public final String getCusPassword() {
    //return this.cusPassword;
  //}
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    if (Objects.equals(cusId, customer.getCusId())
        && Objects.equals(cusName, customer.getCusName())
        && Objects.equals(cusPhoneNo, customer.getCusPhoneNo())
        && Objects.equals(cusUserName, customer.getCusUserName())) {
        //&& Objects.equals(cusPassword, customer.getCusPassword())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, cusName, cusPhoneNo, cusUserName);
  }
}
