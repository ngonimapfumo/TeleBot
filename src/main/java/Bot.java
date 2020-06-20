import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.LongPollingBot;

public class Bot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    private void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage()
                .enableMarkdown(true)
                .setChatId(chatId).setText(s);

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException telegramApiException) {

        }
    }

    public String getBotUsername() {
        return "BotName";
    }

    public String getBotToken() {
        return "BotTaken";
    }
}
