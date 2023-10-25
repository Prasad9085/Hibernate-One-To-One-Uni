package onetoone_uni_new.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_uni_new.dto.AadharCard;
import onetoone_uni_new.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("prasad").createEntityManager();
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		AadharCard aadharCard = person.getAadharCard();
		entityTransaction.begin();
	//	entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void findPerson(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("Person with given id " + id + "is not found !  ");
		}
	}

	public void findAllPerson() {
		EntityManager entityManager = getEntityManager();
		// JPQL Query
//		Query query = entityManager.createQuery("SELECT p FROM Person p");
//		List<Person> list = query.getResultList();
//		System.out.println(list);

		System.out.println(entityManager.createQuery("SELECT p  FROM p").getResultList());

	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person dbPerson = entityManager.find(Person.class, id);

		if (dbPerson != null) {
			entityTransaction.begin();
		//	entityManager.remove(dbPerson.getAadharCard());
			entityManager.remove(dbPerson);
			entityTransaction.commit();
		}
	}

	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person dbperson = entityManager.find(Person.class, id);
		if (dbperson != null) {
			person.setId(id);
			person.setAadharCard(dbperson.getAadharCard());

			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();

		} else {
			System.out.println("id not found ! ");
		}

	}

	public void updateAll(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person dbPerson = entityManager.find(Person.class, id);
		if (dbPerson != null) {
			person.setId(id);
			// person.setAadharCard(dbPerson.getAadharCard());
			person.getAadharCard().setId(dbPerson.getAadharCard().getId());
			entityTransaction.begin();
			//entityManager.merge(person.getAadharCard());
			entityManager.merge(person);
			entityTransaction.commit();
		}

	}

}
