package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import java.util.List;

/**
 * @author 濃霧-遠方
 */
public class Dao {

    Session session;

    protected List getList(String hql, String[] parmeters){
        List list = null;
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery(hql);
            for(int i=0; i<parmeters.length; i++){
                query.setParameter(i,parmeters[i]);
            }
            list = query.list();
        } catch (HibernateException e) {
            list = null;
        } finally {
            session.close();
        }
        return list;
    }
}
