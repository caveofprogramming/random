package limitless.model;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

public class QuestionDao {

	private SessionFactory sessionFactory;

	public void connect() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public void save(Question question) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(question);
		session.getTransaction().commit();
		session.close();
	}

	public void disconnect() {
		sessionFactory.close();
	}

	public QuestionType getQuestionType(String name) {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<QuestionType> types = session.createCriteria(QuestionType.class).add(Restrictions.eq("name", name)).list();

		assert (types.size() == 1);

		return types.get(0);
	}

	public User getUser(String name) {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<User> users = session.createCriteria(User.class).add(Restrictions.eq("name", name)).list();

		assert (users.size() == 1);

		return users.get(0);
	}
}
