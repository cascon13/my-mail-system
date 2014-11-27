
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
    public MailClient(MailServer server, String user)
    {
       this.server = server;
       this.user = user;
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
    public void sendMailItem( String who, String message, String subject)
    {
        MailItem email = new MailItem (user, who, message, subject);
        server.post(email);
    }
    
    public int howManyMailItems()
    {
        return server.howManyMailItems(user);
    }
    public void getNextMailItemAndAutorespond()
    {
        MailItem email = server.getNextMailItem(user);
        String from = email.getFrom();
        String subject = "RE: " + email.getSubject();
        String message = "Estoy de vacaciones \n" + email.getMessage();
        MailItem autoReply = new MailItem(user, from, subject, message);
        server.post(autoReply);
    }
}
