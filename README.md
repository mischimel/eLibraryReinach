# eLibraryReinach Documentation
## Assignment for Internet Technology 2023

## Groupmembers:
Mara Garbellini @marallini ??? <br>
Rahel Häusler @RahelHaeusler <br>
Michèle Fille @michimel <br>
Jervin Ureath @jervinureath <br>

**Class:** 3b - BIT PT

To create transparency, we have specified the author @github username in the respective Java classes and also in the sections of the documentation.

Format: https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet

# 1. Analysis *Scenario ideation, use case analysis and user story writing*
## Scenario
author @michimel <br>
The commune of Reinach initiated the eLibrary project, which aims to cater to the digital world by offering a web application for accessing a wide range of eBooks. The initial concept included different user categories, such as regular users and administrators, as well as essential security features (login, logout, register). However, the current focus is on creating an MVP (Minimal Viable Product) that provides the administrator's perspective. <br>

As an administrator, the primary objective is to efficiently manage the library's resources. This includes editing or adding members, books, genres, authors, and lending records. To ensure usability, the platform incorporates filtering options, enabling administrators to generate lists based on specific criteria for quickly finding relevant information.  <br>

For future enhancements and improvements, the following features could be considered:  <br>
Users would be required to register and subsequently log in to the eLibrary platform. They could also log out and conveniently manage their profiles. Regular users would have restricted functionality, allowing them to explore comprehensive lists of books, genres, and authors. Additionally, they would have the capability to refine their searches using filters, borrow and return books, and access a personalized list showcasing their currently borrowed books. While the existing list of borrowed objects does not include dates or predefined lending durations, these aspects could also be incorporated in the future. Additionally, in the future, it may be desirable to implement a limitation on the number of members who can borrow a certain book simultaneously. <br>

Overall, the eLibrary project aims to create a user-friendly web application that empowers administrators to efficiently manage library resources. Furthermore, it holds the potential to provide regular users with convenient access to eBooks and lending services in the future.  <br>

## Use case analysis
author @michimel <br>
Link to the use case diagrams: https://lucid.app/lucidchart/ff216cd6-dd92-4284-bdc1-30d08725a5d9/edit?viewport_loc=1733%2C31%2C2219%2C1097%2C0_0&invitationId=inv_ef872c42-5b9f-4504-93fc-5389022cccf9 <br>

### Use Case 100
<img src="https://github.com/michimel/eLibraryReinach/blob/34343ab640679f54432c40b761f5b7a9d37d6654/Documentation%20Sources/Use%20case/Use%20Case%20Diagramm%20UC%20100.png"> <br>

**Use case 101 (View Lists)**: An administrator can view comprehensive lists of books, authors, genres, and members in the library system. <br>
**Use case 102 (Apply Filters)**: An administrator can apply filters to the lists of books, authors, genres, and members to quickly search for specific information. <br>
**Use case 103 (Add New Items)**: An administrator can add new books, authors, genres, and members to the library system. <br>
**Use case 104 (Register Borrowing)**: An administrator can register when a book is borrowed by a member, including recording the relevant details such as the book title and member details. <br>
**Use case 105 (Register Returns)**: An administrator can register when a book is returned by a member and update the borrowing record. <br>
**Use case 106 (Edit Items)**: An administrator can edit the details of books, authors, genres, and members in the library system, ensuring the accuracy and currency of the information. <br>
**Use case 107 (View Borrowed Books)**: An administrator can access a list of all books that are currently borrowed, including information about the members. <br>
**Use case 108 (Search Borrowed Books)**: An administrator can search within the list of all borrowed books using filters to find specific information or specific borrowing records. <br>

