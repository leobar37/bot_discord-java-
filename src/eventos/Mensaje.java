/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import botDiscord.botPollito;
import comandos.PingCommand;
import comandos.commandMsj;

import java.util.Arrays;
import java.util.List;

import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Mensaje extends ListenerAdapter {

    public static final String pref = "!po:";
    public static ListasAux.ListaEnlazada men;
    public static ListasAux.ListaEnlazada chiste;
    //lee todos los mensajes del bot
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        /*cosas a verificar:
       1) si el que envio el mensaje es un bot si es asi que no siga ningun proceso
       2) si el mensaje empieza con el prefijo del bot
         */
        //un:
        if (e.getMessage().getAuthor().isBot()) {
            return;
        }
        //si cualquier palabra es diferente al comando especificado este no es evaluado    
        if (!e.getMessage().getContentRaw().startsWith(pref)) {
            return;
        }
        String argumentos[] = e.getMessage().getContentRaw().substring(pref.length()).trim().split(" +");
       //si los argumentos son menores a uno significa que solo hay el prefijo
        if (argumentos.length < 1) {
            return;
        }
        //comando a ejecutar
             //!po: matriz lucas
        String cmd = argumentos[0].toLowerCase(); //matriz
        //argumentos del comando
        /*
        copyfoRange(arreglo,comienzo,final);
        */
        //resto de los argumentos a ejecutar
        
        argumentos = Arrays.copyOfRange(argumentos, 1, argumentos.length);//lucas
        //!pollito 

        switch (cmd) {
            case "ping":
                PingCommand.exec(botPollito.bot, e.getMessage(), argumentos);
                break;
            case "msg":
                commandMsj.exex(botPollito.bot, e.getMessage(), argumentos);
                break;
            case "di":
                String dis = "disculpa a este idiota, no sabe lo que hace";
                e.getMessage().getChannel().sendMessage(dis).queue();
                break;
            case "res":
                String d = "a yaaaaaaaaaaaaaaaa te me cuidas , crack, maquina, fiera, jefe, tifón, numero 1, "
                        + "\n figura, mostro, mastodonte, toro, furia, ciclón, tornado,"
                        + "\nartista, fenómeno, campeón, maestro, torero, socio";
                e.getMessage().getChannel().sendMessage(d).queue();
                break;
            case "ayu":
                String res = "por favor mas respeto a una dama en este servidor :(";

                e.getMessage().getChannel().sendMessage(res).queue();
                break;
            case "chau":
                String c = "ya me voy crack por alguna manera me va a desconectar"
                        + "\n hay cosa que son inevitables como la cara de gil que llevas"
                        + "\n pero no te preocupes sonrie toma tu leche"
                        + "\na sido un placer cumplir tus deseos toxicos :v"
                        + "\nbot pollito : quien en vida fue un bot de verdad ;)";

                e.getMessage().getChannel().sendMessage(c).queue();
                break;
            case "antro":
                String l = ":po";

                e.getMessage().getChannel().sendMessage(l).queue();
                break;     
            case "hola" : 
                  String o = "un hola mundo no te hace programador, hasta luego :)";
                          e.getMessage().getChannel().sendMessage(o).queue();
                break ;
        }
        /*    
       Message msg = e.getMessage();
       if(msg.getContentRaw().equals("!rodrigo")){
           MessageChannel canal = e.getChannel();
           long time = System.currentTimeMillis();
        
           canal.sendMessage("love")
                    .queue(response ->{
                 response.editMessageFormat("Pong: el mas gay de todos(buenas nalgas)", System.currentTimeMillis() - time).queue();  
                  System.out.println("numewr"+time);
        });
       }  
       if(msg.getContentRaw().equals("!mulay")){
           MessageChannel canal = e.getChannel();
           long time = System.currentTimeMillis();
        
           canal.sendMessage("love")
                    .queue(response ->{
                 response.editMessageFormat("las mejores nalgas)", System.currentTimeMillis() - time).queue();  
                  System.out.println("numewr"+time);
        });
          
       }
         
       System.out.println("nombre: "+e.getAuthor().getAsTag());
       System.out.println("servidor: "+e.getGuild().getName());
       System.out.println("canal: "+e.getChannel().getName());
       System.out.println("mensaje: "+e.getMessage().getContentRaw());
         */
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        //cuando alguien nuevo entra al servidor      
        String nick = e.getMember().getNickname();
        List<TextChannel> listaCanale = e.getJDA().getTextChannels();

        for (int i = 0; i < listaCanale.size(); i++) {
            listaCanale.get(i).sendMessage("nuevo usuario");

        }

    }

    @Override
    public void onReady(ReadyEvent e) {
        int n = e.getGuildAvailableCount();
       
        men = Archivo.ArchivoBaseDate.leerTexto("motivame");
        chiste = Archivo.ArchivoBaseDate.abrirArchivoGrande("chiste");
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {

        e.getChannel().sendMessage("se ha reaccionado a un mensaje");

    }

    @Override
    public void onGuildMessageReactionAdd​(GuildMessageReactionAddEvent event) {
  
        MessageReaction.ReactionEmote on = event.getReactionEmote();
        event.getChannel().sendMessage(event.getMember().getUser().getAsTag() + " reacciono a un mensaje").queue();
        //event.getChannel().sendMessage()
    }
}
