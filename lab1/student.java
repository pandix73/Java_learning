package lab1;

public class student {
	
	private String name = "pandix";
	
	public void setName(String str){
		 // set your name here
		name = str;
	}
	
	public void introduce(){
		String intro = "my name is " + name;
		System.out.println(intro);
	}
}
