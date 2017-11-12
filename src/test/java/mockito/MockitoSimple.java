package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoSimple {

	@Test
	public void test() {
		List list = mock(List.class);
		int value = 2;
		when(list.size()).thenReturn(value);
		assertEquals(2, list.size());

	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List list = Mockito.mock(List.class);
		Mockito.when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(0)).thenReturn("thisIsAMock");
		assertEquals("thisIsAMock", list.get(0));
		assertNull(list.get(1));
	}

	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("thisIsAMock");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("thisIsAMock", list.get(0));
		assertEquals("thisIsAMock", list.get(1));
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockWithException() {
		List list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("The Bosco"));
		list.get(1);
	}
	
	

}
