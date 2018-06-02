package bot;

import java.io.IOException;

import org.junit.Test;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.PGPException;


public class PGPTest {
	@Test
	public void generarRSA() throws Exception {
//		PGP pgp = new PGP();
		String user = "Jorge";
		String path = "src/main/resources/pgp.keystore";
		String pass = "pass1234";
		String privatePass = "1234";

//		KeyStore ks = new KeyStore(path, pass);
//
//		PGP.GenerateKeyPairRSA(user, privatePass);
////		pgp.ExportKey(path, user, pass);
//
//		boolean passwordIsCorrect = KeyStore.checkPassword(path, pass);
//		System.out.println(passwordIsCorrect);
//
//		boolean keyContainsPublic = ks.containsPublicKey(user);
//		System.out.println(keyContainsPublic);
//
//		boolean keyContainsPrivate = ks.containsPrivateKey(user);
//		System.out.println(keyContainsPrivate);

//		String msgEnc = PGP.encrypt("sarasa cosmica", user);
//
//		System.out.println(msgEnc);
		
		String msgEnc = "hQEMA5J1TAqWL8k1AQf/Z22fGbPQMGFFVQDUI7x2X0AuLVhNbBnQb1fOkZB5/Il0CraHG5C3qOOqvfYmrp0+vqlAw65BWZMwB2Pv5scjfkBh71tQPKzmIXKY2bvt4W89WkxwFQ4jtfVFiot1/MWJSgqP8g4e4w8QznYpOP/sjnxJMYhfIxv/g47T9ueu82m+OUHUQyFHxNPNv+twmEErK5VEk2p1xsqK6RbcxcnuQoxFWjn5GHyyqzsZNL6vQE2oSXDEBEFF1SuvgZ273M8NL9+m0IfUGna3LGd2uuWLYd4c2xAmZZkpWHWi0FffgSb6/Y/A+7AqyBQosIoYm0ZsCMo+WYwCsQGystCSy0d9XckvrgnYuQl3rBgtIX5iEdIpGg/9qqjt2hbz7lp+HAMUKqF+OTIbKVtUHn5ssMmn0xw==lSue";

		System.out.println(msgEnc);

		System.out.println(PGP.decrypt(msgEnc, user));

	}
}
