# eLibraryReinach Documentation
## Assignment for Internet Technology 2023

## Groupmembers
Rahel Häusler @RahelHaeusler <br>
Michèle Fille @mischimel (used to be @michimel) <br>
Jervin Ureath @jervinureath <br>

**Class:** 3b - BIT PT

# 1. Analysis
## Scenario
The commune of Reinach initiated the eLibrary project, which aims to cater to the digital world by offering a web application for accessing a wide range of eBooks. The initial concept included different user categories, such as regular users and administrators, as well as essential security features (login, logout, register). However, the current focus is on creating an MVP (Minimal Viable Product) that provides the administrator's perspective. <br>

As an administrator, the primary objective is to efficiently manage the library's resources. This includes editing or adding members, books, genres, authors, and lending records. To ensure usability, the platform incorporates filtering options, enabling administrators to generate lists based on specific criteria for quickly finding relevant information.  <br>

For future enhancements and improvements, the following features could be considered:  <br>
Users would be required to register and subsequently log in to the eLibrary platform. They could also log out and conveniently manage their profiles. Regular users would have restricted functionality, allowing them to explore comprehensive lists of books, genres, and authors. Additionally, they would have the capability to refine their searches using filters, borrow and return books, and access a personalized list showcasing their currently borrowed books. While the existing list of borrowed objects does not include dates or predefined lending durations, these aspects could also be incorporated in the future. Additionally, in the future, it may be desirable to implement a limitation on the number of members who can borrow a certain book simultaneously. <br>

Overall, the eLibrary project aims to create a user-friendly web application that empowers administrators to efficiently manage library resources. Furthermore, it holds the potential to provide regular users with convenient access to eBooks and lending services in the future.  <br>

