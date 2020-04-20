package botDiscord;
import eventos.Inicio;
import eventos.Mensaje;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.*;



public class botPollito {
    public static JDA bot;
    public static void main(String[] args) throws LoginException {
       bot = new JDABuilder(AccountType.BOT)
               .setToken("NjQyODYwNzg0NzkxMDYwNDgy.XcdF_w.RBSJflgVp6yxezqComnBgR4jAQk")
               .build();
        bot.addEventListener(new Mensaje());

    }
  
}
