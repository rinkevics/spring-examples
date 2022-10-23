package lv.kingfisher.db;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
@Scope("prototype")
public class DBBean {

    @PersistenceContext
    private EntityManager entityManager;

    public String method() {
        var query = entityManager.createQuery("SELECT e FROM AnEntity e");

        var list = query.getResultList();
        if (list.isEmpty()) {
            var entity = new AnEntity("jpa entity");
            entityManager.persist(entity);
            list = query.getResultList();
        }
        return "bean/" + ((AnEntity) list.get(0)).name;
    }
}
