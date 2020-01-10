package hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.eclipse.persistence.config.EntityManagerProperties;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class ManhTransactionManager extends JpaTransactionManager
{
    public ManhTransactionManager(EntityManagerFactory emf)
    {
        super(emf);
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition)
    {
        super.doBegin(transaction, definition);

        final EntityManagerHolder emHolder = (EntityManagerHolder) TransactionSynchronizationManager.getResource(getEntityManagerFactory());
        final EntityManager em = emHolder.getEntityManager();
        final String tenantId = TenantContext.getTenant();

        if (tenantId != null)
        {
            em.setProperty(EntityManagerProperties.MULTITENANT_PROPERTY_DEFAULT, tenantId);
        }
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status)
    {
        try
        {
            super.doCommit(status);
        }
        catch (TransactionSystemException e)
        {
            throw new RuntimeException("Could not commit JPA transaction");
        }
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status)
    {
        try
        {
            super.doRollback(status);
        }
        catch (TransactionSystemException e)
        {
            throw new RuntimeException("Could not rollback JPA transaction");
        }
    }

}
