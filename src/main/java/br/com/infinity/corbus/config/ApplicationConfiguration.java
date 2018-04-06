package br.com.infinity.corbus.config;

import br.com.infinity.corbus.utils.LocalDateConversor;
import br.com.infinity.corbus.utils.LocalDateDeserializer;
import br.com.infinity.corbus.utils.LocalDateSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer {

    @Value("${date.format}")
    private String dateFormat;

    @Value(("${spring.thymeleaf.prefix}"))
    private String prefix;

    @Value("${spring.thymeleaf.suffix}")
    private String sufix;

    @Value("${spring.thymeleaf.mode}")
    private String mode;

    @Bean
    @Primary
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateConversor(dateFormat));
    }


    @Bean
    public ITemplateResolver templateResolver(){

        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix(prefix);
        resolver.setSuffix(sufix);
        resolver.setCacheable(false);
        resolver.setTemplateMode(mode);
        resolver.setOrder(0);

        return resolver;
    }
}
