package com.hexaware.FTP112.factory;

/**
 * Validators used to validate.
 * @author hexware
 */

public final class Validators {
/**
 * Default constructor.
 */
  protected Validators() {
  }
/**
 * @param cusId used to get the user cus Id.
 * @param password used to get the user password.
 */
  public static void validateCustomer(final int cusId, final String password) {
    int customer = CustomerFactory.findByCustomerId(cusId, password);
    if (customer == 0) {
      throw new IllegalArgumentException("Invalid customer Id or password");
    }
  }
/**
 * @param vendorId used to get the user vendor Id.
 * @param vendorPassword used to get the user vendor Password.
 */
  public static void validateVendor(final int vendorId, final String vendorPassword) {
    int authentication = VendorFactory.findVendor(vendorId, vendorPassword);
    if (authentication == 0) {
      throw new IllegalArgumentException("Invalid vendor credentials");
    }
  }
/**
 * @param walletId used to get the user wallet Id.
 */
  public static void validateWalletId(final int walletId) {
    int wallet = WalletFactory.findByWalletId(walletId);
    if (wallet == 0) {
      throw new IllegalArgumentException("Invalid wallet Id");
    }
  }
/**
 * @param menId used to get the user men Id.
 * @param venId used to get the user ven Id.
 */
  public static void validateMenVenId(final int menId, final int venId) {
    int combination = MenuFactory.findByMenVenId(menId, venId);
    if (combination == 0) {
      throw new IllegalArgumentException("Invalid MenuId or VendorId");
    }
  }
/**
 * @param menId used to get the user men Id.
 */
  public static void validateMenId(final int menId) {
    int menuid = MenuFactory.findByMenId(menId);
    if (menuid == 0) {
      throw new IllegalArgumentException("Invalid MenuId");
    }
  }
/**
 * @param ordItemId used to get the user ordItem Id.
 */
  public static void validateOrderItemId(final int ordItemId) {
    int order = OrdersFactory.findByOrderItemId(ordItemId);
    if (order == 0) {
      throw new IllegalArgumentException("Invalid orderitem Id");
    }
  }
}
