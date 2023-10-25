package onetoone_uni_new.controller;

import java.util.Scanner;

import javax.persistence.Id;

import onetoone_uni_new.dao.AadharCardDao;
import onetoone_uni_new.dao.PersonDao;
import onetoone_uni_new.dto.AadharCard;
import onetoone_uni_new.dto.Person;

public class MainController {

	public static void main(String[] args) {
		Person person = new Person();
		PersonDao dao = new PersonDao();
		AadharCard aadharCard = new AadharCard();
		AadharCardDao aadharCardDao = new AadharCardDao();

		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"1.savePerson\n2.find person by id \n3.update person \n4.delete person \n5.find all person \n6 stop\n7. updateAadhar ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Enter the Aadhar Card Details : ");
			System.out.println("Enter the Aadhar Card id : ");
			aadharCard.setId(scanner.nextInt());
			System.out.println("Enter the Name : ");
			aadharCard.setName(scanner.next());
			System.out.println("Enter the address : ");
			aadharCard.setAddress(scanner.next());
			System.out.println("Enter the Peron detais ");
			System.out.println("Enter the id : ");
			person.setId(scanner.nextInt());
			System.out.println("Enter the name : ");
			person.setName(scanner.next());
			System.out.println("Enter the phone number : ");
			person.setPhone(scanner.nextLong());
			System.out.println("Enter the address : ");
			person.setAddress(scanner.next());
			person.setAadharCard(aadharCard);
			dao.savePerson(person);

		}
			break;
		case 2: {
			System.out.println("Enter the id : ");
			int id = scanner.nextInt();
			dao.findPerson(id);

		}
			break;
		case 3: {

			System.out.println("enter id");
			int id = scanner.nextInt();
//
//			System.out.println("enter name");
//			String name = scanner.next();
//
//			System.out.println("enter address");
//			String address = scanner.next();
//
//			System.out.println("enter phone ");
//			long phone = scanner.nextLong();
//
//			person.setAadharCard(aadharCard);
//			person.setName(name);
//			person.setAddress(address);
//			person.setPhone(phone);
//
//			System.out.println("enter name");
//			String a_name = scanner.next();
//
//			System.out.println("enter address");
//			String a_address = scanner.next();
//
//			aadharCard.setName(a_name);
//			aadharCard.setAddress(a_address)
			System.out.println("Enter the name : ");
			aadharCard.setName(scanner.next());
			System.out.println("Enter the address : ");
			aadharCard.setAddress(scanner.next());
			System.out.println("Enter the Person details ");
			System.out.println("Enter the name : ");
			person.setName(scanner.next());
			System.out.println("Enter the phone  ");
			person.setPhone(scanner.nextLong());
			System.out.println("Enter the address : ");
			person.setAddress(scanner.next());
			person.setAadharCard(aadharCard);

			dao.updateAll(id, person);

			break;
		}
		case 4: {
			System.out.println("enter person id ");
			int id = scanner.nextInt();
			dao.deletePerson(id);
			break;
		}
		case 5: {
			dao.findAllPerson();
			break;
		}
		case 6: {
			return;
		}
		case 7 :{
			System.out.println("Enter the id : ");
		     int id = scanner.nextInt();
			System.out.println("Enter the address : ");
			String adderss = scanner.next();
			System.out.println("Enter the name : ");
			String name = scanner.next();
			aadharCard.setName(name);
			aadharCard.setAddress(adderss);
			
			aadharCardDao.updateAadharCard(id, aadharCard);
		}
		}
	}
}