## User Story
author @michimel <br>
1.	As an administartor, I want to be able to see all the books, authors, genres, and members in a list. <br>
2.	As an administartor, I want to be able to search for information fast and therefor set filters on these lists. <br>
3.	As an administartor, I want to be able to add new books, authors, genres, and members. <br>
4.	As an administartor, I want to be able to register when a book is borrowed by a member. <br>
5.	As an administartor, I want to be able to register when a book is returned by a member. <br>
6.	As an administartor, I want to be able to edit books, authors, genres, and members. <br>
7.	As an administartor, I want to be able to see a list of all bookw, which are currently borrowed. <br>
8.	As an administartor, I want to be able to search in the list of all borrowed books via a filter. <br>

# 2. Domain Design *Definition of domain model*
## Domain Model
author @michimel <br>
Link to the domain model: https://lucid.app/lucidchart/bfa39a78-e2ec-4b1a-b63b-18829cec80c9/edit?beaconFlowId=7134D7D032DE5064&invitationId=inv_0148f8f5-f3f9-433a-8296-e9667492d473&page=0_0# <br>

<img src="https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/Domain%20Model/DomainModel%20UML%20CLass%20Diagram.png"> <br> 


# 3. Business Logic and API design *Definition of business logic and API*
## Business Logic

## Methods overview
author @michimel <br>
If the access is not only for admins, all have the access rights.

| Entity   | Method  | Path                                                           | Description                                                               | Access only for Admins |
|----------|---------|----------------------------------------------------------------|---------------------------------------------------------------------------|------------------------|
| Author   | GET     | /api/author                                                    | Get all Authors                                                           |                        |
| Author   | POST    | /api/author/newAuthor                                          | Create new Author                                                         | x                      |
| Author   | PUT     | /api/author/updateAuthor/{authorID}                            | Update Existing Author                                                    | x                      |
| Author   | GET     | /api/author/findByFirstName/{firstName}                        | Retrieve Authors by Firstname                                             |                        |
| Author   | GET     | /api/author/findByLastName/{lastName}                          | Retrieve Authors by Lastname                                              |                        |
| Author   | GET     | /api/author/findByFristNameAndLastName/{firstName, lastName}   | Retrieve the Author by Firstname and Lastname                             |                        |
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
| Borrowed | GET     | /api/borrowed/findByMemberAndStatus/{member}/{status}          | Retrieve Borrowed by Member and Status                                    |                        |
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
| Member   | GET     | /api/member/findByFirstNameAndLastName/{firstName}/{lastName}  | Retrieve the Member by Firstname and Lastname                             |                        |
| Member   | GET     | /api/member/findByEmail/{email}                                | Retrieve the Member by Email                                              |                        |
| Member   | GET     | /api/member/findByRole/{role}                                  | Retrieve Members by Role                                                  |                        |

