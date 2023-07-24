# Internet Technology Assignment

## Introduction

A few people I've spoken to have had trouble creating their Swagger stuff, their Controllers, and their Services.  This short document should outline how you can create them quickly using GitHub Copilot and ChatGPT.  It won't look at security or front-end stuff.

In summary, you're going to have four files for each Entity:

1. Entity
2. Repository
3. Service
4. Controller

### Entity

The Entity is your domain, or class, or table in your database.  It contains all the attributes associated with that property, any relationships with other Entities (i.e. foreign keys), and constructors, getters, and setters.  90% of this can be created using GitHub Copilot.

### Repository

The Repository contains methods for looking up records of your Entity in the database.  Our group found that GitHub Copilot wasn't creating all the necessary methods, so we wrote ours manually.  Ultimately, it should contain a 'findAll' method to return all records of the Entity, and then 'findByXXX' methods for each attribute your Entity has.

### Service

The Service is kind of what does all of the work.  It should contain methods for returning records, using the methods defined in Repository, or creating or updating records, using the constructors and setters defined in the Entity.  ChatGPT should be able to generate most of this for you.

### Controller

The Controller is where all the REST API shit takes place.  It defines the REST API endpoints that users or the front-end interact with to create, update, read, or delete data from the database.  It does this by passing REST requests to the Service.

So hopefully now you see how the application goes together ...

### GET

1. A user or the application makes a GET REST request into the Controller
2. The Controller passes the payload into a function in the Service
3. The Service passes the payload into a function in the Repository
4. The Repository accesses the Database that was generated using the Entity

### POST

1. A user or the application makes a POST REST request into the Controller
2. The Controller passes the payload into a function in the Service
3. The Service passes the payload into the constructor in the Entity
4. The Entity creates a new record in the Database that was generated using the Entity

### PUT / DELETE

I'm sure you can figure these ones out at this point.

So where do you start ...

## 1. Create your Entities

After you've planned out your application, start by creating your Domains / Entities.  These will contains each of the attributes associated with the Entity, relevant annotations, constructors, getters, and setters.

GitHub Copilot can do 90% of this for you.  The hard parts are when you start having relationships between different Entities using the `@OneToOne`, `@OneToMany`, and `@ManyToOne` relationships.  But you can deal with that later.

Here is an example of a 'Studio' Entity.  It represents a studio that creates weeby anime shit.

We start with our package details and imports, which every Class has.

```java
package ch.fhnw.anime.data.domain;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
```
Next, we have our attributes, which we've generated using a comment to prompt GitHub Copilot.

We have an ID, which is a unique auto-generated identifier for each record, then we have the name of the studio, the location, the founding year, and, finally, a `@OneToMany` relationship with Anime to map the studio with the weeby anime shit they have produced.

```java
//generate a jpa entity Studio with the attributes id,Name,Location, foundingYear, and a one to many relationship to Anime

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "studio")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private int foundingYear;
    @OneToMany(targetEntity = Anime.class, mappedBy = "studio", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Anime> animes;
```

We then have our two constructors, one with no attributes and one with all the attributes (other than the Anime reference).

```java
    public Studio() {
    }

    // generate constructor
    public Studio(String name, String location, int foundingYear) {
        this.name = name;
        this.location = location;
        this.foundingYear = foundingYear;
    }
```

Finally, we have our Getters and Setters.  Again, GitHub Copilot has created these for us.

```java
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }
}
```
Do this for each of your Entities.  At this point, you don't have to worry so much about the `@OneToOne`, `@OneToMany`, or `@ManyToOne` stuff.  If it's wrong, the database will complain when it tries to build the project.  But you can fix this later.

## 2. Create your Repositories
Theoretically, GitHub Copilot should be able to create your Repository using a prompt like `Generate a JPA Repository for the class Studio`, but our group found that the results were incomplete.  Thankfully, the Repository is super short, so you can just create it yourself.

Here is our example for StudioRepository:

