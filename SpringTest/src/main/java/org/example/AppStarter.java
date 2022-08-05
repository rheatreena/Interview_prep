package org.example;

import javax.annotation.Nonnull;

import org.example.AOP.AfterAdvisor;
import org.example.AOP.BeforeAdvisor;
import org.example.AOP.MethodBeforeAdviceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Nonnull
public class AppStarter {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AppStarter.class);

	public static void main(String[] args) {
		LOGGER.info("Starting up...");
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				Config.class)) {
			LOGGER.info(context.getBean(App.class).getMessage());
			MethodBeforeAdviceTest methodBean = context.getBean(MethodBeforeAdviceTest.class);
			//BeforeAdvisor beforeAdvisorBean = context.getBean(BeforeAdvisor.class);
			//AnnotationAwareAspectJAutoProxyCreator testBean = context.getBean(AnnotationAwareAspectJAutoProxyCreator.class);

			System.out.println("calling msg...");
			methodBean.testMethod();
			methodBean.testAfterMethod();

		}
	}

	@Configuration
	@Nonnull
	static abstract class Config {
		@Bean
		public App app() {
			return new App("Hello World!");
		}

		@Bean
		public MethodBeforeAdviceTest methodBean(){
			return new MethodBeforeAdviceTest();
		}

		@Bean
		public BeforeAdvisor beforeAdvisor(){
			return new BeforeAdvisor();
		}

		@Bean
		public AnnotationAwareAspectJAutoProxyCreator testBean(){
			return new AnnotationAwareAspectJAutoProxyCreator();
		}



		@Bean
		public AfterAdvisor afterAdvisor(){
			return new AfterAdvisor();
		}




	}
}
