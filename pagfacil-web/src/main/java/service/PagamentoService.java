package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import resource.PagamentoResource;
import util.JacksonJavaTimeConfiguration;

@ApplicationPath("/v1")
public class PagamentoService extends Application {
	public PagamentoService() {
	    BeanConfig conf = new BeanConfig();
	    conf.setTitle("PagFacil API");
	    conf.setDescription("Pagamentos Rápidos");
	    conf.setVersion("1.0.0");
	    conf.setHost("localhost:8080");
	    conf.setBasePath("/pagfacil/v1");
	    conf.setSchemes(new String[] { "http" });
	    conf.setResourcePackage("br.gov.caixa.pagfacil");
	    conf.setScan(true);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
	    Set<Class<?>> resources = new HashSet<>();
	    resources.add(JacksonJavaTimeConfiguration.class);
	    resources.add(PagamentoResource.class);
	       
	    //classes do swagger...
	    resources.add(ApiListingResource.class);
	    resources.add(SwaggerSerializers.class);
	    return resources;
	 }
}
