/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;

public class PingCommand {
 
  public static void exec(JDA bot, Message msj, String argumentos[]){
   int ping = (int) bot.getGatewayPing();
            String  ad=   msj.getAuthor().getName();
          
    msj.getChannel().sendMessage("ping resultado: "+ping+": peticion realizada por: "+ad).queue();
  }
}
