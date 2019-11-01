package br.com.monteiro.hibernate_maven;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.monteiro.hibernate.model.Function;

public class Teste {

	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence .createEntityManagerFactory("hibernate-postgres");
//	private static EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
	
	public static void main(String[] args) {

//		insertFunction("Capitain");
//		insertFunction("Cozinheiro");
//		insertFunction("Navegador");
//		insertFunction("Médico");
//		insertFunction("Engenheiro");
//		insertFunction("Espadachim");
//		insertFunction("Atirador");
//		insertFunction("Arqueólogo");
//		insertFunction("Músico");
		
		ENTITY_MANAGER_FACTORY.close();
		
			
	}
	
	
	public static void insertFunction(String name) {
		EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = ENTITY_MANAGER.getTransaction();
			et.begin();
			
			Function function = new Function();
			function.setHierarchy(name);
			
		
			ENTITY_MANAGER.persist(function);
			et.commit();
		} catch (Exception e) {
			if(et!=null) {
				et.rollback();
			}
			System.err.println(e.getMessage());
		}finally {
			ENTITY_MANAGER.close();
		}
	}

}
