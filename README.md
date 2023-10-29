Spring MVC for the web application
Spring Data for data access
Spring Security for authentication and authorization

This versatility comes at a cost. Setting up a Spring application requires a lot of configuration.
Spring Boot makes working with Spring much simpler.It comes with many pre-configured settings and dependencies that are commonly used in Spring applications.Comes with an embedded web server, so you can easily create and deploy web applications without needing an external server.

Spring Boot takes advantage of Spring Core’s Inversion of Control (IoC) container.Dependency injections is a way to achieve inversion of control.

Generate a complete, ready-to-run Spring Boot application with Spring Initializr.

TDD - tests are writen before the code

====================== 2: Testing the Data Contract ============================

====================== Implementing GET =============================
What is REST? - Архитектурен стил за разработката на web приложения.
Обектите в контекста на RESTful приложение се наричат resource representations и най-често се съхраняват в някакъв persistent storage.
REST ни позволява да достъпваме и манипулираме тези ресурси чрез http заявки.

CRUD - Create,Read,Update,Delete са базовите операции ,които можем да изпълняваме върху обекти в data storage-a.
REST има правила за имплементирането на тези операции в web application-a.

Как протича една Rest заявка? - Клиентът изпраща заявка към URI ,web server-ът я получава и я пренасочва към request handler.Handler-a създава Response и го връща на клиента.
Всеки request има http метод, URI(Endpoint) ,body
Всеки response има status code и body.

===
Spring ни помага с инстанцирането и конфигурирането на обекти.Тези обекти се наричат Sprint Bean-ове и обикновенно се създават от Spring(вместо да използваме new).
Начини да укажем на Spring как да създава bean-ове.

Анотирайки клас със Spring анотация ще кажем на Spring да създаде инстанция на класа по време на Component Scan фазата, която протича при стартиране на application-a.Създаденият bean се съхранява в Spring IoC контейнера и може да бъде inject-нат там където е нужен. 

@RestController - посочва ,че класът е Component от тип RestController
Заявките се handle-ват от Controller-и ,класове анотирани с @RestController.Controller-ите слушат за HTTP заявки.Controller-ите се inject-ват в spring web.
Контролерите имат handler методи, които се извикват при получаването на "matching request".

@GetMapping анотацията маркира handler метод

	@GetMapping("/cashcards/{requestedId}")
	public ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
	     CashCard cashCard = /* Here would be the code to retrieve the CashCard */;
		 return ResponseEntity.ok(cashCard);
	}
	
{requestedId} от GetMapping анотацията се мапва към requestId параметъра чрез @PathVariable анотацията.
handler метода връща ResponseEntity от тип CashCard със статус код 200.

===================== Repositories & Spring Data ===========================
Spring Data улеснява интеграцията на application-a с базата.Repository-то е interface-ът между app-a и базата.
Според Separation of Concerns принципа ,добре прокетираният софтуер трябва да е модулярен,като всеки модул отговаря за отделна функционалност.
Controller-a е абстракция на web interface.
Repository-то чете и пише в базата.

Layered Structure в Spring Boot app:....

//JDBC (the standard Java library for database connectivity)

Предимства и недостатъци при използването на in-memory db за тестове:
	+ Еднакъв state на базата при всеки run на тестовете
	- Dev-Prod parity mismatch ,апп-а може да се държи различно когато използва in-memory db вместо persistent db
	
H2 - in memory db
Spring Boot automatically configures Spring Data to speak to H2 just by adding Spring Data and H2 dependencies

Дефинирайки interface extend-ващ CrudRepository интерфейса можем да ипълняваме базовите CRUD операции, представени чрез предефинирани методи в CrudRepository.
Spring Data имплементира нашия и CrudRepository интерфейса по време на стартирането на IoC контейнера.След това Spring runtime expose-ва repository-то като нов bean, който ще можем да използваме където искаме в app-a. 

============== Lab: Repositories & Spring Data ===============
Web Controller should not manage data. This is a violation of Separation of Concerns.

ORM (object relational mapping) - мапване на обект към данни в базата и обратното
Spring Data разполага с много имплементации на релационни и нерелационни бази.Също така осигурява Object-Relational Mapping capabilities on top of these impls.
JDBC is an API and H2 е база имплементираща JDBC.
