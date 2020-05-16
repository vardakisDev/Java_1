package ListManipulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

class ListManipulation {
	
	//we declare this class as static cause with static we imply thath the class doesnt need the instance of the parent class in this case , Human
	public  static class Professor extends Human{
		public Professor(int age , String name) {
			super(age,name);
		}
		@Override
		public void printSomething() {
			System.out.println("Hello my name is Professor " + this.getName() +"and i am this years old " + this.getAge());
		}
		
	}
	
	public static class Student extends Human{
		public Student(int age , String name) {
			super(age,name);
		}
		@Override

		public void printSomething() {
			System.out.println("Hello my name is student " + this.getName() +" and i am this years old " + this.getAge());
		}
		
		int [] grades = new int[5];
		
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Student> studs = new ArrayList<>();
		List<Professor> profs = new LinkedList<>();
		studs.add(new Student(10,"Stelis"));
		studs.add(new Student(20,"Jonh"));
		
		Random rand =  new Random();
		for(Student x : studs) {
			for(int i=0 ; i<x.grades.length ; i++)
				x.grades[i] = rand.nextInt(20)+1; 
		}
		
		
//////LABELS USAGE EXAMPLE
		for(Student x: studs) {
		search:
			for(int i=0; i<x.grades.length ; i++) {
				if(x.grades[i] == 15) {
					System.out.println("Perfect student");
					break search;
				}
			}
			
		}
		
		profs.add(new Professor(59,"Sapoynakis"));
		profs.add(new Professor(39,"Patsakis"));
		
		//this is the simplest way to itarate a list , using the for loop like c
		//with this loop we can change the value of an object or use a method but we cant delete add or manipulate the list
		for(int i = 0 ; i<profs.size() ; i++) {
			profs.get(i).printSomething();
			profs.get(i).setAge(100);
		};
		
		//for each object loop ,  the same as the simple  c iteration we cant manipulate the list , but we change values or use methods of the object inside the list
		for(Student s: studs) {
			s.setAge(100);
			s.printSomething();
			
		};
		
		ListIterator<Student> iterator = studs.listIterator();
		///with this loop we can both  manipulate the list with add or remove or delete but we can also manipulate the object
		while(iterator.hasNext()) {
			Student currentValue = iterator.next();
			currentValue.setAge(20);
//			iterator.remove();
		};
		//the same but written with for loop
		for(ListIterator<Student> it = studs.listIterator() ; it.hasNext() ;) {
			 Student currentValue = it.next();
			 currentValue.setAge(20);
			 currentValue.printSomething();
//			 it.remove();
		}
		
		//TO SUM UP 
		//With the noraml loops , like the simple for loop and the for each , we can manipulate the obejct at its given index and use the object's methods
		//In the other hand with iterator we are given to chance to manipulate also the list by adding or removing an object ,and move forward anc backwards in a given list
		//About the time complexity now , when we are using ArrayList which save memory in continious blocks , the time complexity in all of these 3 ways is the same
		//but when it comes to LinkedList , which saves data in non-continious memory blocks the time coplexity from 0(1) rises drasticly.
		
		//adds a collection to an already existing one
		ArrayList<Student> newstudent = new ArrayList<>();
		newstudent.add(new Student(10,"Angelos"));
		studs.addAll(2, newstudent);
		
		//initiate a new array and copies all the elements of the arraylist
		Student[] students = studs.toArray(new Student[0]);
		
		for(Student x : students) {
			x.printSomething();
			x.setAge(100);
		}
		//clone the list
		ArrayList<Student> copied = (ArrayList<Student>) studs.clone();
		System.out.println(copied==studs); //its not the same its a new ArrayList
		for(Student x: copied) {
			x.printSomething();
		}
	}
	
	
	
	
	
}
