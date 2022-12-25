package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class UserDaoImpl implements UserDao{

    EntityManagerFactory entityManagerFactory;

    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsersList() {
        return entityManagerFactory.createEntityManager().createQuery("from User").getResultList();
    }
}
