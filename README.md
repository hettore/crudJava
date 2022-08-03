# CRUD em Java

Integrando java com banco de dados MySQL usando o DAO (Data access object), <br>
A ideia inicial é armazenar um contato e aqui salvamos: nome, idade, <br>
data do cadastro e também é gerado uma chave primária para a identificação de cada posição da lista. 

<br>

Logo na primeira tela você tem um menu para conseguir navegar entre as opções <br>
relacionadas ao CRUD (Create, Read, Update e delete). As operações são feitas pelo <br>
console e como foi feito em Java é necessário ter o kit java instalado e uma IDE para rodar o projeto. <br>
<br>
Na primeira imagem demonstro a opção 1 que adiciona um contato no banco de dados. <br>
Já a segunda imagem demonstro a atualização de um contato existente e vale lembrar que para fazer essa atualização <br>
é necessário saber o id do contato a ser atualizado.

                                                                                              
![tela1crud](https://user-images.githubusercontent.com/24979432/182383594-9cda5055-35f9-45b7-9a5f-fc13e2d9b1b3.png) | ![tela2crudpng](https://user-images.githubusercontent.com/24979432/182383349-76fac3a5-0292-4294-9306-63387141d0a9.png)


<br>

Na terceira imagem demostro o uso da opção 4 que mostra na tela os contatos <br>
que já estão salvos no banco de dados com o id e o nome. 
<br>

![tela3crud](https://user-images.githubusercontent.com/24979432/182384076-5bbc51fd-6306-416d-b1cd-b396a8a4842c.png) 

<br>

Na quarta imagem demonstro a opção 3 que apaga um contato a partir do id 
<br>

![tela4crud](https://user-images.githubusercontent.com/24979432/182384586-3cddc655-a0d8-4a4c-86f7-10311e73590b.png)


<br>
Na quinta imagem demonstro novamente a opção 4 mostrando que a posição de id 19 <br>
foi apagada pelo passo anterior.
Na sexta e última imagem do programa demonstro o encerramento do programa usando a opção 5. <br>

<br>

![tela5crud](https://user-images.githubusercontent.com/24979432/182385837-4e9d5dbd-5288-4dcc-9bd2-92aa1e25e353.png) | ![tela6crud](https://user-images.githubusercontent.com/24979432/182262606-f955228c-3e10-4194-93cf-1dd28eadd049.png)

O programa só finaliza ao selecionar a opção "Fechar programa". <br>

###  Script MySQL:

<br>
Script que cria o banco de dados agenda e sua tabela contatos contendo: id, nome, idade, dataCadastro. <br>

<br>

![bancodadados1](https://user-images.githubusercontent.com/24979432/182372439-655027cb-45a0-42de-9fb6-dd45b0025db9.png)

<br>
Comando que mostra/seleciona todas (*) as posições de agenda.contatos. <br>

<br>

![bancodedados2png](https://user-images.githubusercontent.com/24979432/182390769-acfa925d-23bc-4a42-859d-36e56dc441bf.png)










