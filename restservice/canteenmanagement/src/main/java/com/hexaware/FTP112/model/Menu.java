package com.hexaware.FTP112.model;

import com.hexaware.FTP112.persistence.DbConnection;
import com.hexaware.FTP112.persistence.MenuDAO;

import java.util.Objects;
import java.util.List;

/**
 * Menu class used to display menu information.
 * @author hexaware
 */
public class Menu {
/**
 * foodId to store menuId.
 */
  private int menuId;
  private String menItem;
  private double menCalories;
  private int venId;
  private int ratings;
  private String reviews;
  private String venName;
  private String venPhnNo;
  private double menPrice;
  /**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argMenuId to initialize menu id.
 * @param argMenItem to initialize menu item.
 * @param argMenPrice to initialize menu price.
 * @param argMenCalories to initialize calories.
 * @param argVenId to initialize vendor id.
 * @param argRatings to initialize vendor rating.
* @param argReviews to initialize vendor reviews.
 * used to get details through constructor.
 */
  public Menu(final int argMenuId, final String argMenItem,
              final double argMenCalories,
              final int argVenId, final int argRatings, final String argReviews, final double argMenPrice) {
    this.menuId = argMenuId;
    this.menItem = argMenItem;
    this.menPrice = argMenPrice;
    this.menCalories = argMenCalories;
    this.venId = argVenId;
    this.ratings = argRatings;
    this.reviews = argReviews;

  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(menuId, menu.getMenId())
        && Objects.equals(menItem, menu.getMenItem())
        && Objects.equals(menPrice, menu.getMenPrice())
        && Objects.equals(menCalories, menu.getMenCalories())
        && Objects.equals(venId, menu.getVenId())
        && Objects.equals(ratings, menu.getRatings())
        && Objects.equals(reviews, menu.getReviews())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(menuId, menItem, menPrice, menCalories, venId, ratings, reviews);
  }
    /**
     * @return this menId.
     */
  public final int getMenId() {
    return this.menuId;
  }
  /**
     * @return this Men item.
     */
  public final String getMenItem() {
    return this.menItem;
  }
  /**
     * @return this Menu Price.
     */
  public final Double getMenPrice() {
    return this.menPrice;
  }
  /**
     * @return this calories .
     */
  public final double getMenCalories() {
    return this.menCalories;
  }
  /**
     * @return this ven id .
     */
  public final int getVenId() {
    return this.venId;
  }
  /**
     * @return this ratings .
     */

  public final int getRatings() {
    return this.ratings;
  }
  /**
     * @return this reviews .
     */
  public final String getReviews() {
    return this.reviews;
  }
  /**
     * @return this ven name .
     */
  public final String getVenName() {
    return this.venName;
  }
  /**
     * @return this ven phone number .
     */
  public final String getVenPhnNo() {
    return this.venPhnNo;
  }
    /**
     * @param argMenId gets the food id.
     */
  public final void setMenId(final int argMenId) {
    this.menuId = argMenId;
  }
    /**
     * @param argMenItem gets the Menu item.
     */
  public final void setMenItem(final String argMenItem) {
    this.menItem = argMenItem;
  }
    /**
     * @param argMenPrice gets the Menu Price.
     */
  public final void setMenPrice(final double argMenPrice) {
    this.menPrice = argMenPrice;
  }
    /**
     * @param argMenCalories gets the calories.
     */
  public final void setMenCalories(final int argMenCalories) {
    this.menCalories = argMenCalories;
  }
    /**
     * @param argVenName gets the calories.
     */
  public final void setVenName(final String argVenName) {
    this.venName = argVenName;
  }
    /**
     * @param argVenPhnNo gets the calories.
     */
  public final void setVenPhnNo(final String argVenPhnNo) {
    this.venPhnNo = argVenPhnNo;
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
}
