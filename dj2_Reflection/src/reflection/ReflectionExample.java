package reflection;

import java.awt.Rectangle;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;



public class ReflectionExample {

	public static void printClassHierarchy(Class<?> c){
		if (c!=null){
			System.out.println(c.getSimpleName());
			printClassHierarchy(c.getSuperclass());
		}
	}

	// gibt alle getter und setter aus
	public static void printGettersSetters(Class<?> aClass) {
		Method[] methods = aClass.getMethods();

		for (Method method : methods) {
			if (isGetter(method))
				System.out.println("getter: " + method);
			if (isSetter(method))
				System.out.println("setter: " + method);
		}
	}

	public static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get"))
			return false;
		if (method.getParameterTypes().length != 0)
			return false;
		if (void.class.equals(method.getReturnType()))
			return false;
		return true;
	}

	
	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set"))
			return false;
		if (method.getParameterTypes().length != 1)
			return false;
		return true;
	}

	
	/**
	 * Gibt alle alle deklarierten ("eigenen") Methoden mit voller Signatur zurück
	 * @param c
	 */
	public static void printMethods(Class<?> c){
			for (Method method: c.getDeclaredMethods()) {
				System.out.println(method);
			}
	}
	
	/**
	 * Gibt alle alle deklarierten public Methoden mit voller Signatur zurück
	 * @param c
	 */
	public static void printPublicMethods(Class<?> c){
		  Method methods[] = c.getDeclaredMethods();
	      for (int i = 0; i < methods.length; i++) {
	        int modifiers = methods[i].getModifiers();
	        if (Modifier.isPublic(modifiers)) {
	          System.out.println(" " + methods[i].getName());
	        }
	      }
	      
	}
	
	
	/**
	 * invoke: führt eine beliebige Methode(ohne Paramter) aus.
	 * @param object
	 * @param methodname
	 * @return
	 */
	public static Object  executeMethod(Object object, String methodname) {
	    Object value = null;
	    try {
	    	// Methodenname, Parameter (new Class[0] == kein Parameter)
	    	
	        Method getter = object.getClass().getMethod(methodname, new Class[0]);
	        value = getter.invoke(object, new Object[0]);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } 
	   
	 
	    return value;
	}
	
	
	/**
	 * invoke: führt eine beliebige Methode(mit Paramter) aus.
	 * Beispiel: executeMethod(p, "setName", new Class[]{String.class}, new String[]{"Max"} );
	 * @param object
	 * @param methodname
	 * @return
	 */
	public static Object  executeMethod(Object object, String methodname, Class[] types, Object[] values) {
	    Object value = null;
	    try {
	        Method method = object.getClass().getMethod(methodname, types);// Methodenname, Parameter
	        value = method.invoke(object, values);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } 
	   
	 
	    return value;
	}
	/**
	 *  Factory Method
	 * @param className
	 * @return
	 */
	public static Object createObject(String className) {
	      Object object = null;
	      try {
	          Class classDefinition = Class.forName(className);
	          
	          System.out.println(classDefinition);
	          object = classDefinition.newInstance();
	      } catch (InstantiationException e) {
	          System.out.println(e);
	      } catch (IllegalAccessException e) {
	          System.out.println(e);
	      } catch (ClassNotFoundException e) {
	          System.out.println(e);
	      }
	      return object;
	   }
	
	
	public static void main(String[] args) {
//		printMethods(Person.class);
//		printClassHierarchy(ArrayList.class);
//		printMethods(Person.class);
//
//		printPublicMethods(Person.class);
//		System.out.println(executeMethod(new Person(), "toString"));
//		
//		Person p = new Person();
		
//		executeMethod(p, "setName", new Class[]{String.class}, new String[]{"Max"} );
//		System.out.println(p.getName());
//		
//		
		Rectangle r = (Rectangle) createObject("java.awt.Rectangle");
		System.out.println(r.toString());
			
	}
	
	

}
