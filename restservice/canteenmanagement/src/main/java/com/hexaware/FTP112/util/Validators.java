package com.hexaware.FTP112.util;

import com.hexaware.FTP112.factory.CustomerFactory;
import com.hexaware.FTP112.factory.VendorFactory;
import com.hexaware.FTP112.factory.WalletFactory;
import com.hexaware.FTP112.factory.MenuFactory;
import com.hexaware.FTP112.factory.OrdersFactory;

public class Validators{

    public static void validateCustomer(final int cusId, final String password){
        int customer = CustomerFactory.findByCustomerId(cusId,password);
        if(customer == 0){
            throw new IllegalArgumentException("Invalid customer Id or password");
        }
    }

    public static void validateVendor(int vendorId, String vendorPassword){
        int authentication = VendorFactory.findVendor(vendorId, vendorPassword);
        if(authentication == 0){
            throw new IllegalArgumentException("Invalid vendor credentials");
        }
    }

            public static void validateWalletId(int walletId){
        int wallet = WalletFactory.findByWalletId(walletId);
        if(wallet == 0){
            throw new IllegalArgumentException("Invalid wallet Id");
        }
    }

    public static void validateMenVenId(final int menId, final int venId){
        int price = MenuFactory.findByMenVenId(menId, venId);
        if(price == 0){
            throw new IllegalArgumentException("Invalid MenuId or VendorId");
        }
    }

        public static void validateMenId(final int menId){
        int menuid = MenuFactory.findByMenId(menId);
        if(menuid == 0){
            throw new IllegalArgumentException("Invalid MenuId");
        }
    }
            public static void validateOrderItemId(int ordItemId){
        int order = OrdersFactory.findByOrderItemId(ordItemId);
        if(order == 0){
            throw new IllegalArgumentException("Invalid orderitem Id");
        }
}
}