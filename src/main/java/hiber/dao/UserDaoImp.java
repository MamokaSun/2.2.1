package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User getUserFromCar(String model, int series){
      String hqlQuery = "FROM Car car LEFT OUTER JOIN FETCH car.user WHERE car.model =:carModel AND car.series =:carSeries";
      Car car = sessionFactory.getCurrentSession().createQuery(hqlQuery, Car.class).setParameter("carModel", model).setParameter("carSeries", series).setMaxResults(1).uniqueResult();
      return car.getUser();
   }

}
