/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasAkhir.PenjualanSapi;

import TugasAkhir.PenjualanSapi.exceptions.NonexistentEntityException;
import TugasAkhir.PenjualanSapi.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author GF63-9SC
 */
public class SapiJpaController implements Serializable {

    public SapiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TugasAkhir_PenjualanSapi_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public SapiJpaController() {
    }
    
    public void create(Sapi sapi) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sapi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSapi(sapi.getId()) != null) {
                throw new PreexistingEntityException("Sapi " + sapi + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sapi sapi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sapi = em.merge(sapi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sapi.getId();
                if (findSapi(id) == null) {
                    throw new NonexistentEntityException("The sapi with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sapi sapi;
            try {
                sapi = em.getReference(Sapi.class, id);
                sapi.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sapi with id " + id + " no longer exists.", enfe);
            }
            em.remove(sapi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sapi> findSapiEntities() {
        return findSapiEntities(true, -1, -1);
    }

    public List<Sapi> findSapiEntities(int maxResults, int firstResult) {
        return findSapiEntities(false, maxResults, firstResult);
    }

    private List<Sapi> findSapiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sapi.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Sapi findSapi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sapi.class, id);
        } finally {
            em.close();
        }
    }

    public int getSapiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sapi> rt = cq.from(Sapi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
