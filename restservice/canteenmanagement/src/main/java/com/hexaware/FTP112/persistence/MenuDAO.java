package com.hexaware.FTP112.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP112.model.Menu;
import org.skife.jdbi.v2.sqlobject.Bind;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("select m.men_id,m.men_item,j.jun_price,m.MEN_CALORIES,j.ven_id,j.jun_rating,"
            + "j.jun_reviews"
            + " from menu m , junc_menu_vendor j , vendor v"
            + " where m.men_id = j.men_id and j.ven_id = v.ven_id ORDER BY m.men_id;")
    @Mapper(MenuMapper.class)
    List<Menu> show();

    /**
     * @return the all the Menu record.
     * @param venId to initialize vendor Id.
     * @param menId to initialize menu Id.
     */
  @SqlQuery("select jun_price"
             + " from junc_menu_vendor"
             + " where men_id = :menId and ven_id = :venId;")
    double fetchOrderPrice(@Bind("menId")int menId, @Bind("venId")int venId);
    /**
     * @return the price.
     * @param venId to initialize vendor Id.
     * @param menId to initialize menu Id.
     */
  @SqlQuery("select count(*) from junc_menu_vendor where men_id = :menId and ven_id = :venId;")
    int fetchMenVenId(@Bind("menId")int menId, @Bind("venId")int venId);
        /**
     * @return the count.
     * @param menId to initialize menu Id.
     */
  @SqlQuery("select count(*) from junc_menu_vendor where men_id = :menId;")
    int fetchMenId(@Bind("menId")int menId);
}
