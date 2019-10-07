package examples.webcomponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;

@Configuration
public class ComponentConfiguration {

    @Autowired
    private FreeMarkerViewResolver viewResolver;

    @PostConstruct
    public void setup() {
        viewResolver.setContentType("application/javascript");
    }
}
