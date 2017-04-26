package dao;

import entity.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by harlock on 23/04/17.
 */
@Repository
public class PessoaDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    public void setEntityManager(
            EntityManager entityManager) {
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("franquiaPu");
        this.entityManager = entityManager;//= factory.createEntityManager();
    }
    @Transactional(readOnly=true)
    public List<Pessoa> retornaTodos(){
        String jpql = "SELECT c from Pessoa c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<Pessoa> pessoas = (List<Pessoa>) query.getResultList();
        return pessoas;
    }

    @Transactional(readOnly=true)
    public List<Pessoa> retornaTodos(int idPessoa){
        String jpql = "SELECT c from Pessoa c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<Pessoa> pessoas = (List<Pessoa>) query.getResultList();
        return pessoas;
    }
    @Transactional(readOnly=true)
    public Pessoa retornaEspecifico(int id){
        String jpql = "SELECT c from Pessoa c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        Pessoa pessoas = (Pessoa) query.getSingleResult();
        return pessoas;
    }
    @Transactional
    public Pessoa inserirPessoa(Pessoa Pessoa){
        entityManager.persist(Pessoa);
        return Pessoa;
    }
    @Transactional
    public Pessoa updatePessoa(Pessoa Pessoa){
        entityManager.merge(Pessoa);
        return Pessoa;
    }
    @Transactional
    public Pessoa deletePessoa(Pessoa Pessoa){
        entityManager.remove(Pessoa);
        return Pessoa;
    }
}
