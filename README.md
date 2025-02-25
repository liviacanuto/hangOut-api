# HangOut

Pegue uma tarefa [clicando aqui](https://github.com/users/liviacanuto/projects/3/views/1)

### 1. Clonar o repositório
Primeiro, clone este repositório para sua máquina local:

```bash
git clone https://github.com/liviacanuto/hangOut-api
```

### 2. Buildar o projeto
Navegue até o diretório do projeto e builde o projeto

```bash
cd hangOut-app
./mvnw clean install
```

Para buildar sem rodas os testes

```bash
./mvnw clean install -DskipTests
```

### 3. Iniciar o servidor
Após a instalação, inicie o servidor de desenvolvimento:

```bash
./mvnw spring-boot:run
```

### 4. Testar no seu navegador
Após iniciar o projeto com o comando `./mvnw spring-boot:run`, abra o `localhost:8080/api/hello` e veja se está funcionando corretamente.


Obs: você também pode rodar o projeto apenas clicando no botão na sua IDE. Essas opções é pra quem quer rodar por linha de comando :)
