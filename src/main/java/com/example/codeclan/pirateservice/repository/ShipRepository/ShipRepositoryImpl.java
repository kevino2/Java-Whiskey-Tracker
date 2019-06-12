package com.example.codeclan.pirateservice.repository.ShipRepository;

import com.example.codeclan.pirateservice.models.Ship;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ShipRepositoryImpl implements ShipRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Ship> findShipsThatHavePiratesNamed(String firstName){
        List<Ship> result = null;
        Session session = entityManager.unwrap(Session.class);

        try{
//            Attempt some code in there that might not work or is risky


            Criteria cr = session.createCriteria(Ship.class);
            cr.createAlias("pirates", "pirateAlias");
            cr.add(Restrictions.eq("pirateAlias.firstName", firstName));

//        has to match collection in ship model, firstName has to match pirate object

            result = cr.list();

        } catch (HibernateException ex) {
//            Something went wrong if this code is being executed,
//            What now?
            ex.printStackTrace();

        }  finally {
//            This will run no matter what
        }




        return result;
    }
}
