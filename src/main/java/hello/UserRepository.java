package hello;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.config.EntityManagerProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Component
public class UserRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User save(User user)
    {
        return entityManager.merge(user);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User findOne(Long pk)
    {
        return entityManager.find(User.class, pk);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(Long id)
    {
        User entity = findOne(id);
        if (entity != null)
        {
            entityManager.remove(entity);
        }
    }

//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<User> getAll()
    {
        final String tenantId = TenantContext.getTenant();
        //            LOG.debug("Set EntityManager property for tenant {}.", tenantId);
        entityManager.setProperty(EntityManagerProperties.MULTITENANT_PROPERTY_DEFAULT, tenantId);
        String str = "select obj from User obj";
        Query query = entityManager.createQuery(str);

        return query.getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(User entity)
    {
        Assert.notNull(entity, "The entity must not be null!");
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Object save(List<User> addressTypeEntity)
    {
        List<User> result = new ArrayList<User>();

        addressTypeEntity.forEach(entity -> result.add(save(entity)));
        return result;
    }
}
