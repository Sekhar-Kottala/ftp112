package com.hexaware.FTP112.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP112.model.Customer;
import org.skife.jdbi.v2.sqlobject.Bind;
/**
 * CustomerDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
    /**
     * @return the all the Customer record.
     */
  @SqlQuery("Select CUS_ID,CUS_NAME,CUS_PHN_NO,CUS_USERNAME from Customer;")
    @Mapper(CustomerMapper.class)
    List<Customer> show();
    /**
     * @return the all the cus_id.
     * @param cusId to initializing customer Id.
     */
  @SqlQuery("select count(*) from customer where cus_id = :cusId and CUS_PASSWORD = :password;")
    int fetchCustomerId(@Bind("cusId")int cusId, @Bind("password")String password);
}


