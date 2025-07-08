public class MailService {
    public static void SendMail(EBook book, String email) {
        System.out.println("Shipping " + book.getTitle() + " to address: " + email);
    }
}
