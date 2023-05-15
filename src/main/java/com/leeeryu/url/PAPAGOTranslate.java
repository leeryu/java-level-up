package com.leeeryu.url;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;

public class PAPAGOTranslate implements Translate {

    private final String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
    private final String clientId = "";
    private final String clientSecret = "";
    private ObjectMapper objectMapper = new ObjectMapper();

    public PAPAGOTranslate() {
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public String translate(String text, String source, String target) {
        final String response = UrlConnector.post(apiURL,
                Map.of("X-Naver-Client-Id", clientId, "X-Naver-Client-Secret", clientSecret),
                Map.of("text", URLEncoder.encode(text, Charset.defaultCharset())
                        , "source", source, "target", target)
        );

        try {
            final JsonNode message = objectMapper.readTree(response);
            final JsonNode jsonNode = objectMapper.readTree(message.get("message").toString());

            final Result result = objectMapper.readValue(jsonNode.get("result").toString(),
                    objectMapper.getTypeFactory().constructType(Result.class));
            return result.getTranslatedText();
        } catch (IOException e) {
            System.out.println("번역 결과를 읽는데 실패했습니다.");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        PAPAGOTranslate papagoTranslate = new PAPAGOTranslate();

        while (true) {
            System.out.print("번역할 문장을 입력해 주세요: ");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();

            if ("".equals(text)) {
                System.out.println("입력된 문장이 없습니다.");
                continue;
            }
            if ("exit".equals(text) || "9".equals(text)) {
                System.out.println("종료합니다.");
                break;
            }

            final String message = papagoTranslate.translate(text, "ko", "en");
            System.out.println("번역 결과: " + message);
        }
    }
}
