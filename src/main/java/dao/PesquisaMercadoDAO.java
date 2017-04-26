package dao;

import entity.PesquisaDeMercado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by harlock on 23/04/17.
 */
@Repository
public class PesquisaMercadoDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly=true)
    public List<PesquisaDeMercado> retornaTodos(){
        String jpql = "SELECT c from PesquisaMercado c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<PesquisaDeMercado> pesquisamercados = (List<PesquisaDeMercado>) query.getResultList();
        return pesquisamercados;
    }

    @Transactional(readOnly=true)
    public List<PesquisaDeMercado> retornaTodos(int idFranqueado){
        String jpql = "SELECT c from PesquisaMercado c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<PesquisaDeMercado> pesquisamercados = (List<PesquisaDeMercado>) query.getResultList();
        return pesquisamercados;
    }
    @Transactional(readOnly=true)
    public PesquisaDeMercado retornaEspecifico(int id){
        String jpql = "SELECT c from PesquisaMercado c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        PesquisaDeMercado pesquisamercados = (PesquisaDeMercado) query.getSingleResult();
        return pesquisamercados;
    }
    @Transactional
    public PesquisaDeMercado inserirPesquisaMercado(PesquisaDeMercado PesquisaMercado){
        entityManager.persist(PesquisaMercado);
        return PesquisaMercado;
    }
    @Transactional
    public PesquisaDeMercado updatePesquisaMercado(PesquisaDeMercado PesquisaMercado){
        entityManager.merge(PesquisaMercado);
        return PesquisaMercado;
    }
    @Transactional
    public PesquisaDeMercado deletePesquisaMercado(PesquisaDeMercado PesquisaMercado){
        entityManager.remove(PesquisaMercado);
        return PesquisaMercado;
    }
}
