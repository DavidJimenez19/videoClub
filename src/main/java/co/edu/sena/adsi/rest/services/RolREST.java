
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Rol;
import co.edu.sena.adsi.jpa.sessions.RolFacade;
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
@Path("roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RolREST {
    
    @EJB
    private RolFacade rolEJB;
    
    /**
     * Obtiene todos los roles
     * @return lista de roles
     */
    @GET
    public List<Rol> findAll(){
        return rolEJB.findAll();
    }
    
    /**
     * Busca rol por su id
     * @param id
     * @return rol
     */
    @GET
    @Path("{id}")
    public Rol findById(@PathParam("id") String id){
        return rolEJB.find(id);
    }
    
    /**
     * Crear un rol
     * @param rol 
     */
    @POST
    public void create(Rol rol){
        rolEJB.create(rol);
    }
    
    /**
     * Edita un rol
     * @param id
     * @param rol 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Rol rol){
        rolEJB.edit(rol);
    }
}
