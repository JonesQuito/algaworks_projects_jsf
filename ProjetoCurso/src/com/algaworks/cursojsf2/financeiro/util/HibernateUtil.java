package com.algaworks.cursojsf2.financeiro.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//variável stática ou de classe que representa uma fabrica de sessão.
	private static final SessionFactory sessionFactory;
	
	/*
	 * Bloco static para obter uma fabrica de sessão e atribuí-la à variável
	 * static sessionFactory
	 * 
	 * */
	static {
		try {
			/*			
			 * Instancia uma new Configuration para obter uma configuração e em seguida
			 * invoca o método configure() para setar na configuração os dados do arquivo
			 * hibernate.cfg.xml, ou seja, as informações de conexão com o banco de dados.
			 * Por fim, após invocar o método configure() da Configuration, constrói-se a
			 * fabrica de sessão invocando o método buildSessionFactory() da Configuration
			 */
			/*
			Configuration configuration = new Configuration();
			configuration.configure();
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = new Configuration().buildSessionFactory(serviceRegistry);
			*/
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
		}catch(Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
