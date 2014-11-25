
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // instance variables - replace the example below with your own
    private MailServer server;
    private String user;

    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer newServer, String newUser)
    {
       server = newServer;
       user = newUser;
    }

    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    public void printNextMailItem()
    {
        MailItem itemAux = server.getNextMailItem(user);
        
        if( itemAux != null)
        {
            itemAux.print();
        } else
        {
            System.out.println("No hay mensaje en la bandeja");
        }
        
        
        
    }
    public void sendMailItem( String who, String message)
    {
        MailItem email = new MailItem (user, who, message);
        server.post(email);
    }
    
}
