package ch.itenengineering.jpa.relation.many2many.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "m2mCourse")
@Table(name = "R_MANY2MANY_COURSE")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	public Course() {
	}

	public Course(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append(id);

		buf.append(", ");
		buf.append(name);

		return buf.toString();
	}

} // end of class
