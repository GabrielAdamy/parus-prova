# Executar a API
Não é preciso confugurar pois esta sendo utilizado um banco de dados em memoria.

# Abrir o programa POSTMAN

# Executar o metodo POST (Cadastrar) como apresentado na imagem
  
http://localhost:8080/cliente
  
  {
  "nome": "DIGITAR NOME",
    "rendimentoMensal": DIGITAR VALOR MENSAL,
    "endereco": "DIGITAR ENDEREÇO"
    }

![Parus](https://github.com/GabrielAdamy/parus-prova/blob/main/.Imagens/Post.png)


# Executar o metodo PUT (Atualizar) como apresentado na imagem

http://localhost:8080/cliente/{id que deseja atualizar}

"nome": "DIGITAR NOME",
    "rendimentoMensal": DIGITAR VALOR MENSAL,
    "endereco": "DIGITAR ENDEREÇO"
    }
    
![Parus](https://github.com/GabrielAdamy/parus-prova/blob/main/.Imagens/Put.png)

# Executar o metodo GET (Buscar) como apresentado na imagem

http://localhost:8080/cliente

![Parus](https://github.com/GabrielAdamy/parus-prova/blob/main/.Imagens/Get.png)

# Executar o metodo GET (Buscar por id) como apresentado na imagem

http://localhost:8080/cliente/{id que deseja atualizar}

![Parus](https://github.com/GabrielAdamy/parus-prova/blob/main/.Imagens/GetId.png)

# Executar o metodo DELETE (Deletar pela id informada) como apresentado na imagem

http://localhost:8080/cliente/{id que desejar }

![Parus](https://github.com/GabrielAdamy/parus-prova/blob/main/.Imagens/delete.png)
