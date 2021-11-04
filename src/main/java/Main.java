import entity.City;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
//            City city = new City();
//            city.setId(3248782);
//            city.setName("DINH");
//            city.setCountryCode("AFG");
//            city.setDistrict("Cau Giay");
//            city.setPopulation(100000);
//            entityManager.persist(city);

//            TypedQuery<City> tmp = entityManager.createNamedQuery("City", City.class);
//            for(City city : tmp.getResultList()){
//                System.out.println(city.toString());
//            }

            Query tmp = entityManager.createNativeQuery("SELECT * FROM country inner join city c WHERE country.Code = 'ARG' and c.CountryCode = country.Code");
            System.out.println(tmp.getSingleResult());
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
