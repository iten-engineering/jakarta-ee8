package ch.itenengineering.jpa.relation.many2many.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.jpa.relation.many2many.domain.Course;
import ch.itenengineering.jpa.relation.many2many.domain.Student;

@Stateless
public class ManagerBeanM2M implements ManagerM2M {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	@Override
	public void clear() {
		em.createNativeQuery("delete from R_MANY2MANY_STUDENT_COURSE").executeUpdate();
		em.createQuery("delete from m2mStudent").executeUpdate();
		em.createQuery("delete from m2mCourse").executeUpdate();
	}

	@Override
	public void book(int studentId, int courseId) {

		// get managed course instance
		Course course = (Course) find(Course.class, courseId);

		// get managed student
		Student student = (Student) find(Student.class, studentId);

		// book course
		student.getCourses().add(course);
		merge(student);

		// alternative via native query
		// Query query = em.createNativeQuery(
		// "insert into r_many2many_student_course (student_id, course_id) values (:sid, :cid)"
		// );
		// query.setParameter("sid", studentId);
		// query.setParameter("cid", courseId);
		// query.executeUpdate();
	}

	@Override
	public void cancel(int studentId, int courseId) {
		// get managed course instance
		Course course = (Course) find(Course.class, courseId);

		// get managed student
		Student student = (Student) find(Student.class, studentId);

		// cancel course
		student.getCourses().remove(course);
		merge(student);

		// alternative via native query
		// Query query = em.createNativeQuery(
		// "delete from r_many2many_student_course where student_id=:sid and course_id=:cid"
		// );
		// query.setParameter("sid", studentId);
		// query.setParameter("cid", courseId);
		// query.executeUpdate();
	}

	@Override
	public Object persist(Object entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Object merge(Object entity) {
		return em.merge(entity);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object find(Class clazz, Object primaryKey) {
		return em.find(clazz, primaryKey);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void remove(Class clazz, Object primaryKey) {
		Object obj = find(clazz, primaryKey);
		if (obj != null) {
			em.remove(obj);
		}
	}

} // end of class
