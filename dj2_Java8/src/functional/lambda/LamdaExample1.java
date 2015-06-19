package functional.lambda;

@FunctionalInterface
interface MyInterface1{
	public int test(String s); // return int
}
@FunctionalInterface
interface MyInterface2{
	public void test(String s);// void 
	
}


public class LamdaExample1 {
	public static void main(String[] args) {
				
		//konventionelle Schreibweise
		MyInterface1 m1 = new MyInterface1() {
			@Override
			public int test(String s) {
				return s.length();
			}
		};
		
		//Lamda
		MyInterface1 m2 = (String s)-> {
			return s.length();
		}; 
		
		
		
		//Lamda noch kürzer
		MyInterface1 m3 = s-> { return s.length(); };
		
		
		int c = m3.test("Hallo");
		System.out.println(c);//5
		
		//-----------------Param-> Anweisung
		MyInterface2 mi4 = t-> System.out.println(t.toLowerCase());
		
		mi4.test("Hallo"); //hallo
		
		
	
	}
}
