package vlad.bartolomei.package_burst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PackageBurstApplication {

	public static void main(String[] args) {
		Presentation presentation = new Presentation();
		SpringApplication.run(PackageBurstApplication.class, args);
	}

}
