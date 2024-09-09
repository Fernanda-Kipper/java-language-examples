import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public void run() throws ExecutionException, InterruptedException {
        CompletableFuture pikachu1 = CompletableFuture.runAsync(() -> {
            PokemonAbilityFetch pokemonAbilityFetch = new PokemonAbilityFetch("pikachu");
            String response = pokemonAbilityFetch.fetch();
        });

        CompletableFuture pikachu = CompletableFuture.supplyAsync(() -> {
           PokemonAbilityFetch pokemonAbilityFetch = new PokemonAbilityFetch("pikachu");
            String response = pokemonAbilityFetch.fetch();
            return response;
        });
        CompletableFuture charmander = CompletableFuture.supplyAsync(() -> {
            PokemonAbilityFetch pokemonAbilityFetch = new PokemonAbilityFetch("charmander");
            String response = pokemonAbilityFetch.fetch();
            return response;
        });

        CompletableFuture bulbasaur = CompletableFuture.supplyAsync(() -> {
            PokemonAbilityFetch pokemonAbilityFetch = new PokemonAbilityFetch("bulbasaur");
            String response = pokemonAbilityFetch.fetch();
            return response;
        });

        CompletableFuture ditto = CompletableFuture.supplyAsync(() -> {
            PokemonAbilityFetch pokemonAbilityFetch = new PokemonAbilityFetch("ditto");
            String response = pokemonAbilityFetch.fetch();
            return response;
        });

        pikachu1.join();

        CompletableFuture allPokemons = CompletableFuture.allOf(pikachu, charmander, bulbasaur, ditto);
        allPokemons.thenRun(() -> {
            try {
                System.out.println("Pikachu: " + pikachu.get());
                System.out.println("Charmander: " + charmander.get());
                System.out.println("Bulbasaur: " + bulbasaur.get());
                System.out.println("Ditto: " + ditto.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).get();
    }
}
