package dao;

import entity.FichaDeSelecao;
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
public class FichaDeSelecaoDAO {
    @PersistenceContext
    protected EntityManager entityManager;
    @Transactional(readOnly=true)
    public List<FichaDeSelecao> retornaTodos(){
        String jpql = " SELECT c from FichaDeSelecao c " +
                "INNER JOIN c.Franquia F WEHRE F.ID_FRANQUIA = C.ID_FRANQUIA " +
                "order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<FichaDeSelecao> acompanhamentos = (List<FichaDeSelecao>) query.getResultList();
        return acompanhamentos;
    }
    @Transactional(readOnly=true)
    public List<FichaDeSelecao> retornaTodos(int ID_FICHADESELECAO){
        String jpql = " SELECT c from FichaDeSelecao c " +
                "INNER JOIN c.Franquia F WEHRE F.ID_FRANQUIA = C.ID_FRANQUIA " +
                "WHERE c.ID_FICHADESELECAO = :ID_FICHADESELECAO" +
                "order by c.ID_FICHADESELECAO";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("ID_CADASTRO", ID_FICHADESELECAO);
        List<FichaDeSelecao> acompanhamentos = (List<FichaDeSelecao>) query.getResultList();
        return acompanhamentos;
    }
    @Transactional(readOnly=true)
    public FichaDeSelecao retornaEspecifico(int id){
        String jpql = " SELECT c from FichaDeSelecao c order by c.ID_FRANQUIA";
        Query query = entityManager.createQuery(jpql);
        FichaDeSelecao acompanhamentos = (FichaDeSelecao) query.getSingleResult();
        return acompanhamentos;
    }
    @Transactional
    public FichaDeSelecao inserirFichaDeSelecao(FichaDeSelecao fichaDeSelecao){
        entityManager.persist(fichaDeSelecao);
        return fichaDeSelecao;
    }
    @Transactional
    public FichaDeSelecao updateFichaDeSelecao(FichaDeSelecao fichaDeSelecao){
        entityManager.merge(fichaDeSelecao);
        return fichaDeSelecao;
    }
    @Transactional
    public FichaDeSelecao deleteFichaDeSelecao(FichaDeSelecao fichaDeSelecao){
        entityManager.remove(fichaDeSelecao);
        return fichaDeSelecao;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
