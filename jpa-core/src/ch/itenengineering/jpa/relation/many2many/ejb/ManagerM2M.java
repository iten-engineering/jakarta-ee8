package ch.itenengineering.jpa.relation.many2many.ejb;

import javax.ejb.Local;

@Local
public interface ManagerM2M {

	/**
	 * Löscht alle Einträge in den DB Tabellen.
	 */
	public void clear();

	/**
	 * Bucht für den Studenten mit der angegebenen Id den gewünschten Kurs
	 * anhand der Kurs Id.
	 * 
	 * @param studentId
	 *            Primärschlüssel des Studenten der den Kurs buchen will.
	 * @param courseId
	 *            Primärschlüssel des zu buchenden Kurses.
	 */
	public void book(int studentId, int courseId);

	/**
	 * Annuliert einen gebuchten Kurs.
	 * 
	 * @param studentId
	 *            Primärschlüssel des Studenten der den Kurs annulieren will.
	 * @param courseId
	 *            Primärschlüssel des zu annulierenden Kurses.
	 */
	public void cancel(int studentId, int courseId);

	public Object persist(Object entity);

	public Object merge(Object entity);

	@SuppressWarnings("rawtypes")
	public Object find(Class clazz, Object primaryKey);

	@SuppressWarnings("rawtypes")
	public void remove(Class clazz, Object primaryKey);

} // end
