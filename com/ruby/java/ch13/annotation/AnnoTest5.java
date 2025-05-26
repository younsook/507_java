package com.ruby.java.ch13.annotation;
//어노테이션 value 많이사용. 652p
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Bean{
	String value();
}

@Bean("Member")

public class AnnoTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnoTest5 obj = new AnnoTest5();
		
		try {
			Class<?> c = obj.getClass();
			Bean b = c.getAnnotation(Bean.class);
			System.out.println(b.value());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
