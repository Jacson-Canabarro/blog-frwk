# blog-frwk-api

Projeto foi configurado para jdk versão 11, sugiro seguir essa versão, pois haverá problemas com a antiga API do java, principalemente com a String e date.

# Build e Run

Todas as dependencias do projeto foram listadas no POM.XML utilizando o Maven, então a aplicação reconhecera o arquivo padrão e atualizará as dependencias.

O projeto foi desenvolvido com o [Lombok](https://projectlombok.org/), então caso utilize o [Eclipse](https://projectlombok.org/setup/eclipse), será necessário baixar o jar para habilitar a IDE,
já no [IntelliJ IDEA](https://projectlombok.org/setup/intellij) é somente baixar o plugin via store.

Para rodar o projeto, será necessário levar um container docker com o postgres;
abra o terminal, navegue até a pasta raiz do projeto e com docker inicializado, digite o seguinte comando:

```bash
docker-compose up
```

E pronto, tudo certo para iniciar!


