package ProjectA;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Car_Select0r_bot";
    }

    @Override
    public String getBotToken() {
        return System.getenv("Token");
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                ListCommands commandsList = new ListCommands();
                Message inMessage = update.getMessage();
                String chatId = inMessage.getChatId().toString();
                String message = commandsList.findCommand(inMessage.getText());
                SendMessage outMessage = new SendMessage();
                outMessage.setChatId(chatId);
                outMessage.setText(message);
                execute(outMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
