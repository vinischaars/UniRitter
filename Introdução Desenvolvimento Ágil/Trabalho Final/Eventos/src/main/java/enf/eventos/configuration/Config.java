package enf.eventos.configuration;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import enf.eventos.factory.CalcularDescontoFactory;

@Configuration
public class Config {
    @Bean
    public ServiceLocatorFactoryBean calculadoraDescontoFactory() {
        ServiceLocatorFactoryBean locatorFactoryBean = new ServiceLocatorFactoryBean();
        locatorFactoryBean.setServiceLocatorInterface(CalcularDescontoFactory.class);
        return locatorFactoryBean;
    }
}