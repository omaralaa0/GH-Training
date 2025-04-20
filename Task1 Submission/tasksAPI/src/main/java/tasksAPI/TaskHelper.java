package tasksAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.task.model.TaskSummary;
import org.kie.server.api.model.definition.TaskQueryFilterSpec;
import org.kie.server.api.model.instance.TaskInstance;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.QueryServicesClient;
import org.kie.server.client.UserTaskServicesClient;


public class TaskHelper {

	public static void main(String[] args) {
		TaskHelper task = new TaskHelper();
		task.startTask();
//		task.completeTask();
		
	}
	


	

	
	public void startTask() {
		body util = new body();
		KieServicesClient kieServicesClient = util.getKieServicesClient();
		UserTaskServicesClient userClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		QueryServicesClient queryClient = kieServicesClient.getServicesClient(QueryServicesClient.class);
		TaskQueryFilterSpec filterSpec = new TaskQueryFilterSpec();
		List<TaskInstance> taskList = queryClient.findHumanTasksWithFilters("jbpmHumanTasksWithUser", filterSpec, 0, 10);
		for (TaskInstance task : taskList) {
		    System.out.println("Task ID: " + task.getId() + ", Name: " + task.getName() + ", Status: " + task.getStatus());
		}

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