package mail;

public class Main {
	public static void main(String[] args) {

		MailNotificator mn = new MailNotificator("gustavofarias@gmail.com");
		mn.sendEmail("Teste subject", "Test message.");
	}
}
