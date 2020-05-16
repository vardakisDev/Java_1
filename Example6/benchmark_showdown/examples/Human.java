package examples;


public class Human {


		private int age;
		private String name;
		
		
		public Human(int age,String name) {
			setAge(age);
			setName(name);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public  void printSomething() {
			
		}
	
}
//we declare this class as static cause with static we imply thath the class doesnt need the instance of the parent class in this case , Human
class Professor extends Human{
	public Professor(int age , String name) {
		super(age,name);
	}
	@Override
	public void printSomething() {
		System.out.println("Hello my name is Professor " + this.getName() +"and i am this years old " + this.getAge());
	}
	
}

class Student extends Human{
	public Student(int age , String name) {
		super(age,name);
	}
	@Override

	public void printSomething() {
		System.out.println("Hello my name is student " + this.getName() +" and i am this years old " + this.getAge());
	}
	
	int [] grades = new int[5];
	
}

