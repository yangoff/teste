package dao;

import entity.Acompanhamento;
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
public class AcompanhamentoDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional(readOnly=true)
    public List<Acompanhamento> retornaTodos(){
        String jpql = " SELECT c from Acompanhamento c order by c.id_acompanhamento" +
                " INNER JOIN c.Franquia F F.ID_FRANQUIA = c.Franquia.ID_FRANQUIA";
        Query query = entityManager.createQuery(jpql);
        List<Acompanhamento> acompanhamentos = (List<Acompanhamento>) query.getResultList();
        return acompanhamentos;
    }
    @Transactional(readOnly=true)
    public List<Acompanhamento> retornaTodos(int idFranqueado){
        String jpql = " SELECT c from Acompanhamento c order by c.id_acompanhamento" +
                " WHERE c.id_acompanhamento = :id_acompanhamento";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("id_acompanhamento", idFranqueado);
        List<Acompanhamento> acompanhamentos = (List<Acompanhamento>) query.getResultList();
        return acompanhamentos;
    }
    @Transactional(readOnly=true)
    public Acompanhamento retornaEspecifico(int id){
        String jpql = " SELECT c from Acompanhamento c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        Acompanhamento acompanhamentos = (Acompanhamento) query.getSingleResult();
        return acompanhamentos;
    }
    @Transactional
    public Acompanhamento inserirAcompanhamento(Acompanhamento acompanhamento){
        entityManager.persist(acompanhamento);
        return acompanhamento;
    }
    @Transactional
    public Acompanhamento updateAcompanhamento(Acompanhamento acompanhamento){
        entityManager.merge(acompanhamento);
        return acompanhamento;
    }
    @Transactional
    public Acompanhamento deleteAcompanhamento(Acompanhamento acompanhamento){
        entityManager.remove(acompanhamento);
        return acompanhamento;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
