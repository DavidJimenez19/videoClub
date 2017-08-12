package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Usuario;
import co.edu.sena.adsi.jpa.sessions.UsuarioFacade;
import co.edu.sena.adsi.rest.auth.DigestUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ruberr
 */
@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioREST {

    @EJB
    private UsuarioFacade usuarioEJB;

    /**
     * Obtiene todos los usuarioes
     *
     * @return lista de usuarios
     */
    @GET
    @RolesAllowed({"ADMIN"})
    public List<Usuario> findAll() {
        return usuarioEJB.findAll();
    }

    /**
     * Busca usuario por su id
     *
     * @param id
     * @return usuario
     */
    @GET
    @Path("{id}")
    public Usuario findById(@PathParam("id") Integer id) {
        return usuarioEJB.find(id);
    }

    /**
     * Crear un usuario
     *
     * @param usuario
     * @return
     */
    @POST
    public Response create(Usuario usuario) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {

            if (usuarioEJB.findByEmail(usuario.getEmail()) == null) {
                if (usuarioEJB.findByNumDocumento(usuario
                        .getNumDocumento()) == null) {

                    usuario.setPassword(
                            DigestUtil
                                    .cifrarPassword(usuario.getPassword()));

                    usuarioEJB.create(usuario);

                    return Response.status(Response.Status.CREATED)
                            .entity(gson.toJson("El usuario se registró correctamente"))
                            .build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(gson.toJson("El Número de documento ya éxiste!."))
                            .build();
                }

            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("El email ya éxiste!."))
                        .build();
            }

        } catch (Exception e) {
            System.out.println("Err: " + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el usuario!."))
                    .build();
        }

    }

    /**
     * Edita un usuario
     *
     * @param id
     * @param usuario
     * @return 
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Usuario usuario) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            usuarioEJB.edit(usuario);
            return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("El usuario se actualizó correctamente"))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al actualizar el usuario!."))
                    .build();
        }
    }

}
