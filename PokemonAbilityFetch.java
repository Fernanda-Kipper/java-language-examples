import java.io.IOException;
import java.net.http.HttpResponse;

public class PokemonAbilityFetch {
    private final String pokemonName;
    private final HttpClient<String> httpClient = new HttpClient<>(HttpResponse.BodyHandlers.ofString());

    public PokemonAbilityFetch(String pokemonName){
        this.pokemonName = pokemonName;
    }

    public void fetch() {
        try {
            String apiUrl = "https://pokeapi.co/api/v2/pokemon/";
            String response = httpClient.get(apiUrl + pokemonName);
            printPokemonAbilities(response, pokemonName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private static void printPokemonAbilities(String jsonResponse, String pokemonName) {
        // Simplified string parsing to extract abilities
        String abilitiesSection = jsonResponse.split("\"abilities\":\\[")[1].split("],")[0];
        String[] abilities = abilitiesSection.split("\\},\\{");

        for (int i = 0; i < abilities.length; i++) {
            String abilityName = abilities[i].split("\"name\":\"")[1].split("\"")[0];
            System.out.println(pokemonName + " ability " + (i + 1) + ": " + abilityName);
        }
    }
}