## API design
author @michimel <br>
To test APIs use [this collection](https://galactic-star-276963.postman.co/workspace/Birtney~ebb933fd-cc47-488d-bce0-7eada0cf63ff/collection/26197022-9ec1ab6f-d964-4437-a948-2a0695195da6?action=share&creator=26197022) in Potsman in Workspace Birtney. <br>
With the help of the overview of the methods above we created the API design with [Swagger Editor](https://editor.swagger.io/), below you can see a screen shot of the generated documentation.
If you want to see or edit the code, you can import the [yaml file](https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/API%20(Swagger%20Editor)/eLibraryAPI.yaml) into Swagger Editor. <br>

<img src="https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/API%20(Swagger%20Editor)/1%20Info%2C%20Author.png"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/API%20(Swagger%20Editor)/2%20Book.png"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/API%20(Swagger%20Editor)/3%20Borrowe%2C%20Genre.png"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/API%20(Swagger%20Editor)/4%20Member.png"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/API%20(Swagger%20Editor)/5%20Schemas%20(Author%2C%20Book%2C%20Borrowed).png"> <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/9a218474b83af7255c2875cfc3e558c98f64a0c9/Documentation%20Sources/API%20(Swagger%20Editor)/6%20Schemas%20(Gerne%2C%20Member).png"> <br>

### auto generantion from OpenAPI - Swagger
When runing our code in codespace and then open it the browser via the port 8080, we could let Swagger generate our API documentation. <br> 
Therefor we added "/swagger-ui/index.html#/" to the path in the link, and [this documenation](https://michimel-zany-dollop-976wqw46jqvf9xjx-8080.preview.app.github.dev/swagger-ui/index.html#/) got generated: <br>

@ michele: do the screenshots and add them here.

# 4. Data and API implementation *implementation of data access and business logic layers and API*

# 5. Security *Implementation of API-level security*
--> not in assignment scope delete

# 6. Frontend implementation *Design, prototyping and realization of frontend functionality*
## Mock up - prototyping
Link to the mock up (in OneNote): https://fhnw365.sharepoint.com/teams/ItsBirtneyBi_M365/_layouts/15/Doc.aspx?sourcedoc={9d183143-397c-48b8-b9a4-4d5389579d70}&action=edit&wd=target%28Untitled%20Section.one%7C2f1487b2-dcc6-45fd-bab3-b7bd08c83f6c%2FMock%20up%7C39605bfe-29cb-41e5-a10c-099c5f7e5d0a%2F%29&wdorigin=703 <br>

To get a better understanding of the assignment, and to visualise our ideas and views, we have created the following mock-up. <br>
As the content of the assignment got adjusted, we did not implement the complete mock up, only parts of it as the MVC is about the administraor's perspective. Also we did adapt the design in the final application. <br>

The following image shows the complete mock up: <br>
<img src="https://github.com/michimel/electronic-library/blob/59837f2d720e9b72bedd059ef858230b666ab65b/images/Mock%20up/1%20complete%20mock%20up.png"> <br>

In order to read and view the mock up better, we prepared images of the individual sections in the following images: <br>
This images shows how the start page, including the login, the page to register for an user account, and the pages for the user. The pages for the user shown here are, the page "books", where users can search for a book, the page when a specific book got selected, here users can rent the book, and the page "my borrowed books", where the users see the history of all their books currently on loan, or the ones they have borrowed and already return in a list view. <br>
<img src="https://github.com/michimel/electronic-library/blob/e198eb8d663424bf7e749d29b6398968dc84006d/images/Mock%20up/2%20start(login),%20register,%20user(books%20and%20book%20search,%20book%20view,%20my%20borrowed%20books%20list).png"> <br>

This images shows pages for user, which are the page "prfoile", where users can edit or delete their profile, and again the start page, which appreas after the log out. <br>
<img src="https://github.com/michimel/electronic-library/blob/0c5c5d4d8b06a59504b8dd5790466ba264d58317/images/Mock%20up/3%20user(profile,%20logout).png"> <br>

The following images shows the pages only for administrators, as they have addtional functionalities compared to the user. The images shows the page "books", where admins can add books, the page when a specific book got selected, where admins can edit or delete the book, and the page "my borrowed books".
<img src="https://github.com/michimel/electronic-library/blob/ee7028520188dfe829191a6deb34d2bc659b15c7/images/Mock%20up/4%20admin(books%20and%20book%20search,%20book%20view,%20my%20borrowed%20books%20list).png"> <br>

This image shows more pages for administrators. The page "all borrowed ooks" gives back the history of all books currently beeing borrowed and the books that are already returned, including the username of the user who had borrowed the book. The page "profile", and again the start page, which comes up after the logout.
<img src="https://github.com/michimel/electronic-library/blob/ee7028520188dfe829191a6deb34d2bc659b15c7/images/Mock%20up/5%20admin(all%20borrowed%20books,%20profile,%20logout).png"> <br>

The following picture gives some information about the colours used in the mock up and also more ideas for possible (further) improvements can be seen.
<img src="https://github.com/michimel/electronic-library/blob/ee7028520188dfe829191a6deb34d2bc659b15c7/images/Mock%20up/6%20info,%20improvements.png"> <br>

## Realization of frontend functionality *here screenshots of the final design from budibase*

# 7. Demonstrator *Integration of frontend and backend to realize an end-to-end application consuming REST APIs from the web service*

