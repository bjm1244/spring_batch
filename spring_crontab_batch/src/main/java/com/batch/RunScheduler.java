package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

public class RunScheduler {
	
	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;
	
	public void run() {
		try {
			JobParameters jobParameters = new JobParametersBuilder()
					  .addLong("time",System.currentTimeMillis()).toJobParameters();
						
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
		} finally {
			
		}

		System.out.println("Done");
		
	}
}
