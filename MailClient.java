
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
    private MailItem lastEmail;

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
        lastEmail = server.getNextMailItem(user);
        return server.getNextMailItem(user);
    }

    public void printNextMailItem()
    {
         lastEmail = server.getNextMailItem(user);
        
        if( lastEmail != null)
        {
            lastEmail.print();
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

    public void howManyMailItems()
    {

        int numberOfMails = server.howManyMailItems(user);
        System.out.println("Numero de emails en el servidor: " + numberOfMails);
    }

    public void getNextMailItemAndAutorespond()
    {
        MailItem email = server.getNextMailItem(user);
        if (email != null)
        {
            String to = email.getFrom();
            String subject = "RE: " + email.getSubject();
            String message = "Estoy de vacaciones \n" + email.getMessage();
            MailItem autoReply = new MailItem(to, user, subject, message);
            server.post(autoReply);
        }

        
    }
    public void printLastEmail()
    {
        
       
        if( lastEmail == null)
        {
            System.out.println("No se ha recibido ningun mensaje");
        }
        else {
            lastEmail.print();
        }
        
    }
}
