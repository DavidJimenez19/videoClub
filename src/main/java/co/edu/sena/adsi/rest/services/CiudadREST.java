package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Ciudad;
import co.edu.sena.adsi.jpa.sessions.CiudadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ruberr
 */
@Path("ciudades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CiudadREST {
    
    @EJB
    private CiudadFacade ciudadEJB;
    
    /**
     * Obtiene todas las ciudades
     * @return lista de ciudades
     */
    @GET
    public List<Ciudad> findAll(){
        return ciudadEJB.findAll();
    }
    
    /**
     * Busca ciudad por su id
     * @param id
     * @return ciudad
     */
    @GET
    @Path("{id}")
    public Ciudad findById(@PathParam("id") Integer id){
        return ciudadEJB.find(id);
    }
    
    /**
     * Crear una ciudad
     * @param ciudad 
     */
    @POST
    public void create(Ciudad ciudad){
        ciudadEJB.create(ciudad);
    }
    
    /**
     * Edita una ciudad
     * @param id
     * @param ciudad 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Ciudad ciudad){
        ciudadEJB.edit(ciudad);
    }
        
}
