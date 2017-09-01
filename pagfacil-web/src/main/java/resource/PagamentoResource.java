package resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import pojo.Pagamento;
import pojo.Transacao;

@Api
@Path("/pagamentos")
public class PagamentoResource {
	Pagamento pagamento = new Pagamento();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criarPagamento(Transacao transacao) throws URISyntaxException {
		return Response.created(new URI("/pagamentos/" + pagamento.getId())).entity(pagamento)
			.type(MediaType.APPLICATION_JSON).build();
	}
	 
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmarPagamento(@PathParam("id") Integer id) {
	  //aqui, c�digo que confirma pagamento...
	  return Response.ok().entity(pagamento).build();
	}
	 
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelarPagamento(@PathParam("id") Integer id) {
	  //aqui, c�digo que cancela pagamento...
	  return Response.ok().entity(pagamento).build();
	}
}
