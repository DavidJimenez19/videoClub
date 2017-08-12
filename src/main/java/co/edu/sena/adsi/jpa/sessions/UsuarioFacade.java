package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Usuario;
import co.edu.sena.adsi.jpa.entities.Usuario_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ruberr
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "co.edu.sena.adsi_Adsi1261718_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    /**
     * Buscar usuario por email
     * @param email
     * @return 
     */
    public Usuario findByEmail(String email){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> tercero = cq.from(Usuario.class);
        
        cq.where(cb.equal(tercero.get(Usuario_.email), email));
        TypedQuery<Usuario> tq = getEntityManager().createQuery(cq);
        
        try {
            return (Usuario) tq.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch(NoResultException e){
            return null;
        }
    }
    
    /**
     * Buscar usuario por numDocumento
     * @param numDocumento
     * @return 
     */
    public Usuario findByNumDocumento(String numDocumento){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> tercero = cq.from(Usuario.class);
        
        cq.where(cb.equal(tercero.get(Usuario_.numDocumento), numDocumento));
        TypedQuery<Usuario> tq = getEntityManager().createQuery(cq);
        
        try {
            return (Usuario) tq.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch(NoResultException e){
            return null;
        }
    }
    
    
}
