package onetoone_uni_new.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_uni_new.dto.AadharCard;
import onetoone_uni_new.dto.Person;

public class AadharCardDao {
	AadharCard aadharCard = new AadharCard();
	Person person = new Person();

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("prasad").createEntityManager();
	}

	public void saveAadharCard(AadharCard aadharCard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityTransaction.commit();

	}

	public void deleteAadharCard(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		AadharCard aadharCard = entityManager.find(AadharCard.class, id);
		if (aadharCard != null) {
			entityTransaction.begin();
			entityManager.remove(aadharCard);
			entityTransaction.commit();

		} else {
			System.out.println("Id not found ");

		}
	}
	public void updateAadharCard(int id , AadharCard aadharCard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		AadharCard dbAadharCard= entityManager.find(AadharCard.class, id);
		if (dbAadharCard!=null) {
			aadharCard.setId(id);
		
			entityTransaction.begin();
			entityManager.merge(aadharCard);
			entityTransaction.commit();
			
		} else {

		}
	}

}
