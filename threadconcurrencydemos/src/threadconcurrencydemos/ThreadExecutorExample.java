package threadconcurrencydemos;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadExecutorExample {
	String threadName=null;
	public static void main(String []args){
		
		Task task = (threadName) -> {
			Runnable runnable = ()-> {
				for(int i=0;i<5;i++){
					System.out.println("Thread Name : "+threadName+" Count : "+i);
				}
				};
			return runnable;
		};
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i <= 5; i++) 
        {
        	System.out.println("A new task has been added : " + "Name : "+i);
        	executor.execute(task.task("Name : "+i));
        }
        executor.shutdown();
		
	}

}
@FunctionalInterface
interface Task {
	Runnable task(String name);
}
