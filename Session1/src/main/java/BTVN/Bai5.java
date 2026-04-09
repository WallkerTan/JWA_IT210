package BTVN;

import org.example.config.AppConfig;
import org.example.model.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Bai5 {
        public static void main(String[] args) {

            ApplicationContext context =
                    new AnnotationConfigApplicationContext(AppConfig.class);

            SystemConfig config = context.getBean(SystemConfig.class);

            System.out.println("Branch: " + config.getBranchName());
            System.out.println("Opening Hour: " + config.getOpeningHour());
        }
}
