/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import eventos.Mensaje;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;

/**
 *
 * @author Leobar37
 */
public class commandMsj {

    public static void exex(JDA bot, Message msj, String argumentos[]) {
        if (argumentos.length < 1) {
            msj.getChannel().sendMessage("igual nuca te va a querer por gil").queue();
        } else {
            String cmd = argumentos[0];

            switch (cmd) {
                case "motivame":
                    
                    int num = (int) (Math.random() * Mensaje.men.tamaño());
                    if(Mensaje.men.Buscar(num) instanceof String){
                       msj.getChannel().sendMessage((String) Mensaje.men.Buscar(num)).queue();
                    }
               
                    break;
                case "sig": 
                   String cmd2 = argumentos[1];
                   String  jo = "vaya nombre mas raro, suena a otaku";
                     if(cmd2.equalsIgnoreCase("jhonatan")){
                        msj.getChannel().sendMessage(jo).queue();  
                     }
                  break;         
                case "gr":
                    String g1 = "esto ya no es un insulto, insultar es malo";
                    String g2 ="me llegas al pincho";
                    String g3 ="rodrigo me llega al pincho";
                    String g4 = "no me insultes soy otaku :(";
                  
                    String cmd3 = argumentos[1];
                    int n = Integer.parseInt(cmd3);
                  switch(n){
                      case 1:
                         msj.getChannel().sendMessage(g1).queue();  
                         break;
                      case 2:
                          msj.getChannel().sendMessage(g2).queue();
                          break;
                      case 3:
                          msj.getChannel().sendMessage(g3).queue();  
                          break;
                      case 4:
                            msj.getChannel().sendMessage(g4).queue(); 
                            break;
                  }
                  break;
                case "ch": 
                    int num2 = (int) (Math.random() * Mensaje.chiste.tamaño());
                    if(Mensaje.chiste.Buscar(num2) instanceof String){
                       msj.getChannel().sendMessage((String) Mensaje.chiste.Buscar(num2)).queue();
                    }
                    break;  
                case "bn":
                    String bn = "buenas noches bb espero duermas bien\n"+
                                 "te amo bb sere tuya para siempre";
                     msj.getChannel().sendMessage(bn).queue();
                 break;
                case "p":  
                   String po= "los pollitos se apoderan del mundo";
                     msj.getChannel().sendMessage(po).queue();
                    break;
                case "s":
                    String po1 = "se molesto?";
                    msj.getChannel().sendMessage(po1).queue();
                    break;
                case "activate":
                    String bots="ya me conecte espero poder solucionar tus problemas";
                       for (int i = 0; i < 10; i++) {
                        msj.getChannel().sendMessage(bots).queue();
                    }
                      break;
                case "hola":
                    String hola = ":) soy un bot no tengo sentimientos :o";
                     msj.getChannel().sendMessage(hola).queue();
            }  
           
        }

    }
}
