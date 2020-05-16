import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListRandom {
	public static Random globalrand = new Random();
	public static ArrayList<Integer> lista = new ArrayList<>();
	public static void main(String[] args) {
		
		
		Scanner in =  new Scanner(System.in);
		System.out.println("Give max ranndom generated number");
		int max_int = (int)in.nextInt() ;
		long startTime =  System.currentTimeMillis();
		int toAdd;
		

//		//first thought of the exercise Time complexity in o(n) for every iteration done
		
		
//		for(int i = 0 ; i < max_int ; i++ ) {
//			do {
//				toAdd = globalrand.nextInt(max_int+1) + 0; 
//			}while(checkList(toAdd));
//			lista.add(toAdd);
//		}
//		printTime(startTime,System.currentTimeMillis());
		
//		printlist();
		
		//Final thoughts : never mind to slow :D
		
		
		//lista.removeAll(lista);
		
		
		
		
		startTime = System.currentTimeMillis() ;
		
		
		
		//second way dont know if it counts but it its still random in a way
		
		
		for(int i=0 ; i< max_int ; i++) {
			lista.add(i);
		}
		Collections.shuffle(lista);
		//ListRandom.printlist();
		in.close();
		printTime(startTime,System.currentTimeMillis());
		
		
		lista.removeAll(lista);
		
		
		
		//third way
		startTime = System.currentTimeMillis();
		
		
		Set<Integer> setaki = new LinkedHashSet<Integer>();
		while(setaki.size() < max_int) {
			setaki.add( globalrand.nextInt(max_int+1) + 0);
		}
		lista = setaki.stream().collect(Collectors.toCollection(ArrayList::new));
		printTime(startTime,System.currentTimeMillis());
		
	
		
		lista.removeAll(lista);
		
		
		//4rth way
		startTime = System.currentTimeMillis();
		
		
		
	
		while(lista.size() < max_int) {
			toAdd = globalrand.nextInt(max_int+1) + 0;
			if(!lista.contains(toAdd))
				lista.add(toAdd);
		}
		printTime(startTime,System.currentTimeMillis());
		
		lista.removeAll(lista);
		
		
		//5th way
		
		
		int [] existing = new int[max_int];
		startTime = System.currentTimeMillis();
		for(int i =0 ; i <max_int ; i++) {
			toAdd = globalrand.nextInt(max_int+1) + 0;
			Arrays.parallelSort(existing);
			if(Arrays.binarySearch(existing, toAdd)<0) lista.add(toAdd);
		};
		
		printTime(startTime,System.currentTimeMillis());
		
		
		
//		6th way
		startTime = System.currentTimeMillis();
		Integer[] arrays = Stream.generate(new Random()::nextInt).distinct().limit(max_int).toArray(Integer []::new);
		Collections.addAll(lista, arrays);
		printTime(startTime,System.currentTimeMillis());
		
		
		
		
		lista.removeAll(lista);
		
		//7th way
		
		startTime = System.currentTimeMillis();
		boolean [] boolarray = new boolean[max_int];	
		Arrays.fill(boolarray, false);
		
		while(lista.size() < max_int) {
			
			toAdd =globalrand.nextInt(max_int) + 0;
			
			if(boolarray[toAdd]==false) {
				lista.add(toAdd);
				boolarray[toAdd]=true;
			}
		}
		printTime(startTime,System.currentTimeMillis());
		//ListRandom.printlist();
		
		//8th way
		
		

	}
	
	public static boolean checkList(int x) {
		for(int iterating : lista) {
			if(iterating==x)
				return true;	
		}
		return false;
	}
	
	public static void printlist() {
		for(int iterating : lista) {
			System.out.println(iterating);
		}
	}
	public static void printTime(long StartTime , long EndTime) {
		System.out.println(EndTime-StartTime);
	}

}
