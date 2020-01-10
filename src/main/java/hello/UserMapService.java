package hello;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserMapService
{

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void saveMe()
    {

    }
}
