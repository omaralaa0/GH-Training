package tasksAPI;

import java.util.*;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.UserTaskServicesClient;


public class TaskHelper {

	public static void main(String[] args) {
		TaskHelper task = new TaskHelper();
//		task.startTask();
		task.completeTask();
		
	}

	
	public void startTask() {
		body util = new body();
		KieServicesClient kieServicesClient = util.getKieServicesClient();
		UserTaskServicesClient userClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		userClient.startTask("test_1.0.0-SNAPSHOT", 4L, "wbadmin");
		System.out.println("Task Started Succesfully");
	}
	
	public void completeTask() {
		body util = new body();
		KieServicesClient kieServicesClient = util.getKieServicesClient();
		UserTaskServicesClient userClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		Map<String, Object> map = new HashMap<String, Object>();	
		userClient.completeTask("test_1.0.0-SNAPSHOT", 4L, "wbadmin", map);
		System.out.println("Task Ended Succesfully");

	}

}