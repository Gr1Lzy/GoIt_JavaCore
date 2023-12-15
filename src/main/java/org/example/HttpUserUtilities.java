package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import org.example.module13_1.model.User;
import org.example.module13_2.model.Post;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpUserUtilities {
    private static final String USER_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String POST_SUFFIX = "/posts";
    private static final Gson GSON = new Gson();
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    @SneakyThrows
    public User createUser(User user) {
        final String requestBody = GSON.toJson(user);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }

    @SneakyThrows
    public User updateUser(User user) {
        final String requestBody = GSON.toJson(user);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", USER_URL, user.getId())))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }

    @SneakyThrows
    public String deleteUser(int id) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", USER_URL, id)))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return "Deleted successfully, status code: " + response.statusCode();
        }
        return "Error, status code: " + response.statusCode();
    }

    @SneakyThrows
    public List<User> getAllUsers() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER_URL))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), new TypeToken<List<User>>() {}.getType());
    }

    @SneakyThrows
    public User getUserById(int id) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d", USER_URL, id)))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }

    @SneakyThrows
    public User getUserByUsername(String username) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s?username=%s", USER_URL, username)))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        User[] userByUsername = GSON.fromJson(response.body(), User[].class);

        return userByUsername[0];
    }

    @SneakyThrows
    public List<Post> getAllPostsByUserId(int userId) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%d/%s", USER_URL, userId, POST_SUFFIX)))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<Post> result = GSON.fromJson(response.body(), new TypeToken<List<Post>>() {}.getType());

        writeJsonToFile(result, userId, result.size());

        return result;
    }

    private void writeJsonToFile(List<Post> posts, int userId, int postCount) {

        File file = new File(String.format("./src/main/java/org/example/module13_2/files/user-%d-post-%d-comments.json", userId, postCount));

        try (Writer writer = new FileWriter(file)) {

            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(posts));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
