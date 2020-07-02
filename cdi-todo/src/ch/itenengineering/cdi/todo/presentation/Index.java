package ch.itenengineering.cdi.todo.presentation;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ch.itenengineering.cdi.todo.boundary.TodoService;
import ch.itenengineering.cdi.todo.domain.Todo;

/**
 * Das JSF Backing Bean bildet die Praesentationslogik ab.
 * 
 * Es wird dabei mit der CDI Annotation @RequestScoped annotiert. Alternativ
 * koennte auch die JSF @ManagedBean Annotation eingesetzt werden.
 * 
 * Mit der @Named Annotaion kann das Bean zudem in den Markup's via Expression
 * Language referenziert werden.
 * 
 * Der Business Service Facade (TodoService) wird dabei auf einfache Art und
 * Weise per Injection vom Container zur Verfuegung gestellt.
 */
@SuppressWarnings("serial")
@Named
@RequestScoped
public class Index implements Serializable {

	// @Inject
	TodoService service;

	Todo todo = new Todo();

	public Todo getTodo() {
		return todo;
	}

	public List<Todo> getList() {
		return service.list();
	}

	public void save() {
		service.save(todo);
	}

	public void delete(Long id) {
		service.delete(id);
	}

} // end
