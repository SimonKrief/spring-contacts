package fr.gtm.contacts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gtm.contacts.entities.Contact;

// equivalent en spring du contactDAO
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	// genere la requete jpql correspondante
	List<Contact> getByNomLike(String nom);
//		@Query("SELECT a FROM adresses a WHERE ")
//		List<Adresse> getAdresseByContact(Long fk_contact);

//		List<Adresse> findByContacts_Adresses(String string);
//		List<Adresse> findByAdresses_Contacts(String string);

//		List<Adresse> getAdresseByContact(Long fk_contact);

	// récupération d'un contact et de ses adresses en mode lazy
	@Query("SELECT c FROM Contact c JOIN FETCH c.adresses WHERE c.id = ?1")
//		Optional<Contact> getContactById(long id);
	Contact getContactById(long id);

}
