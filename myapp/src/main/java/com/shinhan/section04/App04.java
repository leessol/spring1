package com.shinhan.section04;

import org.shinhan.section06.License;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shinhan.section05.Car;


/**
 * Hello world!
 *
 */
public class App04 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("section04.xml");
		Book b1 = ctx.getBean("book",Book.class);
		Car c1 = ctx.getBean("myCar",Car.class);
		License li = ctx.getBean("license",License.class);
		People p1 = ctx.getBean("people",People.class);
		System.out.println(b1);
		System.out.println(c1);
		System.out.println(li);
		System.out.println(p1);
		
		EmpService service = ctx.getBean("empSer",EmpService.class);
		service.empAll();
    }
}

