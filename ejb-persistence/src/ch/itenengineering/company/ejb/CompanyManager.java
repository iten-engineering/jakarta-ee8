package ch.itenengineering.company.ejb;

import java.util.List;

import javax.ejb.Local;

import ch.itenengineering.company.domain.Company;

@Local
public interface CompanyManager {

	/**
	 * insert a company to the company table
	 * 
	 * @param company
	 *            to save
	 * @return saved company (including the auto generated primary key)
	 */
	public Company persist(Company company);

	/**
	 * update an existing company entity
	 * 
	 * @param company
	 *            to save
	 * @return modified company (including the auto generated version id)
	 */
	public Company merge(Company company);

	/**
	 * remove the compay for the given company id (primary key)
	 * 
	 * @param id
	 *            primary key
	 */
	public void remove(int id);

	/**
	 * find a company by it's company id (primary key)
	 * 
	 * @param id
	 *            primary key
	 * @return company found
	 */
	public Company find(int id);

	/**
	 * find all company's (sorted by name) matching the given name pattern
	 * 
	 * the following wildcards may be used:
	 * <ul>
	 * <li>% for a sequence of 0..n characters</li>
	 * <li>_ for 1 single character</li>
	 * </ul>
	 * 
	 * @param namePattern
	 *            name of company or pattern with wildcards
	 * @return list of company's or null
	 */
	public List find(String namePattern);

} // end
