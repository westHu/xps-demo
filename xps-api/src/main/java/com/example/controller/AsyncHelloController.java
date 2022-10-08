package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class AsyncHelloController {

	/**
	 * asyncCallable
	 * @return
	 */
	@GetMapping("/asyncCallable")
	public Callable<String> asyncCallable() {
		log.info(Thread.currentThread().getName() + " 主线程start");
		Callable<String> callable = () -> {
			log.info(Thread.currentThread().getName() + " 子子子线程start");
			TimeUnit.SECONDS.sleep(5); //模拟处理业务逻辑，话费了5秒钟
			log.info(Thread.currentThread().getName() + " 子子子线程end");
			// 这里稍微小细节一下：最终返回的不是Callable对象，而是它里面的内容
			return "hello world";
		};
		log.info(Thread.currentThread().getName() + " 主线程end");
		return callable;
	}

	/**
	 * WebAsyncTask
	 * @return
	 */
	@ResponseBody
	@GetMapping("/asyncWebAsyncTask")
	public WebAsyncTask<String> asyncWebAsyncTask() throws Exception {
		log.info(Thread.currentThread().getName() + " 主线程start");

		Callable<String> callable = () -> {
			log.info(Thread.currentThread().getName() + " 子子子线程start");
			TimeUnit.SECONDS.sleep(5); //模拟处理业务逻辑，话费了5秒钟
			log.info(Thread.currentThread().getName() + " 子子子线程end");
			// 这里稍微小细节一下：最终返回的不是Callable对象，而是它里面的内容
			return "hello world";
		};

		// 采用WebAsyncTask 返回 这样可以处理超时和错误 同时也可以指定使用的Excutor名称
		WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(3000, callable);
		// 注意：onCompletion表示完成，不管你是否超时、是否抛出异常，这个函数都会执行的
		webAsyncTask.onCompletion(() -> System.out.println("程序[正常执行]完成的回调"));

		// 这两个返回的内容，最终都会放进response里面去===========
		webAsyncTask.onTimeout(() -> "程序[超时]的回调");
		// 备注：这个是Spring5新增的
		webAsyncTask.onError(() -> "程序[出现异常]的回调");


		log.info(Thread.currentThread().getName() + " 主线程end");
		return webAsyncTask;
	}

	/**
	 * DeferredResult
	 * @return
	 */
	private List<DeferredResult<String>> deferredResultList = new ArrayList<>();
	@GetMapping("/getDeferredResult")
	public DeferredResult<String> getDeferredResult() {
		DeferredResult<String> deferredResult = new DeferredResult<>();
		//先存起来，等待触发
		deferredResultList.add(deferredResult);
		return deferredResult;
	}
	@GetMapping("/setDeferredResult")
	public void setDeferredResult() throws Exception {
		// 让所有hold住的请求给与响应
		deferredResultList.forEach(d -> d.setResult(String.valueOf(System.nanoTime())));
	}





}
