# fan-clube
# Configurações do Programa

Este arquivo contém as configurações necessárias para a conexão com o banco de dados.

## Configurações

### Usuário e Senha

- **Usuário (user):** O nome de usuário para autenticação no banco de dados.
- **Senha (password):** A senha associada ao usuário para autenticação.

### URL do Banco de Dados

- **URL do Banco de Dados (dburl):** A URL JDBC para o banco de dados MySQL.

### Esquema do Banco de Dados

- **Esquema (schema):** O nome do esquema do banco de dados que o programa usará.

### Configurações de Conexão

- **Use SSL (useSSL):** Define se a conexão deve usar SSL. Se definido como `true`, a conexão usará SSL; caso contrário, será `false`.
- **Permitir Recuperação de Chave Pública (allowPublicKeyRetrieval):** Define se a recuperação de chave pública é permitida. Se definido como `true`, a recuperação de chave pública é permitida; caso contrário, será `false`.

## Exemplo

```properties
user=root
password=root
dburl=jdbc:mysql://localhost:3306/
schema=fan_club
useSSL=false
allowPublicKeyRetrieval=true
