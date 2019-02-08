package com.hexaware.FTP112.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP112.model.Wallet;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * WalletDAO class used to fetch data from data base.
 * @author hexware
 */
public interface WalletDAO {
    /**
     * @return the all the Wallet record.
     *@param cusId to initialize customer Id.
     */
  @SqlQuery("select wal_id,wal_amount,wal_source"
             + " from wallet where cus_id = :cusId order by wal_id; ")
    @Mapper(WalletMapper.class)
    List<Wallet> show(@Bind("cusId")int cusId);
    /**
     *@return the all the walletAmount.
     *@param walletId to initialize wallet amount.
     */
  @SqlQuery("select wal_amount from wallet where wal_id = :walletId;")
    double getWalletAmount(@Bind("walletId")double walletId);

    @SqlUpdate("update wallet set wal_amount = :totalOrderPrice where cus_id = :cusId and wal_id = :walletId;")
    void WalletAmount(@Bind("totalOrderPrice")double totalOrderPrice, @Bind("cusId")int cusId, @Bind("walletId")int walletId);

    @SqlUpdate("update wallet set wal_amount = wal_amount + :price where cus_id = :customerId and wal_id = :walletId;")
    void refundAmount(@Bind("price")double price, @Bind("customerId")int customerId, @Bind("walletId")int walletId);
    /**
     *@return the all the wallet id.
     *@param walletId to initialize wallet amount.
     */
  @SqlQuery("select count(*) from wallet where wal_id = :walletId;")
    int fetchWalletId(@Bind("walletId")int walletId);
}
