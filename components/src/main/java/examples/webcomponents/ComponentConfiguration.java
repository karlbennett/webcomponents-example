package examples.webcomponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.PostConstruct;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.http.MediaType.parseMediaType;

@Configuration
public class ComponentConfiguration implements WebMvcConfigurer {

    private static final String APPLICATION_JAVASCRIPT = "application/javascript";

    @Autowired
    private FreeMarkerViewResolver viewResolver;

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
            .favorPathExtension(true)
            .favorParameter(false)
            .ignoreAcceptHeader(false)
            .defaultContentType(TEXT_HTML)
            .mediaType("js", parseMediaType(APPLICATION_JAVASCRIPT))
            .mediaType("json", APPLICATION_JSON);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new InternalResourceViewResolver());
        registry.enableContentNegotiation(new MappingJackson2JsonView());
    }

    @PostConstruct
    public void setup() {
        viewResolver.setContentType(APPLICATION_JAVASCRIPT);
    }
}