```java
package ch.fhnw.anime.data.repository;

import ch.fhnw.anime.data.domain.Studio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio, Long> {
    List<Studio> findAll();
    Studio findById(String id);
    Studio findByName(String name);
    List<Studio> findByLocation(String location);
    List<Studio> findByFoundingYear(Integer foundingyear);
}
```

It's nothing complicated.  Basically, you want to have a `findAll()` method with data type `List<Entity>`, which will return all records.  You then want subsequent `findByXXX()` methods for each attribute in your Entity.

Think about whether the attribute will be unique in your database; if the attribute is unique, you will only need to return one record.  If your attribute is not unique, you will want to return a list of records.  `ID` should be unique so the data type is just `Studio`, but, in our example, `foundingyear` may not be unique, so we return `List<Studio>`.

## 3. Swagger Schemas
Swagger stuff basically has three parts:

1. Info / Description
2. Paths
3. Schemas

Info is the basic information about your project, Paths is all the REST API endpoints, and Schemas outlines the details for each of your Entities.

When constructing the Swagger stuff for your project, fill out the Info and then start generating the Schemas.  This is where ChatGPT comes in.

The prompt I used for generating a Schema for our Studio Entity is as follows:

```
Based on the following Spring Boot entity for Studio, create a Swagger OAS3 snippet for the schema:

@Table(name = "studio")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private int foundingYear;
    @OneToMany(targetEntity = Anime.class, mappedBy = "studio", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Anime> animes;
```

You can see that I have given it a basic prompt and provided it with a section of my Studio.java Entity.  This is all the information ChatGPT requires to create the Schema for the class:

>Certainly! Here's the Swagger/OpenAPI 3.0 snippet for the Studio entity:
>```yaml
>yaml
>
>components:
>  schemas:
>    Studio:
>      type: object
>      properties:
>        id:
>          type: integer
>          format: int64
>        name:
>          type: string
>        location:
>          type: string
>        foundingYear:
>          type: integer
>          format: int32
>        animes:
>          type: array
>          items:
>            $ref: '#/components/schemas/Anime'
>
>    Anime:
>      type: object
>      properties:
>        id:
>          type: integer
>          format: int64
>        title:
>          type: string
>        genre:
>          type: string
>        studio:
>          $ref: '#/components/schemas/Studio'
>```
>In this snippet, I've defined the `Studio` schema and the `Anime` schema. The `Studio` schema corresponds to your `Studio` entity, while the `Anime` schema represents the associated `Anime` entity.
>
>The `Studio` schema has properties such as `id`, `name`, `location`, `foundingYear`, and `animes`. The `id` property is an integer of type `int64`, while the `foundingYear` property is an integer of type `int32`. The `animes` property is an array of Anime objects.
>
>The `Anime` schema has properties like `id`, `title`, `genre`, and `studio`. The `studio` property is a reference to the `Studio` schema, representing the relationship between `Studio` and `Anime` entities.
>
>Feel free to adjust the snippet as per your specific requirements or naming conventions.

Because of the `@OneToMany` relationship that our Studio has with Anime, ChatGPT has also created a schema for our Anime Entity based on what it thinks the Anime Entity will contain.  While it has gotten it's assumptions wrong, this isn't a problem because we'll replace that when we repeat the above process for our Anime Entity.

Once you've worked through all of your Entities, you'll have what you need to create your Paths.  But, before that, we can expand on the Schemas a bit.

## 4. Swagger Schemas (Optional)

Two additional sections you can add to your Swagger Schemas are `required:` and `example:`.

### `required:`

Adding a `required` block will flag attributes as required or not, basically showing that the attributes need to be supplied to create a record for an Entity.  This block doesn't change anything in the code, but it looks good in the documentation.

Add `required:` to your YAML below the last attribute in each schema, at the same level as `properties:`, and then add each attribute you want to be required within the Entity, e.g.:

```yaml
    Studio:
      type: object
      properties:
        id:
          type: integer
          format: int64
          description: The unique identifier for the studio
        name:
        ...
      required:
        - name
        - location
        - foundingYear
```

### `examples:`

Adding an `examples:` block will let you show example records for each Entity.  It can be useful for testing later as you can just copy the example from the Swagger documentation into Postman to test that your REST API endpoints work.

