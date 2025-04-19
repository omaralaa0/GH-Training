package tasksAPI;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;


public class body {

	String URL = "http://localhost:8080/kie-server/services/rest/server";
	String USERNAME = "wbadmin";
	String PASSWORD = "wbadmin";

	public KieServicesClient getKieServicesClient() {
		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(URL, USERNAME, PASSWORD);
		config.setMarshallingFormat(MarshallingFormat.JSON);
		return KieServicesFactory.newKieServicesClient(config);
	}

}