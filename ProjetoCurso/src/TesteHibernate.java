import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;

public class TesteHibernate {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
				
		//List<Pessoa> pessoas = session.createCriteria(Pessoa.class).list();
		List<Pessoa> pessoas = session.createCriteria(Pessoa.class).list();
		
		System.out.println();
		System.out.println("Pessoas cadastradas: " + pessoas.size());
		System.out.println();
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + " - " + p.getNome());
		}
		
		session.close();
		
	}

}