You can generate these with ChatGPT using the following prompt:

```
Based on the following Swagger OAS3 Schema for Studios, generate an 'examples' Swagger snippet based on Studio Ghibli:

schemas:
  Studio:
    type: object
    properties:
      id:
        type: integer
        format: int64
      name:
        type: string
      location:
        type: string
      foundingYear:
        type: integer
        format: int32
      animes:
        type: array
        items:
          $ref: '#/components/schemas/Anime'
```
>Certainly! Here's an example Swagger snippet based on Studio Ghibli for the Studio schema using the provided Swagger OAS3 schema:
>```yaml
>yaml
>
>components:
>  schemas:
>    Studio:
>      type: object
>      properties:
>        id:
>          type: integer
>          format: int64
>        name:
>          type: string
>        location:
>          type: string
>        foundingYear:
>          type: integer
>          format: int32
>        animes:
>          type: array
>          items:
>            $ref: '#/components/schemas/Anime'
>  examples:
>    StudioGhibli:
>      value:
>        id: 1
>        name: Studio Ghibli
>        location: Tokyo, Japan
>        foundingYear: 1985
>        animes:
>          - id: 1
>            title: Spirited Away
>            genre: Fantasy
>            studio:
>              $ref: '#/components/examples/StudioGhibli/value'
>          - id: 2
>            title: My Neighbor Totoro
>            genre: Fantasy
>            studio:
>              $ref: '#/components/examples/StudioGhibli/value'
>```
>In the above example, I've defined the Studio schema based on the provided Swagger OAS3 schema. Additionally, I've added an example called StudioGhibli, which represents a sample instance of the Studio entity using Studio Ghibli as the example.
>
>The StudioGhibli example includes the id, name, location, foundingYear, and animes properties. The animes property is an array containing two sample anime objects (Spirited Away and My Neighbor Totoro), each having their respective id, title, genre, and a reference to the StudioGhibli example.
>
>Feel free to modify the example or add more examples based on your specific requirements or additional properties of the Studio entity.

Add this block to your Swagger YAML, at the end of your Schema block for the Entity, at same level as `properties:` and `required:`, as shown in the ChatGPT response.

Note that it's best to do this after you've created all of your Schemas, that way you can have any foreign keys populated correctly.

## 5. Swagger Paths

Paths represent the REST API Endpoints your application will expose.  For this, we will need to provide ChatGPT with the Schemas it has previously generated, the methods in your Repository, and a table containing the REST API endpoints you would like to implement.

Open up Notepad or another text editor and create a plain text table containing the methods you want to implement, along with their paths and a description e.g.:

```
Method | Path | Description
GET | /api/studio | Get all Studios
POST | /api/studio | Create new Studio
PUT | /api/studio/{id} | Update existing Studio
DELETE | /api/studio/{id} | Delete existing Studio
GET | /api/studio/findByName/{name} | Retrieve Studios by name
GET | /api/studio/findByLocation/{location} | Retrieve Studios by location
GET | /api/studio/findByFoundingYear/{foundingyear} | Retrieve Studios by founding year
```

With this, we can now create a new prompt for ChatGPT:

```
Based on the following Swagger Schema for Studio:

schemas:
  Studio:
    type: object
    properties:
      id:
        type: integer
        format: int64
      name:
        type: string
      location:
        type: string
      foundingYear:
        type: integer
        format: int32
      animes:
        type: array
        items:
          $ref: '#/components/schemas/Anime'

And based on the following Spring Boot Repository for Studio:

    List<Studio> findAll();
    Studio findById(String id);
    Studio findByName(String name);
    List<Studio> findByLocation(String location);
    List<Studio> findByFoundingYear(Integer foundingyear);

Create a Swagger OAS3 snippet for the following methods:

Method | Path | Description
GET | /api/studio | Get all Studios
POST | /api/studio | Create new Studio
PUT | /api/studio/{id} | Update existing Studio
DELETE | /api/studio/{id} | Delete existing Studio
GET | /api/studio/findByName/{name} | Retrieve Studios by name
GET | /api/studio/findByLocation/{location} | Retrieve Studios by location
GET | /api/studio/findByFoundingYear/{foundingyear} | Retrieve Studios by founding year
```

