
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.TipoDocumento;
import co.edu.sena.adsi.jpa.sessions.TipoDocumentoFacade;
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
@Path("tipos_documentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoDocumentoREST {
    
    @EJB
    private TipoDocumentoFacade tipoDocumentoEJB;
    
    /**
     * Obtiene todas las tipos de documentos
     * @return lista de tipos de documentos
     */
    @GET
    public List<TipoDocumento> findAll(){
        return tipoDocumentoEJB.findAll();
    }
    
    /**
     * Busca tipo documento por su id
     * @param id
     * @return tipoDocumento
     */
    @GET
    @Path("{id}")
    public TipoDocumento findById(@PathParam("id") Integer id){
        return tipoDocumentoEJB.find(id);
    }
    
    /**
     * Crear un tipoDocumento
     * @param tipoDocumento 
     */
    @POST
    public void create(TipoDocumento tipoDocumento){
        tipoDocumentoEJB.create(tipoDocumento);
    }
    
    /**
     * Edita un tipoDocumento
     * @param id
     * @param tipoDocumento 
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, TipoDocumento tipoDocumento){
        tipoDocumentoEJB.edit(tipoDocumento);
    }
}
