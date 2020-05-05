package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 0504
 * xml Reader O
 * jdbc Writer O
 * Log O (기본 스키마로 존재)
 * mybatis X
 * API X
 * 처리 시간, 재요청 X
 * insert_schema_mysql.sql 미완성
 * 	- 모두 실패 한 것 일 시 오류 뜸. 
 * 	- DB 만든 후 task 실행 안하고, 끈 후 다시 실행 할 시 오류
 * 0505
 * reader를 자바파일로 만들어서 읽는것 해보는 중 
 */
public class App {
	public static void main(String[] args) {

		String[] springConfig  = 
			{	
				"spring/batch/config/database.xml",
				"spring/batch/config/context.xml",
				"spring/batch/jobs/job-report.xml"
			};
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("reportJob");


	}
}
