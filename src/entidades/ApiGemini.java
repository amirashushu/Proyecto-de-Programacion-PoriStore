package entidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiGemini {
    private static final String API_KEY = "AQ.Ab8RN6IKTAZ_dL9tgH8swYyK2rHVkfe2iNt2v9byXbn4TBN4Zg"; // Reemplaza con tu API key
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-3.1-flash-lite:generateContent?key=" + API_KEY;

    

    public static String callGeminiAPI(String prompt) throws Exception {
        // Configurar la conexión HTTP
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setConnectTimeout(30000); 
        connection.setReadTimeout(90000);  
        // Cuerpo de la petición (JSON)
        String requestBody = String.format(
            "{\"contents\": [{\"parts\": [{\"text\": \"%s\"}]}]}",
            escapeJson(prompt)
        );

        // Envio de la petición
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Respuesta
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                return extractTextFromResponse(response.toString());
            }
        } else {
            throw new RuntimeException("Error en la API: " + responseCode);
        }
    }

    // Limpia JSON
    private static String escapeJson(String input) {
        return input.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }

    private static final java.util.regex.Pattern TEXT = java.util.regex.Pattern.compile(
        "\"text\"\\s*:\\s*\"((?:[^\"\\\\]|\\\\.)*)\""
    );

    private static String extractTextFromResponse(String jsonResponse) {
        java.util.regex.Matcher matches = TEXT.matcher(jsonResponse);
        StringBuilder result = new StringBuilder();
        boolean found = false;
        while (matches.find()) {
            found = true;
            result.append(decodeJsonString(matches.group(1)));
        }
        if (!found) {
            throw new IllegalStateException("Gemini no devolvió texto: " + jsonResponse);
        }
        return result.toString();
    }

    private static String decodeJsonString(String value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c != '\\') {
                result.append(c);
                continue;
            }
            switch (value.charAt(++i)) {
                case '"': result.append('"'); break;
                case '\\': result.append('\\'); break;
                case '/': result.append('/'); break;
                case 'n': result.append('\n'); break;
                case 'r': result.append('\r'); break;
                case 't': result.append('\t'); break;
                case 'b': result.append('\b'); break;
                case 'f': result.append('\f'); break;
                case 'u':
                    result.append((char) Integer.parseInt(value.substring(i + 1, i + 5), 16));
                    i += 4;
                    break;
                default: throw new IllegalArgumentException("Escape JSON inválido");
            }
        }
        return result.toString();
    }
}
