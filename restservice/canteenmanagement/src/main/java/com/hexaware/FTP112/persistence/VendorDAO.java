package com.hexaware.FTP112.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP112.model.Vendor;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * VendorDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select VEN_ID,VEN_NAME,VEN_PHN_NO,VEN_USERNAME,VEN_BALANCE from Vendor;")
    @Mapper(VendorMapper.class)
    List<Vendor> show();
    /**
     * @return the vendor Id.
     * @param venId to initialize vendor id.
     */
  @SqlQuery("select count(*) from vendor where ven_id = :vendorId and ven_password = :vendorPassword;")
    int authenticateVendor(@Bind("vendorId")int venId, @Bind("vendorPassword")String vendorPassword);

    @SqlQuery("Select VEN_BALANCE from vendor where ven_id = :venId;")
    double vendorBalance(@Bind("venId")int venId);


    @SqlUpdate("update vendor set VEN_BALANCE = :totalOrderPrice where ven_id = :venId;")
    void vendorWallet(@Bind("totalOrderPrice")double totalOrderPrice, @Bind("venId")int venId);

    @SqlUpdate("update vendor set VEN_BALANCE = ven_balance - :price where ven_id = :vendorId;")
    void refund(@Bind("price")double price, @Bind("vendorId")int vendorId);


}
