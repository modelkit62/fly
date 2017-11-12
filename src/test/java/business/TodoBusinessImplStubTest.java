package business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import mockito.TodoBusinessImpl;
import mockito.TodoService;
import mockito.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Cojones");
		assertEquals(2, todos.size());
		System.out.println("");
	}
}
