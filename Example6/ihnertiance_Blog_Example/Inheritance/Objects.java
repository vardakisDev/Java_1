package Inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Objects {

	public static void main(String[] args) {
		Site Blog = new Site();
		
		Login [] RegisteredUsers = new Login[2];
		RegisteredUsers[0] = new Admin("Stelios","@",'m');
		RegisteredUsers[1] = new User("Aladin","@",'m');
		for(Login x: RegisteredUsers)
			x.login();
//		Blog.addPost();
//		
//		for(Post x : Blog.posts) {
//			System.out.println(x);
//			x.addComment();
//			x.displayComms();
//			}
	}
	
}

interface Login{
	public void login();
}


class Site{
	 List<Post> posts = new ArrayList<>();
//	 public void addPost() {
//			Scanner in = new Scanner(System.in);
//			System.out.println("Admin");
//			Admin toWrite = new Admin(in.next(),in.next() , in.next().charAt(0));
//			posts.add(new Post(toWrite,in.next(),in.next()));
//			in.close();
//			
//		}
		public void searchAuthor(String author) {
			List<Post> result = posts.stream().filter(x -> author.equals(x.Author.name)).collect(Collectors.toList());
		}
		public void searchByCategory(String category) {
			List<Post> result = posts.stream().filter(x -> category.equals(x.Category)).collect(Collectors.toList());

		}
	

}


class Registered_User {
	public String name;
	public String email;
	public char gender;
	
	
	public Registered_User(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}

class Admin extends Registered_User implements Login{

	public Admin(String name, String email, char gender) {
		super(name, email, gender);
	}
	public void login() {
		System.out.println("Loged in as Admin");
		return;
	}
	
}

class User extends Registered_User implements Login{
	public User(String name, String email, char gender) {
		super(name, email, gender);
	}

	@Override
	public void login() {
		System.out.println("Loged in as Registered_User");
	}
	
}

class Post{
	public User Author;
	public String Text;
	public String Category;
	int like;
	public  Post(User admin,String text,String category) {
		this.Text=text;
		this.Author = admin;
		this.Category = category;
	}

	List<Comment> comments = new ArrayList<>();
	
//	public void addComment() {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Username");
//		Comment toWrite = new Comment(in.next(),in.next(),in.next().charAt(0),in.next());
//		comments.add(toWrite);
//		in.close();
//	}
//	public void displayComms() {
//		for(Comment x : comments) {
//			System.out.println("Name: "+ x.getName() +"Email: "+ x.getEmail() +" gender: "+ x.getGender());
//			System.out.println(x.text);
//		}

//	}
	public void like() {
		this.like++;
	}
	
}

class Comment{
	int like;
	public String text;
	public Comment(String Text) {
		this.text = Text;
	}
	public void Like() {
		this.like++;
	}
	
}





