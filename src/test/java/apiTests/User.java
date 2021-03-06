package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

    public class User {
        String uri = "https://petstore.swagger.io/v2/user";
        int userId = 2008;
        String username = "bartsimpson";
        String password = "123";
        String token = "";

        // Padrão
        // Given = Dado
        // .When = Quando
        // .Then = Então

        // Funções de Apoio
        public String lerJson(String caminhoJson) throws IOException {
            return new String(Files.readAllBytes(Paths.get(caminhoJson)));
        }
        @Test
        //creat
        public void incluirUsuario () throws IOException {
            String jsonBody = lerJson("src/test/resources/data/user.json");
            //given
            given()
                    .contentType("application/json")
                    .log().all()
                    .body(jsonBody)
            .when()
                    .post(uri)
            .then()
                    .log().all()
                    .statusCode(200)
                    .body("code", is(200))
                    .body("type", is("unknown"))
                    .body("message", is(Integer.toString(userId)))
            ;


        }
        @Test
        public void consultarUsurio() {

            given()
                    .contentType("application/json")
                    .log().all()
                    .when()
                    .get(uri + "/" + username)
                    .then()
                    .log().all()
                    .statusCode(200)
                    .body("id", is(userId))
                    .body("username", is(username))
                    .body("firstName", is("bart"))
                    .body("lastName", is("simpson"))
                    .body("email", is("bart.simpson@teste.com.br"))
                    .body("password", is("123"))
                    .body("phone", is("551199999999"))
                    .body("userStatus", is(0))
            ;
        }
        @Test

            public void login(){

            String mensagem =

                given()
                        .contentType("application/json")
                        .log().all()
                .when()
                        .get(uri + "/login?username=" + username + "&password=" + password)
                .then()
                        .log().all()
                        .statusCode(200)
                        .body("code", is(200))
                        .body("type", is("unknown"))
                .body("type",is("unknown"))
                .extract()
                .path("message")
            ;
            System.out.println("A message é:" + mensagem);
            token = mensagem.substring(23);
            System.out.println("O token é :" + token);

            }



        }


