package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.filter.CustomerFilter;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Svetlana Titova on 26.08.2016.
 */
@Repository("ORM_CustomerDAO")
@Component("ORM_CustomerDAO")
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Customer.class).list();
    }

    public Customer getCustomerById(int id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, id);
    }

    public List<Customer> getRange(int startRow, int rowCount) throws DBException {
        Session session = sessionFactory.getCurrentSession();

        Integer customersCount = ((Number) session.createCriteria(Customer.class)
                .setProjection(Projections.rowCount()).uniqueResult()).intValue();

        System.out.println("Customers total: " + customersCount
                + " Start row: " + startRow + " Row count: " + rowCount);

        Integer difference = customersCount - startRow - rowCount;
        System.out.println("Difference: "+difference);

        ProjectionList productProj = Projections.projectionList();

        for (String prop : sessionFactory.getClassMetadata(Customer.class)
                .getPropertyNames()) {
            System.out.println("Property: " + prop);
            productProj.add(Projections.alias(Projections.property(prop), prop));
        }

        if (difference < 1)
            if (customersCount - startRow <= 0) {return null;}

            else return session.createCriteria(Customer.class)
                    .setProjection(productProj
                            .add(Projections.property("customer_id"), "customer_id")
                                  )
                    .setFirstResult((difference < 0) ? 0 : difference)
                    .setMaxResults(customersCount - startRow)
                   // .addOrder(Order.asc("customer_id"))
                    .setResultTransformer(Transformers.aliasToBean(Customer.class)).list();

        return session.createCriteria(Customer.class)
                .setProjection(productProj
                        .add(Projections.property("customer_id"), "customer_id")
                )
                .setFirstResult((difference < 0) ? 0 : difference)
                .setMaxResults(rowCount)
               // .addOrder(Order.asc("customer_id"))
                .setResultTransformer(Transformers.aliasToBean(Customer.class)).list();
    }
private String appendCondition(String filter , String condition){
    if (filter==null ||"".equals(filter.trim())) {
        filter = " WHERE " + condition + " ";
    }
        else
        {filter=filter+" AND "+ condition+ " ";}
    return filter;
}

private String createFilter(CustomerFilter customerFilter, Map<String,Object> params)
{
   String fs1="";
    if (customerFilter != null && customerFilter.getCustomer_id()!=null) {
        fs1 = appendCondition(fs1, " customer_id= :customer_id");
        params.put("customer_id",customerFilter.getCustomer_id());
    }
   return fs1;
}

}
