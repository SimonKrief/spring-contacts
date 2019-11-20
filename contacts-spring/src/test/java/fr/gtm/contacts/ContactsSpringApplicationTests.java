package fr.gtm.contacts;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

//!\ nous sommes sur j-unit5 (jupiter):
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Contact;
import fr.gtm.contacts.repository.AdresseRepository;
import fr.gtm.contacts.repository.ContactRepository;

//!\ nous sommes sur j-unit5 (jupiter):
@ExtendWith(SpringExtension.class)
@SpringBootTest
//@DataJpaTest//créé une base de données
class ContactsSpringApplicationTests {
	@Autowired ContactRepository repoContact;
	@Autowired AdresseRepository repoAdresse;

	@Test
	void contextLoads() {
		assertNotNull(repoContact);
	}
	
	@Test
	void getAllContacts() {
		List<Contact> contacts = repoContact.findAll();
		assertTrue(contacts.size()>0);
	}
	
	@Test
	void getAllAdresses() {
		List<Adresse> adresses = repoAdresse.findAll();
		assertTrue(adresses.size()>0);
	}	
	
	@Test
	void getByNomLike() {
		List<Contact> contacts = repoContact.getByNomLike("Beretto");
		assertTrue(contacts.size()>0);
	}
	
	@Test
	void getContactById() {
		Contact c = repoContact.getContactById(12);
//		Optional<Contact> oc = repoContact.getContactById(12);
		assertNotNull(c);
	}
	
//	@Test
//	void getAdresseByContact() {
//		List<Adresse> adresses = repo.getAdresseByContact("Beretto");
//		assertTrue(adresses.size()>0);
//	}
	
	
//	@Test
//	void findByAdresses_Contacts() {
//		List<Adresse> adresses = repo.findByAdresses_Contacts("Beretto");
//		assertTrue(adresses.size()>0);
//	}
	
	
	
//	@Test
//	void findByContacts_Adresses() {
//		List<Adresse> adresses = repo.findByContacts_Adresses("Beretto");
//	}
	
	

}
