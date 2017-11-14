package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by User on 09.07.2017.
 */
public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();

        botClient.run();
    }
    @Override

    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    protected String getUserName() {
        return "date_bot_"+(int)(Math.random()*100);
    }

    public class BotSocketThread extends SocketThread{



        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(":")) {
                String[] strings = message.split(": ");
                Calendar calendar = new GregorianCalendar();
                Date date = calendar.getTime();
                String answer="Информация для " + strings[0] + ": ";
                SimpleDateFormat formatForDateNow = null;
                if (strings.length==2) {
                    switch (strings[1].trim()) {
                        case "дата": {
                            formatForDateNow = new SimpleDateFormat("d.MM.yyyy");
                            break;
                        }
                        case "день": {
                            formatForDateNow = new SimpleDateFormat("d");
                            break;
                        }
                        case "месяц": {
                            formatForDateNow = new SimpleDateFormat("MMMM");
                            break;
                        }
                        case "год": {
                            formatForDateNow = new SimpleDateFormat("YYYY");
                            break;
                        }
                        case "время": {
                            formatForDateNow = new SimpleDateFormat("H:mm:ss");
                            break;
                        }
                        case "час": {
                            formatForDateNow = new SimpleDateFormat("H");
                            break;
                        }
                        case "минуты": {
                            formatForDateNow = new SimpleDateFormat("m");
                            break;
                        }
                        case "секунды": {
                            formatForDateNow = new SimpleDateFormat("s");
                            break;
                        }
                        default: {
                            //ConsoleHelper.writeMessage("Неправильный ввод");
                            return;
                        }
                    }
                }
                if (formatForDateNow!=null) {
                    answer = answer + formatForDateNow.format(date).toString();
                    sendTextMessage(answer);
                }
            }
        }
    }
}
