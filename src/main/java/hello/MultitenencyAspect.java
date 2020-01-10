package hello;

import javax.persistence.EntityManager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.eclipse.persistence.config.EntityManagerProperties;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MultitenencyAspect
{
    @Around("execution(* javax.persistence.EntityManagerFactory.*(..))")
    public Object invocate(ProceedingJoinPoint joinPoint) throws Throwable
    {
        final Object result = joinPoint.proceed();

        if (result instanceof EntityManager)
        {
            EntityManager em = (EntityManager) result;

            final String tenantId = TenantContext.getTenant();
            //            LOG.debug("Set EntityManager property for tenant {}.", tenantId);
            em.setProperty(EntityManagerProperties.MULTITENANT_PROPERTY_DEFAULT, tenantId);

            return em;
        }
        return result;
    }
}
