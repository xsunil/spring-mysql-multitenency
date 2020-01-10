package hello;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class CustomRoutingDataSource {

    protected void determineCurrentLookupKey()
    {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attr != null)
        {
            String tenantId = attr.getRequest().getParameter("tenantId");
            if (tenantId == null || tenantId.length() == 0)
            {
                TenantContext.setTenant("DEFAULT");
            }
            else
            {
                TenantContext.setTenant(tenantId);
            }
        }
        else
        {
            TenantContext.setTenant("DEFAULT");
        }
    }
}