## Use case analysis
[Use case diagrams in "lucid.app"](https://lucid.app/lucidchart/ff216cd6-dd92-4284-bdc1-30d08725a5d9/edit?viewport_loc=1733%2C31%2C2219%2C1097%2C0_0&invitationId=inv_ef872c42-5b9f-4504-93fc-5389022cccf9) <br>

### Use Case 100
<img src="https://github.com/michimel/eLibraryReinach/blob/ed246a52d5886551c1cdc1b1fa74d4fe7db40ea6/Documentation%20Sources/Use%20case/Use%20Case%20Diagramm_UC%20100.png"> <br>

**Use case 101 (View Lists)**: An administrator can view a comprehensive lists of books, authors, genres, and members in the library system. <br>
**Use case 102 (Apply Filters)**: An administrator can apply filters to the lists of books, authors, genres, and members to quickly search for specific information. <br>
**Use case 103 (Add New Items)**: An administrator can add new books, authors, genres, and members to the library system. <br>
**Use case 104 (Register Borrowing)**: An administrator can register when a book is borrowed by a member, including recording the relevant details such as the book title and member details. <br>
**Use case 105 (Register Returns)**: An administrator can register when a book is returned by a member and update the borrowing record. <br>
**Use case 106 (Edit Items)**: An administrator can edit the details of books, authors, genres, and members in the library system, ensuring the accuracy and currency of the information. <br>
**Use case 107 (View Borrowed Books)**: An administrator can access a list of all books that are currently borrowed, including information about the members. <br>
**Use case 108 (Search Borrowed Books)**: An administrator can search within the list of all borrowed books using filters to find specific information or specific borrowing records. <br>

## User Story
1.	As an administrator, I want to be able to see all the books, authors, genres, and members in a list. <br>
2.	As an administrator, I want to be able to search for information fast and therefor set filters on these lists. <br>
3.	As an administrator, I want to be able to add new books, authors, genres, and members. <br>
4.	As an administrator, I want to be able to register when a book is borrowed by a member. <br>
5.	As an administrator, I want to be able to register when a book is returned by a member. <br>
6.	As an administrator, I want to be able to edit books, authors, genres, and members. <br>
7.	As an administrator, I want to be able to see a list of all books, which are currently borrowed. <br>
8.	As an administrator, I want to be able to search in the list of all borrowed books via a filter. <br>

# 2. Domain Design 
## Domain Model
[Domain model in "lucid.app"](https://lucid.app/lucidchart/bfa39a78-e2ec-4b1a-b63b-18829cec80c9/edit?beaconFlowId=7134D7D032DE5064&invitationId=inv_0148f8f5-f3f9-433a-8296-e9667492d473&page=0_0#) <br>
We created the following domain model: <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/Domain%20Model/DomainModel%20UML%20CLass%20Diagram.png"> <br> 

### Domain classes
Based on this domain model, we have created the following classes for each entity: <br>

- Author: Represents an author of a book.
- Book: Represents a book in the eLibrary.
- Borrowed: Represents a record of a book being borrowed by a member.
- Genre: Represents a genre or category of books.
- Member: Represents a member of the application. <br>

These domain classes encapsulate the data and behavior associated with each entity, allowing for effective management and manipulation of the application's data. <br>
By organizing the domain logic into separate classes, we promote code modularity and maintainability, making it easier to add or modify features in the future. <br>

### Repository classes
We have also created the corresponding repository classes for each entity: <br>

- AuthorRepository: Manages data operations related to authors.
- BookRepository: Handles data access and storage operations for book entities. 
- BorrowedRepository: Provides data access and storage operations for borrowed entities. 
- GenreRepository: Handles data operations for genre entities.
- MemberRepository: Manages data operations for member entities. <br>

These repository classes extend the JpaRepository interface, which is a part of Spring Data JPA. It provides predefined methods for common data operations, such as finding records by ID or attributes, retrieving all records, and saving or deleting records. These repositories offer methods and functionalities for performing CRUD (Create, Read, Update, Delete) operations on the respective entities. <br>

By separating the data access logic into dedicated repository classes, we achieve better code organization and maintainability. It also allows for easier switching or integration with different data storage technologies in the future. <br>


# 3. Business Logic and API design
## Business Logic
In the MVC (Model-View-Controller) project, the domain, repository, service and controller work together to provide the functionality of the application. <br>

The domain contains the core logic and data models of the application, while the repository provides access to the database. The service contains the business logic and coordinates actions between entities. The controller receives user requests, controls the flow of the application and provides the interface to the user. <br>

These components enable a structured architecture with clear responsibilities and code reusability. The controller calls the service that executes the business logic and accesses the data via the repository. The result is returned to the view, which represents the data and presents it to the user. <br>

In addition, the domain classes and repository classes were explained in Chapter [2. Domain Design](https://github.com/michimel/eLibraryReinach/blob/main/README.md#2-domain-design). Based on these, the service classes and the controller classes were created as follows: <br>

### Service classes
- AuthorService: Responsible for managing authors in the application.
- BookService: Handles the management of books in the application.
- BorrowedService: Manages the borrowing of books by members.
- GenreService: Responsible for managing various genres of books.
- MemberService: Manages members in the application. <br>

### Controller classes
- AuthorController: Handles the requests and operations related to authors in the application.
- BookController: Manages the requests and functionalities associated with books in the application.
- BorrowedController: Handles the requests and processes for borrowing books by members.
- GenreController: Responsible for managing the requests and functionalities related to different book genres.
- MemberController: Manages the requests and operations pertaining to members in the application. <br>

The methods of the service classes will be further explained in Chapter [4. Data and API Implementation](https://github.com/michimel/eLibraryReinach/blob/main/README.md#4-data-and-api-implementation-implementation-of-data-access-and-business-logic-layers-and-api). <br>

## Methods overview
If the access is not only for admins, all have the access rights.

| Entity   | Method  | Path                                                           | Description                                                               | Access only for Admins |
|----------|---------|----------------------------------------------------------------|---------------------------------------------------------------------------|------------------------|
| Author   | GET     | /api/author                                                    | Get all Authors                                                           |                        |
| Author   | POST    | /api/author/newAuthor                                          | Create new Author                                                         | x                      |
| Author   | PUT     | /api/author/updateAuthor/{authorID}                            | Update Existing Author                                                    | x                      |
| Author   | GET     | /api/author/findByFirstName/{firstName}                        | Retrieve Authors by Firstname                                             |                        |
| Author   | GET     | /api/author/findByLastName/{lastName}                          | Retrieve Authors by Lastname                                              |                        |
| Author   | GET     | /api/author/findByFristNameAndLastName/<br>{firstName, lastName}   | Retrieve the Author by Firstname and Lastname                             |                        |
| Author   | GET     | /api/author/findByCountry/{country}                            | Retrieve Authors by Country                                               |                        |
| Book     | GET     | /api/book                                                      | Get all Books                                                             |                        |
| Book     | POST    | /api/book/newBook                                              | Create new Book                                                           | x                      |
| Book     | PUT     | /api/book/updateBook/{bookID}                                  | Update Existing Book                                                      | x                      |
| Book     | GET     | /api/book/findByTitel/{title}                                  | Retrieve Books by Title                                                   |                        |
| Book     | GET     | /api/book/findByIsbn/{isbn}                                    | Retrieve the Book by ISBN                                                 |                        |
| Book     | GET     | /api/book/findByPublishYear/{publishYear}                      | Retrieve Books by PublishYear                                             |                        |
| Book     | GET     | /api/book/findByAuthor/{author}                                | Retrieve Books by Author                                                  |                        |
| Book     | GET     | /api/book/findByGenre/{genre}                                  | Retrieve Books by Genre                                                   |                        |
| Borrowed | GET     | /api/borrowed                                                  | Get all Borrowed                                                          |                        |
| Borrowed | POST    | /api/borrowed/rentBook                                         | Create new Borrowed, meaning rent a book                                  |                        |
| Borrowed | PUT     | /api/borrowed/returnBook/{borrowedID}                          | Update Existing Borrowed, meaning when changed to flase, book is returned |                        |
| Borrowed | GET     | /api/borrowed/findByStatus/{status}                            | Retrieve Borrowed by Status                                               |                        |
| Borrowed | GET     | /api/borrowed/findByBook{book}                                 | Retrieve Borrowed by Book                                                 |                        |
| Borrowed | GET     | /api/borrowed/findByMember/{member}                            | Retrieve Borrowed by Member                                               |                        |
| Borrowed | GET     | /api/borrowed/findByMemberAndStatus/<br>{member}/{status}          | Retrieve Borrowed by Member and Status                                    |                        |
| Borrowed | GET     | /api/borrowed/findByBookAndStatus/{book}/{status}              | Retrieve Borrowed by Book and Status                                      |                        |
| Genre    | GET     | /api/genre                                                     | Get all Genres                                                            |                        |
| Genre    | POST    | /api/genre/newGenre                                            | Create new Genre                                                          | x                      |
| Genre    | PUT     | /api/genre/updateGenre/{genre_id}                              | Update Existing Genre                                                     | x                      |
| Genre    | GET     | /api/genre/findByName/{name}                                   | Retrieve Genres by Name                                                   |                        |
| Member   | GET     | /api/member                                                    | Get all Members                                                           |                        |
| Member   | POST    | /api/member/register                                           | Create new Member, meaning when member registers                          |                        |
| Member   | PUT     | /api/member/editProfile/{memberID}                             | Update Existing Member, meaning when member edits his/her profile         |                        |
| Member   | GET     | /api/member/findByUserName/{userName}                          | Retrieve the Member by Username                                           |                        |
| Member   | GET     | /api/member/findByFirstName/{firstName}                        | Retrieve Members by Firstname                                             |                        |
| Member   | GET     | /api/member/findByLastName/{lastName}                          | Retrieve Members by Lastname                                              |                        |
| Member   | GET     | /api/member/findByFirstNameAndLastName/<br>{firstName}/{lastName}  | Retrieve the Member by Firstname and Lastname                             |                        |
| Member   | GET     | /api/member/findByEmail/{email}                                | Retrieve the Member by Email                                              |                        |
| Member   | GET     | /api/member/findByRole/{role}                                  | Retrieve Members by Role                                                  |                        |

## API design
To test APIs use [this collection](https://galactic-star-276963.postman.co/workspace/Birtney~ebb933fd-cc47-488d-bce0-7eada0cf63ff/collection/26197022-9ec1ab6f-d964-4437-a948-2a0695195da6?action=share&creator=26197022) in Postman in Workspace Birtney. <br>
With the help of the overview of the methods above we created the API design with [Swagger Editor](https://editor.swagger.io/), to see the screenshots of the manually generated documentation, please [click here](https://github.com/michimel/eLibraryReinach/tree/3b81b33020db18d8b5ea230234270ef811b617e7/Documentation%20Sources/API%20(Swagger%20Editor)). <br>
If you want to see or edit the code, you can import the [yaml file](https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/API%20(Swagger%20Editor)/eLibraryAPI.yaml) into Swagger Editor. <br>

### auto generantion from OpenAPI - Swagger
By running our code in codespace and opening  it through the browser via the port 8080, we could let Swagger generate our API documentation. <br> 
Therefor we added "/swagger-ui/index.html#/" to the path in the link, and [this documentation (only working, when code is running)](https://michimel-zany-dollop-976wqw46jqvf9xjx-8080.preview.app.github.dev/swagger-ui/index.html#/) got generated: <br>

<img src="https://github.com/michimel/eLibraryReinach/blob/84210d7a742bea5c492751670a1e7f8f69b63197/Documentation%20Sources/API%20auto%20generated/member-controller.png" width="600"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/3a84de9d21254aaab63a9f5524b5ce83a9c2d74c/Documentation%20Sources/API%20auto%20generated/genre-controller.png" width="600"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/3a84de9d21254aaab63a9f5524b5ce83a9c2d74c/Documentation%20Sources/API%20auto%20generated/borrowed-controller.png" width="600"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/3a84de9d21254aaab63a9f5524b5ce83a9c2d74c/Documentation%20Sources/API%20auto%20generated/book-controller.png" width="600"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/3a84de9d21254aaab63a9f5524b5ce83a9c2d74c/Documentation%20Sources/API%20auto%20generated/author-controller.png" width="600"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/680af2ae61210a50b7485dd0ce4d7e4771fef5ab/Documentation%20Sources/API%20auto%20generated/Schemas%20Member%2C%20Genre%2C%20Borrowed.png" width="600"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/680af2ae61210a50b7485dd0ce4d7e4771fef5ab/Documentation%20Sources/API%20auto%20generated/Schemas%20Book%2C%20Author.png" width="600"> <br>

We did not implement all the APIs in Budibase, as there is the option to add a filter in the design part. With this filter used on the GET mapping "/api/entity" (getAllEntity), the other GET mappings are not needed. <br>

# 4. Data and API implementation 
## Business Logic 
The methods of the different service classes are explained below. Please note that we only explain the methods, which are then actually implemented further. <br>

### AuthorService
- **getAllAuthors()**: Retrieves a list of all authors in the application by calling the findAll() method of the AuthorRepository.
- **createAuthor(author)**: Creates a new author by saving the provided Author object after checking if an author with the same first name and last name already exists. If the author already exists, an exception is thrown.
- **updateAuthor(authorID, authorDetails)**: Updates an existing author by finding the author with the given authorID. If the authorID does not exist, an exception is thrown, otherwise the author is updated with the inputed values from the authorDetails object, if there is no input for a value, the old value is kept. The updated author is then saved. <br>

### BookService
- **getAllBooks()**: Retrieves a list of all books in the application by calling the findAll() method of the BookRepository.
- **createBook(book)**: Creates a new book by saving the provided Book object after performing several checks. It checks if the book with the given ISBN already exists. If not, it checks if the author and genre already exist. If they do not, new author and genre objects are created and saved. Finally, the book is assigned the corresponding author and genre objects, and it is saved. If a book with the same ISBN already exits and exception is thrown. If the author or genre already exits, these objects are assigned to the book, that is being created.
- **updateBook(bookID, bookDetails)**: Updates an existing book by finding the book with the given bookID and updating its details with the values from the bookDetails object, if there is no input for a value, the old value is kept. The updated book is then saved using the save() method of the BookRepository. If the book with the specified bookID is not found the RuntimeException is thrown. <br>

### BorrowedService
- **getAllBorrowed()**: Retrieves a list of all borrowed items in the application by calling the findByStatus(true) method of the BorrowedRepository. It returns only the borrowed items where the status is set to true.
- **createBorrowed(borrowed)**: Creates a new borrowed item by saving the provided Borrowed object after performing several checks. It checks if the book with the specified title and the member with the specified username exist in the database. If they do not, exceptions are thrown. Additionally, it checks if a borrowed item with the same book title and member username already exists in the database and has a status of true, indicating it is currently borrowed. If such an item is found, an exception is thrown to prevent duplicate borrowings. Finally, the status of the borrowed item is set to true, indicating it is currently borrowed. The book and member objects are assigned to the borrowed item, and it is saved in the database.
- **updateBorrowed(borrowedID, borrowedDetails)**: Updates an existing borrowed item by finding it with the given borrowedID. If the borrowedID does not exist, an exception is thrown, otherwise the status of the borrowed item is set to false. The updated borrowed item is then saved and will no longer appear in the borrowed list, as there only items with status set to true get indicated. <br>

### GenreService
- **getAllGenres()**: Retrieves a list of all genres in the application by calling the findAll() method of the GenreRepository. It returns all existing genres.
- **createGenre(genre)**: Creates a new genre by saving the provided Genre object after performing the following check. It checks if the genre with the given name already exists in the database. If it does not, the genre is saved, but if the genre already exists, an exception is thrown with an appropriate message.
- **updateGenre(genreID, genreDetails)**: Updates an existing genre by finding the genre with the given genreID and updating its name with the value from the genreDetails object, in case no value is inputted the old one is kept. The updated genre is then saved. If the genre with the specified genreID is not found the RuntimeException is thrown. <br>

### MemberService
- **getAllMembers()**: Retrieves a list of all members in the application by calling the findAll() method of the MemberRepository. It returns all existing members and shows all the details, except the password.
- **createMember(member)**: Creates a new member by saving the provided Member object after performing the following check. It checks if a member with the given username and email already exists in the database. If neither the username nor the email is found, the member is saved using the save() method of the MemberRepository. If the member already exists, an exception is thrown with an appropriate message.
- **updateMember(memberID, memberDetails)**: Updates an existing member by finding the member with the given memberID and updating its attributes (username, first name, last name, email, and password) with the values from the memberDetails object, if there is no input for a value, the old value is kept. The updated member is then saved and the changes can be seen, except for the password, which will not be shown. If the member with the specified memberID is not found the RuntimeException is thrown. <br>

# 5. Frontend implementation
## Mock up - prototyping
[Mock up in OneNote](https://fhnw365.sharepoint.com/teams/ItsBirtneyBi_M365/_layouts/15/Doc.aspx?sourcedoc={9d183143-397c-48b8-b9a4-4d5389579d70}&action=edit&wd=target%28Untitled%20Section.one%7C2f1487b2-dcc6-45fd-bab3-b7bd08c83f6c%2FMock%20up%7C39605bfe-29cb-41e5-a10c-099c5f7e5d0a%2F%29&wdorigin=703) <br>

To get a better understanding of the assignment, and to visualise our ideas and views, we have created the following mock-up. As the content of the assignment got adjusted, we did not implement the complete mock up, only parts of it as the MVP is about the administraor's perspective. Also we did adapt the design in the final application. <br>

The following image shows the complete mock up: <br>
<img src="https://github.com/mischimel/eLibraryReinach/blob/875960415cb00c82f5433d245d8c44956383cba5/Documentation%20Sources/Mock%20up/1%20complete%20mock%20up.png"> <br>

In order to read and view the mock up better, we prepared images of the individual sections in the following images: <br>
This images shows how the start page, including the login, the page to register for an user account, and the pages for the user. The pages for the user shown here are, the page "books", where users can search for a book, the page when a specific book got selected, here users can rent the book, and the page "my borrowed books", where the users see the history of all their books currently on loan, or the ones they have borrowed and already return in a list view. <br>
<img src="https://github.com/mischimel/eLibraryReinach/blob/c1f635c5a3c69917edeccdeb0c863092d05c2c82/Documentation%20Sources/Mock%20up/2%20start(login)%2C%20register%2C%20user(books%20and%20book%20search%2C%20book%20view%2C%20my%20borrowed%20books%20list).png"> <br>

This images shows pages for user, which are the page "profile", where users can edit or delete their profile, and again the start page, which appreas after the log out. <br>
<img src="https://github.com/mischimel/eLibraryReinach/blob/65735a3b8c2741e8299154a76a7851c95de91c52/Documentation%20Sources/Mock%20up/3%20user(profile%2C%20logout).png"> <br>

The following images shows the pages only for administrators, as they have additional functionalities compared to the user. The images shows the page "books", where admins can add books, the page when a specific book got selected, where admins can edit or delete the book, and the page "my borrowed books".
<img src="https://github.com/mischimel/eLibraryReinach/blob/c1f635c5a3c69917edeccdeb0c863092d05c2c82/Documentation%20Sources/Mock%20up/4%20admin(books%20and%20book%20search%2C%20book%20view%2C%20my%20borrowed%20books%20list).png"> <br>

This image shows more pages for administrators. The page "all borrowed books" returns the history of all books currently beeing borrowed and the books that are already returned, including the username of the user who had borrowed the book. The page "profile", and again the start page, which comes up after the logout.
<img src="https://github.com/mischimel/eLibraryReinach/blob/c1f635c5a3c69917edeccdeb0c863092d05c2c82/Documentation%20Sources/Mock%20up/5%20admin(all%20borrowed%20books%2C%20profile%2C%20logout).png"> <br>

The following picture gives some information about the colours used in the mock up and also more ideas for possible (further) improvements can be seen.
<img src="https://github.com/mischimel/eLibraryReinach/blob/c1f635c5a3c69917edeccdeb0c863092d05c2c82/Documentation%20Sources/Mock%20up/6%20info%2C%20improvements.png"> <br>

## Realization of frontend functionality 
- Budibase's app Export file can be found [here](https://github.com/michimel/eLibraryReinach/tree/9c02526f02d82ef170e060e5266b8a51508a4431/Documentation%20Sources/Budibase%20App%20Export) <br>
- Link to the published Web-App of the eLibrary of Reinach: https://inttech.budibase.app/app/elibrary

# 6. Demonstrator
This [YouTube video](https://youtu.be/M_JV_BYCd-s) shows the published web application, demonstates, and explains the functonalities of the web application.
