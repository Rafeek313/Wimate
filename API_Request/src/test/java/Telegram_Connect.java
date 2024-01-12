

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.UriBuilder;
import org.telegram.telegrambots.api.methods.ParseMode;
import org.telegram.telegrambots.api.methods.send.SendMessage;

public class Telegram_Connect {
	
	

	private static final String CHAT_ID = "-1002116094396";
	// 1628615745
	private static final String TOKEN = "6967034906:AAFRwKj6wldxoSy8MoW41-HjXKzxARp5bmk";

	public void lagunatelegramnotification(String message) throws IOException, InterruptedException {{

		String message1 = message;
		

		HttpClient client = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(5))
				.version(HttpClient.Version.HTTP_2)
				.build();

		UriBuilder builder = UriBuilder
				.fromUri("https://api.telegram.org")
				.path("/{token}/sendMessage")
				.queryParam("chat_id", CHAT_ID)
				.queryParam("text", message1);

		SendMessage sendMessage = new SendMessage()
				.setChatId(CHAT_ID)
				.setText(message1)
				.setParseMode(ParseMode.HTML);

		HttpRequest request = HttpRequest
				.newBuilder()
				.GET()
				.uri(builder.build("bot" + TOKEN))
				.timeout(Duration.ofSeconds(5)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());

	}
	}

}
