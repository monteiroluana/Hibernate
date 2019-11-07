package br.com.monteiro.hibernate_maven;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.monteiro.hibernate.model.Funcao;

public class Teste {

	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence .createEntityManagerFactory("hibernate-postgres");
//	private static EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
	
	public static void main(String[] args) {

//		insertFunction("Arqueólogo");
//		insertFunction("Músico");

		List<Funcao> list = listFuncao();
		
		for (Funcao funcao : list) { System.out.println(funcao.getId() +"\t"+ funcao.getHierarchy()); }
		
		ENTITY_MANAGER_FACTORY.close();	
			
	}
	
	
	public static void insertFunction(String name) {
		EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = ENTITY_MANAGER.getTransaction();
			et.begin();
			
			Funcao function = new Funcao();
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
	
	public static List<Funcao> listFuncao() {
    	EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    	String sql = "select f from funcao f ";
    	TypedQuery<Funcao> query = ENTITY_MANAGER.createQuery(sql, Funcao.class);
    	return query.getResultList();	
    }

}
