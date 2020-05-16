package StringManipulation;



public class StringManipulation {

	public static void main(String[] args) {
		
		
		String girl = new String("Iwanna");  //string constructor
		char [] name = new char[] {'P','a','u','l','o','s'}; //c based string represantation ,  an array of chars
		String boy =  new String(name) ; //overide string constructor that accepts a char array and builds a string
		
		System.out.println(girl+"\n"+boy);
		
		String normal = new String("Normal String");
		StringBuilder sbuild= new StringBuilder("String Builder"); //thread safe
		String builder = new String(sbuild);
		StringBuffer sbuffer = new StringBuffer("String Buffer"); //multithreading 
		String buffer =  new String(sbuffer);
		
		System.out.println(builder+"\n"+buffer);
		sbuild.append(" is not mutable");
		sbuffer.insert(13," is mutable"); 	// both build and buffer are mutable objects that can convert to strings 
		normal =  normal + " is 'nt mutable"; // in the other hand string normal class creates a new entry which is time and cost ineffective
		sbuild.delete(sbuild.indexOf("not"),sbuild.indexOf("not")+"not".length());  //this deletes the substring not without having to create a new string
		
		System.out.println(sbuild+ "\n" + sbuffer + "\n" + normal);
	
		//substring returns a sequence of char at a given index 
		System.out.println(sbuffer.substring(sbuild.indexOf("Builder")));

		//trimToSize example 
		System.out.println("Buffer Capacity before trim:" + sbuffer.capacity());
		sbuffer.trimToSize();
		//when we reach our end state of string manipulation , we reduce the size of the buffer since we might not need all of it  , especially in big programmas , reducing the size
		//will be a big relief , for example imagine 1milion of strings each having 4 bit of memory wasted . with simple math its 4 x1m = 4.000.000 = 4mb extra cost  of our ram 
		System.out.println("Buffer capacity after trim:" + sbuffer.capacity());
		
		//setLength
		//this method reduces the size of string but the capacity stays the same 
		System.out.println("Length of sbuffer " + sbuffer.length()+ " and it prints : "+ sbuffer + " wiith capacity: " +sbuffer.capacity());
		sbuffer.setLength(12);
		System.out.println("Length of sbuffer after the setLength method:" + sbuffer.length()+ " and it prints : "+ sbuffer + " wiith capacity: " +sbuffer.capacity());
		
		
		//how do we know a string if it exists in the the pool ? 
		String basic = "already in";
		String copy = "already in";
		String newformed = new String("already in");
		//checks if object have the same adress in this case if they belong to the string pool
		System.out.println(basic==newformed); // returns false since every time we use new a new object is created so its different adress
		System.out.println(basic==copy);
		System.out.println(basic.equals(newformed) & newformed.equals(copy)); //equals compares the ASCII code of every card and is also case sensittive
		System.out.println(basic.equalsIgnoreCase(copy)); // as the name implies it ignores the cases 

		//check if the string methods adds the returned string to the jve pool
		String replaced = copy.replace("in" ,"out");
		System.out.println(replaced);
		
		String inpool = "already out";
		System.out.println(inpool==replaced);  //returns false so the retunred string from replace methods doesnt add the returned value to jve pool

		
		
		

		
		
		
		
		
		
		

	}

}
