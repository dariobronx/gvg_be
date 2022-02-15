# Getting Started

## Scope

GVG srl è un'azienda che vende all'ingrosso.

Nell'ambito della transizione digitale, GVG decide di dire addio al blocchetto cartaceo delle fatture e dotarsi
di un registro elettronico delle fatture emesse. Tramite questo programma è possibile creare fatture, inviarle ai
clienti e conservarle a norma di legge.

Quando un cliente invia un ordine di acquisto GVG prepara la merce per la consegna ed emette una fattura con il
dettaglio dei beni richiesti, il totale da pagare e gli estremi per il pagamento. La fattura è un documento obbligatorio
per legge e riporta:

* l'identificativo nel sistema di contabilità: un numero e un anno, ad esempio 150/20229
* la data di emissione, ad esempio 1 gennaio 2022
* gli estremi del cedente/prestatore (cioè chi emette la fattura): nome e partita IVA
  (un codice di 11 caratteri) di Ortogoloso
* gli estremi del cessionario/committente (cioè chi deve pagare la fattura): nome e partita IVA (un codice di 11
  caratteri) dei clienti di Ortogoloso
* una riga per ogni bene venduto/prestazione offerta, che dettaglia il prezzo unitario, la quantità e l'aliquota IVA
* importo, modalità ed estremi del pagamento, ad esempio 1000€ in un'unica soluzione da pagare tramite bonifico al
  codice IBAN

## Requirements

* Maven
* Java17
* MongoDb (A db dump can be found in extra/db)
  ### Use docker compose to install/configure mongodb with Docker
  Open a terminal and move to ..extra/docker directory
  > docker-compose up
  
## How To Run

### IDE (Intellij)
Import and execute extra/intellij runners/GvgApplication.run.xml

### Terminal
Inside the project directory
> mvn clean package
> java -jar target/gvg-0.0.1-SNAPSHOT.jar

### Once app is running ask for all the invoices

> http://localhost:8080/invoice/all

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#using-boot-devtools)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#configuration-metadata-annotation-processor)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
