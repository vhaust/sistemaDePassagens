# sistemaDePassagens
AP2: Estudo de caso do sistema de passagens de avião proposto no trabalho computacional

- [Modelagem UML](#modelagem-uml)
- [Instalar o Git no Windows](#instalar-o-git-no-windows)
	- [1. Configurando o Git](#1-configurando-o-git)
- [Autenticação SSH](#autenticação-ssh)
	- [1. Gerar chave SSH](#1-gerar-chave-ssh)
	- [2. Iniciar servidor SSH](#2-iniciar-servidor-ssh)
	- [3. Adicionar chave SSH na conta GitHub](#3-adicionar-chave-ssh-na-conta-github)
- [Iniciar o Projeto](#iniciar-o-projeto)
	- [1. Clonar o repositório do projeto](#1-clonar-o-repositório-do-projeto)
	- [2. Comandos básicos](#2-comandos-básicos)
		- [2.1 Branch](#21-branch)
		- [2.2 Commit](#22-commit)
		- [2.3 Reset](#23-reset)
		- [2.4 Push](#24-push)
	- [3. GitFLuxo](#3-gitfluxo)
- [Estrutura do Projeto](#estrutura-do-projeto)

## Modelagem UML

(Sugestão) Para modelar as interações das classes há o UMLet, disponível para download em: <https://www.umlet.com/> e também possui versão web: <http://www.umletino.com/>.

## Instalar o Git no Windows

Para o desenvolvimento simultâneo e a manutenção dos artefatos da implementação do trabalho é necessário utilizar o **Git** que é o sistema de controle de versão de códigos, para baixá-lo acesse o site oficial: <https://gitforwindows.org/>.

### 1. Configurando o Git

Para nos identificar ao Git são necessários ... , digite no terminal **Git Bash** e substitua no exemplo o seu **nome de usuário** e o **e-mail** cadastrado no GitHub:

```
git config --global user.name "Nome de usuário"
```

```
git config --global user.email "email@example.com"
```

---

- [Git & Github: O que é? Por que? Como iniciar?][1]
- [Tutorial do GIT Básico – Introdução ao GIT][2]

[1]: <https://blog.rocketseat.com.br/iniciando-com-git-github/> "Clique para acessar"
[2]: <https://www.hostinger.com.br/tutoriais/tutorial-do-git-basics-introducao/> "Clique para acessar"

## Autenticação SSH

Para evitar ter de informar o usuário e senha todas as vezes que for atualizar o código é necessário realizar a autenticação SSH.

### 1. Gerar chave SSH

Para gerar o novo par (público/privado) de chaves SSH, digite no terminal **Git Bash** (previamente instalado com o Git) o código abaixo e substitua no exemplo o **e-mail** cadastrado no GitHub:

```
ssh-keygen -t rsa -b 4096 -C "email@example.com"
```

### 2. Iniciar servidor SSH

Para iniciar o servidor OpenSSH junto com o terminal, é necessário adicionar (ou criar o arquivo) ao *perfil bash* do Git (geralmente localizado em "C:\Users\NomeDoUsuário\.bash_profile") o seguinte script:

```
SSH_ENV="$HOME/.ssh/environment"

function start_agent {
    echo "Incializando novo agente SSH..."
    /usr/bin/ssh-agent | sed 's/^echo/#echo/' > "${SSH_ENV}"
    echo "Processo SSH capturado com sucesso!"
    chmod 600 "${SSH_ENV}"
    . "${SSH_ENV}" > /dev/null
	ssh-add ~/.ssh/id_rsa
}

# Source SSH settings, if applicable

if [ -f "${SSH_ENV}" ]; then
    . "${SSH_ENV}" > /dev/null
    #ps ${SSH_AGENT_PID} doesn't work under cywgin
    ps -ef | grep ${SSH_AGENT_PID} | grep ssh-agent$ > /dev/null || {
        start_agent;
    }
else
    start_agent;
fi

trap 'kill $SSH_AGENT_PID' EXIT
```

### 3. Adicionar chave SSH na conta GitHub

Para adicionar a chave SSH previamente criada, faça o login na conta GitHub, clique na [***foto de perfil***] no canto superior direito e em seguida em [\[***Settings***\]](<https://github.com/settings/profile>). Na barra lateral da tela de configuração, clique em [\[***SSH and GPG keys***\]](<https://github.com/settings/keys>).

Ao clicar em [\[***New SSH key***\]](<https://github.com/settings/ssh/new>), no campo *Title* escolha um título que represente o computador onde a chave está armazenada, copie todo o conteúdo do arquivo id_rsa.pub (no Windows, localizado em "C:\Users\NomeDoUsuário\.ssh\id_rsa.pub") e cole no campo *Key* e finalmente clique em [***Add SSH key***].

- [Usando chaves SSH com o Git][3]
- [[Git+GitHub] Evitando Informar Usuário e Senha a cada Push para o GitHub][4]

[3]: <https://kamarada.github.io/pt/2017/04/09/usando-chaves-ssh-com-o-git/> "Clique para acessar"

[4]: <https://medium.com/@andgomes/git-github-evitando-informar-usu%C3%A1rio-e-senha-a-cada-push-para-o-github-d8edbb5c6de4/> "Clique para acessar"

## Iniciar o Projeto

### 1. Clonar o repositório do projeto

Para clonar o repositório remoto [**via autenticação ssh**](#autenticação-ssh) para o seu computador, utilize o código abaixo no **Git Bash**:

```
git clone git@github.com:vhaust/sistemaDePassagens.git
```

Em seguida, é preciso definir e apontar para o *branch master* do repositório remoto, para que seja possível enviar os códigos, utilize o código abaixo no **Git Bash**:

```
git push -u origin master
```

Antes de editar qualquer código lembre-se de **sempre atualizar o seu repositório local em relação ao remoto**, utilize o código abaixo no **Git Bash**:

```
git pull
```
### 2. Comandos básicos

#### 2.1 Branch

Para implementar códigos em teste pode-se criar uma *branch* que é a ramificação da versão principal *master* do código, utilize o código abaixo no **Git Bash**:

```
git chekout -b <nomeDaBranch>
```

Para alterar para outra branch, utilize o código abaixo no **Git Bash**:

```
git chekout <nomeDaBranch>

```

Para deletar a branch, utilize o código abaixo no **Git Bash**:

```
git branch -D <nomeDaBranch>
```

- [[Git] Trabalhando com Branches Remotos][5]

[5]: <https://medium.com/@andgomes/git-trabalhando-com-branches-remotos-c79aabf3a2e5> "Clique para acessar"

#### 2.2 Commit

*//Em construção*

Para indicar o(s) arquivos alterado(s) ~~(que vão ser *comitados*)~~ ao *stage*, utilize o código abaixo no **Git Bash**:

```
git add <caminhoDoArquivo> 
```

Se preferir adicionar **todos** os arquivos ao *stage*, utilize o código abaixo no **Git Bash**:

```
git add --all
```

É possivel ver o estado dos arquivos, utilize o código abaixo no **Git Bash**:

```
git status
```
Ao concluir a implementação ou a alteração do código, é necessário *comitá-lo* ~~para enviar ao repositório remoto~~, lembre-se de escrever mensagens significativas e iniciá-la usando o modo *imperativo*, utilize o código abaixo no **Git Bash**:

```
git commit -m "Demonstra o exemplo de mensagem"
```

#### 2.3 Reset

*//Em construção*

#### 2.4 Push

*//Em construção*

Depois de *comitado* pode-se enviar o código ao repositório remoto indicando a branch, utilize o código abaixo no **Git Bash**:

```
git push origin <nomeDaBranch>
```

### 3. GitFLuxo

*//Em construção*

### Estrutura do Projeto

src = /sistemaDePassagens/src/main/java/
package = br.com.ap22020.sistema_de_passagens

```
/sistemaDePassagens/src/main/java/
                            ├── Main.java
                            │
                            └── br.com.ap22020.sistema_de_passagens
                                ├─┬ model 
                                │ └── ClassesDoProjeto.java
                                └─┬ view
                                  └── ClassesDaInterfaceGUI
```