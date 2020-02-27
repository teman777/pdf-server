package com.artemvoronov;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.artemvoronov.config.AppConfig;
public class Main {
	public static void main(String[] args){
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(AppConfig.class);
			App app = context.getBean(App.class);
			app.notMain();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			context.close();
		
		}
	}
}

