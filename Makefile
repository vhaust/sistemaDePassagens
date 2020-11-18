SOURCEPATH = src/main/java
PACKAGE = br/com/ap22020/sistema_de_passagens
JFLAGS = -sourcepath $(SOURCEPATH)
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	$(SOURCEPATH)/$(PACKAGE)/model/ClasseModelExemplo.java \
	$(SOURCEPATH)/$(PACKAGE)/view/ClasseViewExemplo.java \
	$(SOURCEPATH)/Main.java

default: compile

compile: $(CLASSES:.java=.class)

run: compile
	java -classpath $(SOURCEPATH) Main

clean: $(CLASSES:.java=.class)
	$(RM) $(CLASSES:.java=.class)