>Here's the Swagger/OAS3 snippet for the specified methods based on the given Spring Boot repository and the Swagger schema for the Studio entity:
>```yaml
>yaml
>
>paths:
>  /api/studio:
>    get:
>      summary: Get all Studios
>      operationId: getAllStudios
>      responses:
>        '200':
>          description: OK
>          content:
>            application/json:
>              schema:
>                type: array
>                items:
>                  $ref: '#/components/schemas/Studio'
>    post:
>      summary: Create new Studio
>      operationId: createStudio
>      requestBody:
>        required: true
>        content:
>          application/json:
>            schema:
>              $ref: '#/components/schemas/Studio'
>      responses:
>        '200':
>          description: OK
>          content:
>            application/json:
>              schema:
>                $ref: '#/components/schemas/Studio'
>
>  /api/studio/{id}:
>    put:
>      summary: Update Existing Studio
>      operationId: updateStudio
>      parameters:
>        - name: id
>          in: path
>          description: ID of the Studio to update
>          required: true
>          schema:
>            type: string
>      requestBody:
>        required: true
>        content:
>          application/json:
>            schema:
>              $ref: '#/components/schemas/Studio'
>      responses:
>        '200':
>          description: OK
>          content:
>            application/json:
>              schema:
>                $ref: '#/components/schemas/Studio'
>    delete:
>      summary: Delete existing Studio
>      operationId: deleteStudio
>      parameters:
>        - name: id
>          in: path
>          description: ID of the Studio to delete
>          required: true
>          schema:
>            type: string
>      responses:
>        '204':
>          description: No Content
>
>  /api/studio/findByName/{name}:
>    get:
>      summary: Retrieve Studios by name
>      operationId: getStudiosByName
>      parameters:
>        - name: name
>          in: path
>          description: Name of the Studio to retrieve
>          required: true
>          schema:
>            type: string
>      responses:
>        '200':
>          description: OK
>          content:
>            application/json:
>              schema:
>                type: array
>                items:
>                  $ref: '#/components/schemas/Studio'
>
>  /api/studio/findByLocation/{location}:
>    get:
>      summary: Retrieve Studios by location
>      operationId: getStudiosByLocation
>      parameters:
>        - name: location
>          in: path
>          description: Location of the Studio to retrieve
>          required: true
>          schema:
>            type: string
>      responses:
>        '200':
>          description: OK
>          content:
>            application/json:
>              schema:
>                type: array
>                items:
>                  $ref: '#/components/schemas/Studio'
>
>  /api/studio/findByFoundingYear/{foundingyear}:
>    get:
>      summary: Retrieve Studios by founding year
>      operationId: getStudiosByFoundingYear
>      parameters:
>        - name: foundingyear
>          in: path
>          description: Founding year of the Studios to retrieve
>          required: true
>          schema:
>            type: integer
>            format: int32
>      responses:
>        '200':
>          description: OK
>          content:
>            application/json:
>              schema:
>                type: array
>                items:
>                  $ref: '#/components/schemas/Studio'
>```
>In this snippet, I've defined the Swagger/OAS3 paths for the specified methods. Each path includes the necessary information such as the HTTP method, path, summary, operationId, parameters (if applicable), request bodies (if applicable), and response definitions.
>
>Please note that the operationId values I provided are placeholders. You can replace them with appropriate names based on your application's naming conventions.
>
>Feel free to adjust the snippet as per your specific requirements or any additional details needed for the endpoints.

Copy paste this into your Swagger YAML, above the Schemas, and repeat again for each of your Entities.

## 6. Create your Services and Controllers

The final two files are the Services and Controllers.  At this point, ChatGPT had proven more useful than GitHub Copilot, so I didn't even bother seeing what that would produce for me.

The Service and Controllers should include a function for each REST API endpoint created in the previous step, so the ChatGPT prompt is basically the same prompt used to create the paths:

