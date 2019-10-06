package examples.webcomponents.render;

import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;

public class TemplateLoaders {

    public TemplateLoader stringLoader(String templateName, String content) {
        final StringTemplateLoader loader = new StringTemplateLoader();
        loader.putTemplate(templateName, content);
        return loader;
    }
}
