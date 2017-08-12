package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Departamento;
import co.edu.sena.adsi.jpa.sessions.DepartamentoFacade;
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
@Path("departamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartamentoREST {
    
    @EJB
    private DepartamentoFacade departamentoEJB;
    
    /**
     * Obtiene todos los departamento
     * @return lista de departamento
     */
    @GET
    public List<Departamento> findAll(){
        return departamentoEJB.findAll();
    }
    
    /**
     * Busca departamento por su id
     * @param id
     * @return departamento
     */
    @GET
    @Path("{id}")
    public Departamento findById(@PathParam("id") Integer id){
        return departamentoEJB.find(id);
    }
    
    /**
     * Crear un departamento
     * @param departamento 
     */
    @POST
    public void create(Departamento departamento){
        departamentoEJB.create(departamento);
    }
    
    /**
     * Edita un departamento
     * @param id
     * @param departamento 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Departamento departamento){
        departamentoEJB.edit(departamento);
    }
}