```
Based on the following Swagger Schema for Studio:

schemas:
  Studio:
    type: object
    properties:
      id:
        type: integer
        format: int64
      name:
        type: string
      location:
        type: string
      foundingYear:
        type: integer
        format: int32
      animes:
        type: array
        items:
          $ref: '#/components/schemas/Anime'

, the following Spring Boot Repository for Studio:

    List<Studio> findAll();
    Studio findById(String id);
    Studio findByName(String name);
    List<Studio> findByLocation(String location);
    List<Studio> findByFoundingYear(Integer foundingyear);

, and the following REST API methods:

Method | Path | Description
GET | /api/studio | Get all Studios
POST | /api/studio | Create new Studio
PUT | /api/studio/{id} | Update existing Studio
DELETE | /api/studio/{id} | Delete existing Studio
GET | /api/studio/findByName/{name} | Retrieve Studios by name
GET | /api/studio/findByLocation/{location} | Retrieve Studios by location
GET | /api/studio/findByFoundingYear/{foundingyear} | Retrieve Studios by founding year

Create a Spring Boot Service and Controller for Studios.
```

>Sure! Here's an example of how you can create a Spring Boot service and controller for the Studios based on the provided Swagger schema and REST API methods:
>
>First, let's create the StudioService class:
>```java
>java
>
>@Service
>public class StudioService {
>    private final StudioRepository studioRepository;
>
>    public StudioService(StudioRepository studioRepository) {
>        this.studioRepository = studioRepository;
>    }
>
>    public List<Studio> getAllStudios() {
>        return studioRepository.findAll();
>    }
>
>    public Studio createStudio(Studio studio) {
>        return studioRepository.save(studio);
>    }
>
>    public Studio updateStudio(Long id, Studio studio) {
>        Studio existingStudio = studioRepository.findById(id)
>                .orElseThrow(() -> new NotFoundException("Studio not found with id: " + id));
>
>        existingStudio.setName(studio.getName());
>        existingStudio.setLocation(studio.getLocation());
>        existingStudio.setFoundingYear(studio.getFoundingYear());
>        // Update any other properties as needed
>
>        return studioRepository.save(existingStudio);
>    }
>
>    public void deleteStudio(Long id) {
>        studioRepository.deleteById(id);
>    }
>
>    public List<Studio> getStudiosByName(String name) {
>        return studioRepository.findByName(name);
>    }
>
>    public List<Studio> getStudiosByLocation(String location) {
>        return studioRepository.findByLocation(location);
>    }
>
>    public List<Studio> getStudiosByFoundingYear(Integer foundingYear) {
>        return studioRepository.findByFoundingYear(foundingYear);
>    }
>}
>```
>Next, let's create the StudioController class:
>```java
>java
>
>@RestController
>@RequestMapping("/api/studio")
>public class StudioController {
>    private final StudioService studioService;
>
>    public StudioController(StudioService studioService) {
>        this.studioService = studioService;
>    }
>
>    @GetMapping
>    public List<Studio> getAllStudios() {
>        return studioService.getAllStudios();
>    }
>
>    @PostMapping
>    public Studio createStudio(@RequestBody Studio studio) {
>        return studioService.createStudio(studio);
>    }
>
>    @PutMapping("/{id}")
>    public Studio updateStudio(@PathVariable Long id, @RequestBody Studio studio) {
>        return studioService.updateStudio(id, studio);
>    }
>
>    @DeleteMapping("/{id}")
>    public void deleteStudio(@PathVariable Long id) {
>        studioService.deleteStudio(id);
>    }
>
>    @GetMapping("/findByName/{name}")
>    public List<Studio> getStudiosByName(@PathVariable String name) {
>        return studioService.getStudiosByName(name);
>    }
>
>    @GetMapping("/findByLocation/{location}")
>    public List<Studio> getStudiosByLocation(@PathVariable String location) {
>        return studioService.getStudiosByLocation(location);
>    }
>
>    @GetMapping("/findByFoundingYear/{foundingyear}")
>    public List<Studio> getStudiosByFoundingYear(@PathVariable Integer foundingYear) {
>        return studioService.getStudiosByFoundingYear(foundingYear);
>    }
>}
>```
>In the above code, the StudioService class handles the business logic for performing CRUD operations on the Studio entity using the StudioRepository.
>
>The StudioController class defines the REST API endpoints for the specified methods. Each method is mapped to its corresponding HTTP method and path, and it delegates the request to the corresponding method in the StudioService class.
>
>Please note that you'll need to have the StudioRepository interface implemented with the appropriate methods in order to interact with the database. Additionally, make sure to configure the necessary dependencies and annotations such as @Service, @Repository, and database connectivity settings.
>
>Feel free to modify the code based on your specific requirements and naming conventions.

