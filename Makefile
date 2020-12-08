SOURCEPATH = src/main/java
PACKAGE = br/com/ap22020/sistema_de_passagens
JFLAGS = -sourcepath $(SOURCEPATH)
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
    $(SOURCEPATH)/$(PACKAGE)/model/Assento.java \
    $(SOURCEPATH)/$(PACKAGE)/model/Aviao.java \
    $(SOURCEPATH)/$(PACKAGE)/model/Cartao.java \
    $(SOURCEPATH)/$(PACKAGE)/model/Cidade.java \
    $(SOURCEPATH)/$(PACKAGE)/model/CodigoIATA.java \
    $(SOURCEPATH)/$(PACKAGE)/model/Conta.java \
    $(SOURCEPATH)/$(PACKAGE)/model/ContasTestes.java \
    $(SOURCEPATH)/$(PACKAGE)/model/DistanciaCidades.java \
    $(SOURCEPATH)/$(PACKAGE)/model/Passagem.java \
    $(SOURCEPATH)/$(PACKAGE)/model/PassagemInteira.java \
    $(SOURCEPATH)/$(PACKAGE)/model/PassagemMeia.java \
    $(SOURCEPATH)/$(PACKAGE)/model/Passaporte.java \
    $(SOURCEPATH)/$(PACKAGE)/model/Pessoa.java \
    $(SOURCEPATH)/$(PACKAGE)/model/TipoCartao.java \
    $(SOURCEPATH)/$(PACKAGE)/model/Voo.java \
    $(SOURCEPATH)/$(PACKAGE)/model/passagens/RegistraVooTeste.java \
    $(SOURCEPATH)/$(PACKAGE)/model/passagens/TesteSistemaPassagens.java

default: compile

compile: $(CLASSES:.java=.class)

run: compile
	java -classpath $(SOURCEPATH)/$(PACKAGE)/model/passagens TesteSistemaPassagens

clean: $(CLASSES:.java=.class)
	$(RM) $(CLASSES:.java=.class)