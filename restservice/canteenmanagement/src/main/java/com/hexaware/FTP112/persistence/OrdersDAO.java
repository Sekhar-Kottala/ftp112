package com.hexaware.FTP112.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.model.OrderStatus;
import com.hexaware.FTP112.model.OrderItems;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;

/**
 * OrdersDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrdersDAO {
    /**
     * @return the all the Orders record.
     * @param vendorId to initialize vendor id.
     */
  @SqlQuery("select ord_item_id, men_id,men_price,oi.ord_status, ord_quantity, oi.ord_id"
            + " from orders o , order_items oi "
            + " where o.ORD_ID = oi.ORD_ID and o.VEN_ID = :vendorId and oi.ORD_STATUS ='pending';")
    @Mapper(OrderItemsMapper.class)
    List<OrderItems> show(@Bind("vendorId")int vendorId);
/**
     *@param venId to initialize vendor Id.
     *@param cusId to initialize customer Id.
     *@return the showPrice.
     */
  @SqlQuery("select jun_price from junc_menu_vendor"
            + " where men_id = :menId and ven_id = :venId;")
    @Mapper(MenuDetailsMapper.class)
    double showPrice(@Bind("menId")int cusId, @Bind("venId")int venId);
/**
     *@param order to initialize order.
     *@return the showPrice.
     */

  @SqlUpdate(" insert into orders(cus_id,ven_id,total_ord_price,wal_id) values (:cusId, :venId, :totalOrderPrice, :walletId);")
    @GetGeneratedKeys
    int placeOrder(@BindBean Orders order);
/**
     *@param orderItem to initialize orderitem.
     */

  @SqlUpdate(" insert into order_items(men_id,men_price,ord_quantity,ord_id) values (:menId, :price, :quantity, :orderId);")
    void updateOrderItems(@BindBean OrderItems orderItem);
/**
     *@param customerId to initialize customerid.
     *@return the showPrice.
     */


  @SqlQuery("Select * FROM ORDERS WHERE CUS_ID= :customerId;")
      @Mapper(OrdersMapper.class)
    List<Orders> customerHistory(@Bind("customerId")int customerId);
/**
     *@param orderItemId to initialize orderItemId.
     *@param status to initialize status.
     */

  @SqlUpdate("update order_items oi inner join orders o set oi.ord_status = :status, "
            + " o.ord_status = :status where oi.ord_item_id = :orderItemId;")
    void updateOrderStatus(@Bind("orderItemId")int orderItemId, @Bind("status")OrderStatus status);
/**
     *@param vendorId to initialize vendorId.
     *@return the vendor details.
     */

  @SqlQuery("Select * FROM ORDERS WHERE VEN_ID= :vendorId;")
    @Mapper(OrdersMapper.class)
    List<Orders> vendorHistory(@Bind("vendorId")int vendorId);
/**
     *@param orderItemId to initialize orderItemId.
     *@param vendorId to initialize vendorId.
     *@return the orderItem details.
     */
  @SqlQuery("select  men_price from order_items oi,orders o"
              + " where o.ord_id = oi.ORD_ID  and oi.ord_item_id = :orderItemId and ven_id = :vendorId")
    double getPrice(@Bind("vendorId")int vendorId, @Bind("orderItemId")int orderItemId);
/**
     *@param vendorId to initialize vendorId.
     *@param orderItemId to initialize orderItemId.
     *@return the orderItem details.
     */
  @SqlQuery("select  cus_id from order_items oi,orders o"
      + " where o.ord_id = oi.ORD_ID  and oi.ord_item_id = :orderItemId and ven_id = :vendorId")
    int getCustomerId(@Bind("vendorId")int vendorId, @Bind("orderItemId")int orderItemId);
/**
     *@param orderItemId to initialize orderItemId.
     *@return the orderItem details.
     */
  @SqlQuery("select wal_id from orders o, order_items oi"
             + " where o.ord_id = oi.ord_id and oi.ord_item_id = :orderItemId;")
    int getWalletId(@Bind("orderItemId")int orderItemId);
/**
     *@param price to initialize price.
     *@param orderItemId to initialize orderItemId.
     */

  @SqlUpdate("update orders o inner join order_items oi on o.ORD_ID = oi.ORD_ID"
              + " set o.total_ord_price = o.total_ord_price - :price where oi.ORD_ITEM_ID = :orderItemId;")
    void updateTotalPrice(@Bind("price")double price, @Bind("orderItemId")int orderItemId);
/**
     *@param orderItemId to initialize orderItemId.
     *@return the orderItem details.
     */
  @SqlQuery("select count(*) from order_items where ord_Item_id = :orderItemId;")
    int fetchOrderItemId(@Bind("orderItemId")int orderItemId);
}



