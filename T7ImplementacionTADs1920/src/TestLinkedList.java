import list.LinkedList;
import list.IList;

public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IList<String> list = new LinkedList<>();
		list.add(0, "1");
		list.add(1, "3");
		list.add(2, "5");
		list.add(3, "7");	
		System.out.println(list);
		
		System.out.println(list.indexOf("5"));
		System.out.println(list.indexOf("111"));
		
		list.remove("7");
		System.out.println(list);
		
		list.removeElementAt(0);
		System.out.println(list);
		
		IList<String> list1 = new LinkedList<>((LinkedList<String>) list);
		//ListInterface<Integer> list1 = new ArrayList<Integer>((ArrayList<Integer>) list);
		System.out.println(list1);
		System.out.println(list.equals(list1));
		
		IList<String> list2 = new LinkedList<String>();
		//ArrayList<String> list2 = new ArrayList<String>("java.lang.String");
		
		System.out.println(list.equals(list2));
		System.out.println(list.equals("jfkd"));
		
		list1.add(0, "7");
		System.out.println(list.equals(list1));
		
		LinkedList<String> list3 = ((LinkedList<String>)list1).deepCopy(data -> new String (data));
		System.out.println(list3);
		System.out.println(list1.equals(list3));
		
		
		//list.add(200, 0); // throw IndexOutOfBoundsException		
		
	}

}
