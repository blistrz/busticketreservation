/*
 * 
 */
public abstract class ClassFactory {
    public abstract InterfaceA getObject(String ObjectType);
    public abstract InterfaceB getObject2(String Objtype);
}

class JframeFactory extends ClassFactory
{
    public InterfaceA getObject(String ObjectType){
        if(ObjectType == null)
    {
        return null;
    }
    if(ObjectType.equalsIgnoreCase("login")){
        return new LoginDetail();
    } 
    else if(ObjectType.equalsIgnoreCase("payment"))
    {
        return new PaymentDetails();
    } 
    else if(ObjectType.equalsIgnoreCase("reservation"))
    {
        return new ReservationDetails();
    }
    
    return null;
    }
    
    
    public InterfaceB getObject2(String Objtype)
    {
     if(Objtype == null)
    {
        return null;
    }
    if(Objtype.equalsIgnoreCase("login")){
        return new LoginDetail();
    } 
    else if(Objtype.equalsIgnoreCase("payment"))
    {
        return new PaymentDetails();
    } 
    else if(Objtype.equalsIgnoreCase("reservation"))
    {
        return new ReservationDetails();
    }
    else if(Objtype.equalsIgnoreCase("useraccount"))
    {
        return new UserAccount();      
    }

    return null;
    }
}