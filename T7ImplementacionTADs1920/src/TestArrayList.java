import list.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0, 1);
		list.add(1, 3);
		list.add(2, 5);
		list.add(3, 7);	//call grow	
		
		System.out.println(list);
		
		System.out.println(list.indexOf(5));
		System.out.println(list.indexOf(111));
		
		list.remove(7);
		System.out.println(list);
		
		list.removeElementAt(0);
		System.out.println(list);
		
		ArrayList<Integer> list1 = new ArrayList<Integer>(
				list);
		System.out.println(list1);
		System.out.println(list.equals(list1));
		
		ArrayList<String> list2 = new ArrayList<String>();
		
		System.out.println(list.equals(list2));
		System.out.println(list.equals("jfkd"));
		
		list1.add(0, 7);
		System.out.println(list.equals(list1));
		
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		
		for(int i=0; i<30; i++)
		    list3.add(list3.size(), i); // grow three times
		
		System.out.println(list3);
		
		for(int i=0; i<20; i++)
		    list3.removeElementAt(0); // Shrink once
		
		System.out.println(list3);
		
		//list.add(200, 0); // throw IndexOutOfBoundsException		
		
	}

}
