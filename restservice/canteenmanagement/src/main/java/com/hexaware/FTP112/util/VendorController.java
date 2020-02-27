package com.hexaware.FTP112.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP112.model.Vendor;
import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.model.OrderItems;
import com.hexaware.FTP112.model.Gsst;
import javax.ws.rs.PathParam;
import com.hexaware.FTP112.factory.VendorFactory;
import com.hexaware.FTP112.factory.OrdersFactory;
import com.hexaware.FTP112.factory.WalletFactory;
import com.hexaware.FTP112.model.OrderStatus;
import java.util.List;
import javax.ws.rs.core.Response;
import com.hexaware.FTP112.factory.Validators;
/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/vendors")
public class VendorController {
  /**
   * Returns vendor details.
   * @param venId to initialize vendor Id.
   * @return the vendor details
   */
  @GET
  @Path("/{venId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Vendor> vendor(@PathParam("venId") final int venId) {
    Validators.validateVendorId(venId);
    return VendorFactory.showVendor(venId);
  }

  /**
   * Returns vendor details.
   * @return the vendor details
   * @param id to initialize vendor Id.
   */
  @GET
  @Path("/{id}/orders")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response listVendor(@PathParam("id") final int id) {
    Validators.validateVendorId(id);
    final List<Orders> vendorHistory = OrdersFactory.showVendorHistory(id);
    return Response.status(Response.Status.OK).entity(vendorHistory).build();
  }
  /**
   * Returns vendor details.
   * @return the vendor details
   * @param id to initialize vendor Id.
   */
  @GET
  @Path("/{id}/pending")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response listPEndingOrders(@PathParam("id") final int id) {
    Validators.validateVendorId(id);
    List<OrderItems> pendingList = OrdersFactory.showPendingOrders(id);
    return Response.status(Response.Status.OK).entity(pendingList).build();
  }

  /**
   * Returns vendor details.
   * @return the vendor details
   * @param month to initialize vendor Id.
   * @param vendorId to initialize vendor Id.
   */
  @GET
  @Path("/{month}/{vendorId}/gst")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response gstcalculate(@PathParam("month") final int month, @PathParam("vendorId") final int vendorId) {
    String date3 = "";
    String date4 = "";
    try {
      switch (month) {
        case 1:
          date3 = "2019-01-01";
          date4 = "2019-01-31";
          break;
        case 2:
          date3 = "2019-02-01";
          date4 = "2019-02-28";
          break;
        case 3:
          date3 = "2019-03-01";
          date4 = "2019-03-31";
          break;
        case 4:
          date3 = "2019-04-01";
          date4 = "2019-04-30";
          break;
        case 5:
          date3 = "2019-05-01";
          date4 = "2019-05-31";
          break;
        case 6:
          date3 = "2019-06-01";
          date4 = "2019-06-30";
          break;
        case 7:
          date3 = "2019-07-01";
          date4 = "2019-07-31";
          break;
        case 8:
          date3 = "2019-08-01";
          date4 = "2019-08-31";
          break;
        case 9:
          date3 = "2019-09-01";
          date4 = "2019-09-30";
          break;
        case 10:
          date3 = "2019-10-01";
          date4 = "2019-10-31";
          break;
        case 11:
          date3 = "2019-11-01";
          date4 = "2019-11-30";
          break;
        case 12:
          date3 = "2019-12-01";
          date4 = "2019-12-31";
          break;
        default:
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (month <= 12) {
      double amount = OrdersFactory.showBetween(vendorId, date3, date4);
      double gst = (amount * 2.5) / 100;
      double amount1 = gst * 2;
      Gsst gsst = new Gsst(gst, gst, amount1);
      //double left = amount - amount1;
      return Response.status(Response.Status.OK).entity(gsst).build();
    } else {
      return Response.status(Response.Status.OK).entity("you entered a wrong value of month").build();
    }
  }

  /**
     * Returns vendor details.
   * @param orderItemId to initialize order Id.
   * @param orders to initialize order.
   * @param vendorId to initialize vendorId.
   * @return the response.
   */
  @PUT
  @Path("/{vendorId}/orders/{orderItemId}/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response updateOrderStatus(@PathParam("orderItemId") final int orderItemId,
                                          @PathParam("vendorId") final int vendorId, final Orders orders) {
    //Validators.validateVenOrdId(vendorId, orderItemId);
    if (orders.getOrderStatus() == OrderStatus.ACCEPTED) {
      OrdersFactory.updateStatus(orderItemId, orders.getOrderStatus());
      OrdersFactory.updateComments(orders.getOrderId(), orders.getOrderComments());

    } else if (orders.getOrderStatus() == OrderStatus.DENIED) {
      OrdersFactory.updateStatus(orderItemId, orders.getOrderStatus());
      double price = OrdersFactory.getPrice(vendorId, orderItemId);
      VendorFactory.updateRefund(price, vendorId);
      int customerId = OrdersFactory.getCustomerId(vendorId, orderItemId);
      int walletId = OrdersFactory.getWalletId(orderItemId);
      WalletFactory.refundAmount(price, customerId, walletId);
      OrdersFactory.updateTotalPrice(price, orderItemId);
      OrdersFactory.updateComments(orders.getOrderId(), orders.getOrderComments());

    }
    return Response.status(Response.Status.NO_CONTENT).build();
  }
  /**
   * @return response.
   * @param vendor to get values.
   */
  @POST
  @Path("/Auth")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response authorize(final Vendor vendor) {
    Validators.validateVendor(vendor.getVenId(), vendor.getVenPassword());
    return Response.status(Response.Status.OK).build();
  }
}
