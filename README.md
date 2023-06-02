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
## Scenario - update, must be in line with use cases and user storries ! *italic* -> check if possible otherwise delete !
author @michimel <br>
The commune of Reinach initiated the eLibrary project, which aims to cater to the digital world by offering a web application for accessing a wide range of eBooks. The initial concept included different user categories, such as regular users and administrators, as well as essential security features (login, logout, register). However, the current focus is on creating an MVP (Minimal Viable Product) that provides the administrator's perspective. <br>

As an administrator, the primary objective is to efficiently manage the library's resources. This includes editing or adding members, books, genres, authors, and lending records. To ensure usability, the platform incorporates filtering options, enabling administrators to generate lists based on specific criteria for quickly finding relevant information.  <br>

For future enhancements and improvements, the following features could be considered:  <br>
Users would be required to register and subsequently log in to the eLibrary platform. They could also log out and conveniently manage their profiles. Regular users would have restricted functionality, allowing them to explore comprehensive lists of books, genres, and authors. Additionally, they would have the capability to refine their searches using filters, borrow and return books, and access a personalized list showcasing their currently borrowed books. While the existing list of borrowed objects does not include dates or predefined lending durations, these aspects could also be incorporated in the future. <br>

Overall, the eLibrary project aims to create a user-friendly web application that empowers administrators to efficiently manage library resources. Furthermore, it holds the potential to provide regular users with convenient access to eBooks and lending services in the future.  <br>

## Use case analysis
author @michimel <br>
Link to the use case diagrams: https://lucid.app/lucidchart/ff216cd6-dd92-4284-bdc1-30d08725a5d9/edit?viewport_loc=1733%2C31%2C2219%2C1097%2C0_0&invitationId=inv_ef872c42-5b9f-4504-93fc-5389022cccf9 <br>

### Use Case 100
<img src="https://github.com/michimel/eLibraryReinach/blob/b39ce4e417edfd9b027e7370c2284b400fbd7202/Documentation%20Sources/Use%20case/Use%20Case%20Diagramm%20UC%20100.png" width="800"> <br>
**Use case 101 (Sign up)**: A user can sing up to the website and create an account. To create an account, the user must enter a username, email address, password, firstname and last name. (The user must also agree to the terms and conditions.) <br>
**Use Case 102 (Login)**: Once a user has created an account, they can log in using their username/email address and password. <br>
**Use case 103 (Update profile)**: The user can update their user profile once they are logged in. <br>
**Use case 104 (Log out)**: After logging in, the user can log out again. <br>

### Use Case 200
<img src="https://github.com/michimel/eLibraryReinach/blob/b39ce4e417edfd9b027e7370c2284b400fbd7202/Documentation%20Sources/Use%20case/Use%20Case%20Diagramm%20UC%20200.png" width="800"> <br>
**Use case 201 (Search Book)**: A user can search for books and get the results in a list view. <br>
**Use case 202 (Borrow Book)**: A user can borrow a book for a certain period of time. <br>
**Use case 203 (Return Book early)**: A user can return a book early if they do not need it anymore. <br>
**Use case 204 (My borrowed books)**: A user can see a list of the books he/she is currently borrowing <br>

### Use Case 300
These use cases are for administrators, which have the same basic functionalities as users but have additional functionalities. <br>
<img src="https://github.com/michimel/eLibraryReinach/blob/b39ce4e417edfd9b027e7370c2284b400fbd7202/Documentation%20Sources/Use%20case/Use%20Case%20Diagramm%20UC%20300.png" width="800"> <br>
**Use case 301 (Add new book)**: An administrator is able to add a new book to the library system by providing the book details such as title, author, genre, and publication year. <br>
**Use case 302 (Edit book)**: An administrator is able to edit a book from the library system. <br>
**Use case 304 (All borrowed books)**: An administrator can see a list of all books which are currently borrowed. <br>


## User Story
author @michimel and @marallini <br>
1.	As a user, I want to be able to register for an user account so that I can access the online library. <br>
2.	As a user, I want to log-in so that I can authenticate myself. <br>
3.	As a user, I want to be able to edit my profile. <br>
4.	As a user, I want to be able to logout. <br>

5.	As a user, I want to be able to search for book titles, authors, gernes. <br>
6.	As a user, I want to be able to borrow a book for a certain period of time. <br>
7.	As a user, I want to be able to return a book early if I do not need it anymore. <br>
8.	As a user, I want to see which books I am currently borrowing and the history of books, I already borrowed and which are returned (my borrowed books). <br>

9.	As an administrator, I want to be able to add new books into the system. <br>
10.	As an administrator, I want to edit existing books. <br>
11.	As an administrator, I want to see which books are currently borrowed and the history of books that have been borrowed and already returned (all borrowed books). <br>

## Mock up - update (maybe leave this one as first draft, to have a better understanding for the project?)
Link to the mock up (in OneNote): https://fhnw365.sharepoint.com/teams/ItsBirtneyBi_M365/_layouts/15/Doc.aspx?sourcedoc={9d183143-397c-48b8-b9a4-4d5389579d70}&action=edit&wd=target%28Untitled%20Section.one%7C2f1487b2-dcc6-45fd-bab3-b7bd08c83f6c%2FMock%20up%7C39605bfe-29cb-41e5-a10c-099c5f7e5d0a%2F%29&wdorigin=703 <br>

To visualise our ideas and views, we have created the following mock-up. <br>

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

# 4. Data and API implementation *implementation of data access and business logic layers and API*

# 5. Security *Implementation of API-level security*

# 6. Frontend implementation *Design, prototyping and realization of frontend functionality*

# 7. Demonstrator *Integration of frontend and backend to realize an end-to-end application consuming REST APIs from the web service*

