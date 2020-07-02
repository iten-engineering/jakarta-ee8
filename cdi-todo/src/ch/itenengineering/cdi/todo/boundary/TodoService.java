package ch.itenengineering.cdi.todo.boundary;

import java.util.List;

import ch.itenengineering.cdi.todo.domain.Todo;

public interface TodoService {

	public List<Todo> list();

	public void save(Todo todo);

	public void delete(Long id);

}
