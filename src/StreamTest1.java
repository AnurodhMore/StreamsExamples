import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamTest1 {

//	//@Test
//	public void regular()
//
//	{
//		ArrayList<String> names = new ArrayList<String>();
//
//		names.add("Arik");
//		names.add("Rick");
//		names.add("Arush");
//		names.add("Vik");
//		names.add("Amit");
//
//		int count = 0;
//
//		for (int i = 0; i < names.size(); i++) {
//			String actual = names.get(i);
//			if (actual.startsWith("A")) {
//				count++;
//			}
//		}
//
//		System.out.println(count);
//	}

//	@Test
	public void streamFilter() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Arik");
		names.add("Ricky");
		names.add("Arush");
		names.add("Vicky");
		names.add("Amit");
		
	    Long c =names.stream().filter(s->s.startsWith("A")).count(); //data type of count is long
        System.out.println(c);
        
        // We can also create a stream and filter it rather than converting arraylist to stream
        
   //     Stream.of("Arik","Rick","Arush","Vik","Amit").filter(s->s.startsWith("A"));
//        Stream.of("Arik","Rick","Arush","Vik","Amit").filter(s->
//        {
//        	 s.startsWith("A");
//        });
        
        
        //print all the names of ArrayList
        
     //   names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
        
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s)); // will only print first value
        
        
        
        
        
        
        
        
        
        
//       
	}

	
	
//	@Test
	// print names whose last name ends with 'a' with Upper Case
	public void streamMap()
	{
		
//		Stream.of("Arik","Rick","Arush","Vik","Amit").filter(s->s.endsWith("k")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		// first letter as 'A' with upper case and sorted
		
	//	Stream.of("Abik","Rick","Arush","Vik","Amit").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		ArrayList<String> names = new ArrayList<String>();

		names.add("Arik");
		names.add("Ricky");
		names.add("Arush");
		names.add("Vicky");
		names.add("Amit");
		
		
		List<String> names1 = Arrays.asList("Abik","Ritek","Arsh","Vikram","Amey");  // this method can also be preffered
		
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging two different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		
	//	newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Vikram"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
	}
	
	
	
	@Test
	public void streamCollect()
	{
		List<String> ls = Stream.of("Abik","Rick","Arush","Vik","Amit").filter(s->s.startsWith("A")).
				map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(ls.get(0));
		
		
		//Print unoque number from this array andsort the array
		
		List<Integer> nos2 = Arrays.asList(12,3,45,6,62,7,3,5,6,9);
		
	//	nos2.stream().distinct().forEach(s-> System.out.println(s));
		
		
		//Sort array and print 3rd index
		
	List<Integer> newNos =	nos2.stream().distinct().sorted().collect(Collectors.toList());
	
	System.out.println(newNos.get(2)); // sorted roder would be 3, 5,6,7,9,12,45,62
	}
	
	
	
	
	
	
} 






