# DictionMaster

Há duas branches no repositório, em que eu cheguei em diferentes partes do desafio, são elas:

- WITH-CACHE-ATTEMPT: 

    Nesta branche há uma tentativa de implementar o mecanismo de cache utilizando Room Database,
    entretando encontrei algumas dificuldades em realizar o parse dos objetos JSON para o Banco,
    infelizmente não consegui solucionar isto em tempo hábil. Por conta disto decidi focar na entrega das telas funcionais.
    Ainda que não implementado acredito que seja possível a partir do código depreender a lógica eu gostaria de utilizar.
    
 -  ALL-SCREEN-WORK-NO-CACHE:
 
    Neste caso não há mecanismo de cache mas é possível seguir o fluxo feliz de utilização.
    A questão do parse do JSON se mostrou novamente desafiador, uma vez que o app quebra dependendo da busca realizada,
    p.ex.: buscando por 'Dog', o fluxo segue normalmente, mas buscando por 'Perro' ou 'Chiot' não.
    Isso acontece pois o Json que a api devolve não é necessariamente igual para todas as línguas,
    e a solução encontrada para contornar isto está longe do ideal. 
    
    
    
  Um comentário sobre o meu processo:

- Independe do resultado deste processo ele foi de grande valia para mim, uma vez que serviu para elucidar tópicos que merecem atenção durante meus estudos. 
  Agradeço imençamente esta oportunidade
    
 Prints das telas implementadas:

![image](https://user-images.githubusercontent.com/33462685/158081472-9127c7bd-a0be-4dc6-ba82-ef6d5bc5fec6.png)
![image](https://user-images.githubusercontent.com/33462685/158081486-eb3db2e5-768c-4f9c-a3aa-433ccfec0b40.png)
![image](https://user-images.githubusercontent.com/33462685/158081490-5b4bb9e5-c90b-45aa-8a71-1333202f59c8.png)
![image](https://user-images.githubusercontent.com/33462685/158081509-e597ff35-a501-4760-b4c1-9ab22cb532c7.png)
![image](https://user-images.githubusercontent.com/33462685/158081424-9050c464-abf1-4927-8780-ca82ab320a44.png)
![image](https://user-images.githubusercontent.com/33462685/158081529-7033797d-33e7-4d84-9c59-4da9cf272736.png)

