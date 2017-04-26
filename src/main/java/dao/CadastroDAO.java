package dao;

import entity.Cadastro;
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
public class CadastroDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional(readOnly=true)
    public List<Cadastro> retornaTodos(){
        String jpql = " SELECT c from Cadastro c order by c.ID_CADASTRO";
        Query query = entityManager.createQuery(jpql);
        List<Cadastro> cadastros = (List<Cadastro>) query.getResultList();
        return cadastros;
    }
    @Transactional(readOnly=true)
    public List<Cadastro> retornaTodos(int ID_CADASTRO){
        String jpql = " SELECT c from Cadastro c order by c.ID_CADASTRO" +
                "WHERE c.ID_CADASTRO = :ID_CADASTRO";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("ID_CADASTRO", ID_CADASTRO);
        List<Cadastro> cadastro = (List<Cadastro>) query.getResultList();
        return cadastro;
    }
    @Transactional(readOnly=true)
    public Cadastro retornaEspecifico(int id){
        String jpql = " SELECT c from Cadastro c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        Cadastro cadastro = (Cadastro) query.getSingleResult();
        return cadastro;
    }
    @Transactional
    public Cadastro inserirCadastro(Cadastro cadastro){
        entityManager.persist(cadastro);
        return cadastro;
    }
    @Transactional
    public Cadastro updateCadastro(Cadastro cadastro){
        entityManager.merge(cadastro);
        return cadastro;
    }
    @Transactional
    public Cadastro deleteCadastro(Cadastro cadastro){
        entityManager.remove(cadastro);
        return cadastro;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
