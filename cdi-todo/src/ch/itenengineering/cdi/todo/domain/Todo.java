package ch.itenengineering.cdi.todo.domain;

import java.io.Serializable;

/**
 * Die Klasse Todo bildet unsere Domäne ab. Da es ein kleines Beispiel ist, wird
 * diese auch gleich (anstelle eines Transfer Objektes) dem Client zur Verfügung
 * gestellt.
 */
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String description;

	private int version;

	public Todo() {
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return this.version;
	}

} // end of class
