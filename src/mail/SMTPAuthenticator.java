package mail;

import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.swing.JOptionPane;

/**
 * 
 * @author Gustavo de Farias
 */
public class SMTPAuthenticator extends Authenticator {

	/**
	 * 
	 */
	private PasswordAuthentication pa;

	/**
	 * @throws VerifierException
	 */
	public SMTPAuthenticator() {

		Properties p = new Properties();
		try {
			p.load(new FileInputStream("./config/conta.config"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		String senha = JOptionPane.showInputDialog(null,
				"Entre com a senha para: " + p.getProperty("email") + ".",
				"Notificação por e-mail", JOptionPane.QUESTION_MESSAGE);

		if (senha == null) {
			senha = "";
		}

		this.pa = new PasswordAuthentication(p.getProperty("email"), senha);
	}

	/**
	 * @see javax.mail.Authenticator#getPasswordAuthentication()
	 */
	public PasswordAuthentication getPasswordAuthentication() {

		return this.pa;
	}
}