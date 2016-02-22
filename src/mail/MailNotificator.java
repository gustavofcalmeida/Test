package mail;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Gustavo de Farias
 */
public class MailNotificator {

	private String destinatario;
	private Properties p;
	private Authenticator au;

	/**
	 * @param destinatario
	 * @throws VerifierException
	 */
	public MailNotificator(String destinatario) {

		this.destinatario = destinatario;

		this.p = new Properties();
		try {
			p.load(new FileInputStream("./config/conta.config"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.au = new SMTPAuthenticator();
	}

	/**
	 * @param subject
	 * @param message
	 * @throws VerifierException
	 */
	public void sendEmail(String subject, String message) {

		Session session = Session.getDefaultInstance(this.p, this.au);
		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
					this.destinatario));

			msg.setSubject(subject);
			msg.setText(message);

			msg.setSentDate(new Date());
			
			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}