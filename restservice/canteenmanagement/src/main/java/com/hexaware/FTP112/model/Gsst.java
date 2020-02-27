package com.hexaware.FTP112.model;

import java.util.Objects;

/**
 * Wallet class used to display Wallet information.
 * @author hexware
 */
public class Gsst {
    /*Attributes in wallet */
  private double stategst;
  private double centralgst;
  private double totalgst;
/**
   * Default Constructor.
   */
  public Gsst() {

  }
/**
 * @param argstategst to initialize  amount.
 * @param argcentralgst to initialize amount.
 * @param argtotalgst to initialize amount.
 * used to get details through constructor.
 */
  public Gsst(final double argstategst, final double argcentralgst, final double argtotalgst) {
    this.stategst = argstategst;
    this.centralgst = argcentralgst;
    this.totalgst = argtotalgst;
  }
     /**
     * @param argstategst gets the amount.
     */
  public final void setStateGst(final double argstategst) {
    this.stategst = argstategst;
  }
  /**
     * @return this amount.
     */
  public final double getStateGst() {
    return stategst;
  }
     /**
     * @param argcentralgst gets the amount.
     */
  public final void setCentralGst(final double argcentralgst) {
    this.centralgst = argcentralgst;
  }
  /**
     * @return this amount.
     */
  public final double getCentralGst() {
    return centralgst;
  }
     /**
     * @param argtotalgst gets the amount.
     */
  public final void setTotalGst(final double argtotalgst) {
    this.totalgst = argtotalgst;
  }
  /**
     * @return this wallet amount.
     */
  public final double getTotalGst() {
    return totalgst;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Gsst gsst = (Gsst) obj;
    if (Objects.equals(stategst, gsst.getStateGst()) && Objects.equals(centralgst, gsst.getCentralGst())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(stategst, centralgst);
  }
}