You'll need to manually add the correct imports, but this should mostly function correctly.

Repeat for each of your Entities, and 90% of your back-end should be complete!

### 7. Seeding your database

I think in the last lecture, Devid went through how to seed the database with data.  For this, open up your application's main class.  In our case, the application is called `Anime`, so the class is called `AnimeApplication.java`.

Below your `public static void main(String[] args)` block, you'll want to initialise the Repository for the Entity you want to seed data for:

```java
@Autowired
private StudioRepository studioRepository;
```

Next, you need to create a function containing the data you wish to seed, and annotate it with `@EventListener`:

```java
@EventListener(ApplicationReadyEvent.class)
public void seedDatabase() {
    ...
}
```

Now we head back to ChatGPT with a prompt including your Swagger scehma and the code you just wrote above:

```
Based on the following Swagger Schema for Studio:

schemas:
  Studio:
    type: object
    properties:
      id:
        type: integer
        format: int64
      name:
        type: string
      location:
        type: string
      foundingYear:
        type: integer
        format: int32

Replace the comment '// FILL IN HERE' with code to generate a Studio object for Studio Ghibli:

@Autowired
private StudioRepository studioRepository;

@EventListener(ApplicationReadyEvent.class)
public void seedDatabase() {
    // FILL IN HERE
}
```
>Certainly! Here's the updated code to generate a Studio object for Studio Ghibli using the provided Swagger schema:
>```java
>java
>
>@Autowired
>private StudioRepository studioRepository;
>
>@EventListener(ApplicationReadyEvent.class)
>public void seedDatabase() {
>    Studio studio = new Studio();
>    studio.setName("Studio Ghibli");
>    studio.setLocation("Tokyo, Japan");
>    studio.setFoundingYear(1985);
>
>    studioRepository.save(studio);
>}
>```
>In the code above, the `seedDatabase()` method is an event listener that gets triggered when the application is ready. Inside this method, a `Studio` object is created and its properties are set to match the values for Studio Ghibli. The `studioRepository` is then used to save the `Studio` object to the database.
>
>Make sure you have the `StudioRepository` properly configured and autowired in your application. This code assumes that the database connection and repository setup are in place.
>
>Feel free to modify the code based on your specific requirements or additional properties of the `Studio` entity.

Repeat this for all your Entities and now, when you load up your application, records will be created in your database.

If you're creating mulitple records for each entity, make sure you change the name of the Entity object you create, e.g. if I wanted to seed the database with two studios, I'd declare the first using `Studio studio1 = new Studio();` and the second using `Studio studio2 = new Studio();`.

Also, think about your data model and the relationships between your entities.  In the Studio schema earlier, I had a `@OneToMany` relationship between Studio and Anime, but I haven't included any Anime records in this object.  This is because I'll instead include a reference to the Studio record in each Anime; the application is smart enough to figure this out.

### Database Persistence

To add a note to this section, in the last lecture, we were shown some properties you could enter into your `application.properties` file to configure your database.  The code we were shown looked something like this:

```
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.url=jdbc:h2:file:./data/database
spring.jpa.hibernate.ddl-auto = create-drop
```

One important thing to note here is the final line; make sure you set `spring.jpa.hibernate.ddl-auto` to `create-drop`.

This will drop the contents of the database every time the database runs.  If you don't do this, the data in your database will persist and you'll end up duplicating the records specified in your main class every time you run the application.