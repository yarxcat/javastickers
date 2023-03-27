import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão http e buscar os TOP filmes através de uma API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();
        //System.out.println(body); para mostrar dados que encontramos na busca

        // Extraindo apenas os dados que interessam. (Titulo, poster, classificação)
        var parser = new JsonParser5();
        List<Map<String, String>> ListadeFilmes = parser.parse(body);

        
        //Exibir e manipular dados
        for (Map<String, String> filme : ListadeFilmes) {
            System.out.println("Filme: " + "\u001B[35m" + filme.get("title") + "\u001B[37m");
            System.out.println("Ano: " + "\u001B[36m" + filme.get("year") + "\u001B[37m");
            System.out.println("Ranking: " + "\u001B[34m"+filme.get("rank" )+ "\033[32;1m");
            System.out.println("Avaliação do IMDb:  " + "\u001B[34m" + filme.get("imDbRating") + "\033[32;1m" );
            System.out.println();
        }
            
            
    }
}
