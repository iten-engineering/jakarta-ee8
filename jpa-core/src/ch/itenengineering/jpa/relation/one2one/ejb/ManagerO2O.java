package ch.itenengineering.jpa.relation.one2one.ejb;

import javax.ejb.Local;

@Local
public interface ManagerO2O {

	/**
	 * Fügt eine neue Entität in die Datenbank und gibt die eingefügte Entität
	 * zurück an den Aufrufer. Die Rückgabe ist vor allem praktisch, falls der
	 * Primärschlüssel automatisch generiert wird. In diesem Fall beinhaltet das
	 * zurückgegebene Objekt den Primärschlüssel.
	 * 
	 * @param entity
	 *            Entität die eingefügt werden soll
	 * @return Eingefügte Entität inklusive Primärschlüssel
	 */
	public Object persist(Object entity);

	/**
	 * Aktualisiere den Persistence Kontext mit den Werten der übergebenen
	 * Entität.
	 * 
	 * @param entity
	 *            Entiät mit aktuellen Werten
	 * @return Instanz mit aktulisierten Werten
	 */
	public Object merge(Object entity);

	/**
	 * Suche eine Entität anhand der Primärschlüssel.
	 * 
	 * @param clazz
	 *            Class Objekt der Entität
	 * @param primaryKey
	 *            Primärschlüssel der Entität
	 * @return Instanz der gefundenen Entität oder null falls keine Eintrag
	 *         gefunden wurde
	 */
	@SuppressWarnings("rawtypes")
	public Object find(Class clazz, Object primaryKey);

	/**
	 * Lösche den Datenbankeintrag mit dem angegebenen Primärschlüssel.
	 * 
	 * @param clazz
	 *            Class Objekt der Entität die auf der DB gelöscht werden soll
	 * @param primaryKey
	 *            Primärschlüssel
	 */
	@SuppressWarnings("rawtypes")
	public void remove(Class clazz, Object primaryKey);

} // end
