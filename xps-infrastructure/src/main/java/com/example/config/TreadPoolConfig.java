package com.example.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 */

@Configuration
@EnableAsync
public class TreadPoolConfig {

	@Value("${threadpool.corePoolSize:16}")
	private int corePoolSize;

	@Value("${threadpool.maxPoolSize:16}")
	private int maxPoolSize;

	@Value("${threadpool.queueCapacity:1024}")
	private int queueCapacity;

	@Value("${threadpool.keepAliveSeconds:60}")
	private int keepAliveSeconds;

	@Bean(name = "threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		//核心线程池数量，方法: 返回可用处理器的Java虚拟机的数量。
		pool.setCorePoolSize(corePoolSize);
		//最大线程数量
		pool.setMaxPoolSize(maxPoolSize);
		//线程池的队列容量
		pool.setQueueCapacity(queueCapacity);
		//线程池维护线程所允许的空闲时间
		pool.setKeepAliveSeconds(keepAliveSeconds);
		//线程名称的前缀
		pool.setThreadNamePrefix("this-excutor-menglar-");
		// setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
		// CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		pool.initialize();
		return pool;
	}
	/**
	 * 异步任务中异常处理
	 * */
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return new SimpleAsyncUncaughtExceptionHandler();
	}
}

