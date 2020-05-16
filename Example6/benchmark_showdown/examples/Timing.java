package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Timing {
	
	
	public Random rand ;
	
	public static  void main(String[] args) {
		Timing time = new Timing();
		long millis_starTime =  System.currentTimeMillis();
		
		for (int i=0 ; i<10;i++) {
			long sum_student_age = 0;
			long sum_profesor_age = 0;
			int studs=0 ,profs =0 ;
			
			ArrayList<Human> school = time.Instantination();
			//calculate the average age of students and profersors
			for(Human x: school) {
				if(x instanceof Student) {
					studs++;
					sum_student_age = sum_student_age + x.getAge();
					}
				else if(x instanceof Professor) {
					profs++;
					sum_profesor_age = sum_profesor_age+ x.getAge();
				}
					
			}
			System.out.println("Average student age: "+sum_student_age/studs + " Average profesor age: "+ sum_profesor_age/profs);	
		}
		long millis_endTime = System.currentTimeMillis();
		
		System.out.println("Average Time consumed: " + (millis_endTime - millis_starTime)/10 );
	}
	
	
	
	
	//iniate 100000 random humans with randm names and ages using random
	public ArrayList<Human> Instantination() {
		
		ArrayList<Human>  lista =  new ArrayList<>();
		rand = new Random();
		String [] names = { "Jonh" , "Stelios" , "Fanis" , "Fani" , "Manolis" , "Aggelos" , "Giannis", "Gianis" , "Manousos", "Eleni" , "Kwstas" , "Maria"} ;
		for(int i = 0 ; i<1000000 ; i++) {
			switch(rand.nextInt(2)+1) {
			case 1: 
				lista.add(new Student((int)(Math.random() * 22) +10 , names[rand.nextInt(names.length)]));
			case 2:
				lista.add(new Professor((int)(Math.random() * 68) +26 , names[rand.nextInt(names.length)]));
			}
		}
		
		
		return (lista);
	}

}

