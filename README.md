# TODOS:
README updaten (Bilder (neu machen), user storreis, use case, etc.)
project vereinfachen
- keine Funktion zum Account löschen
- Buch hat nur 1 Author, und nur eine Genre
Infos:
Klasse Agent (data, repository, controller, service) ist im crm webservice der User, es heisst nicht so da User ein reseved word ist ! Bei uns heisst es Member.
Wir können aber im crm-webservice, die Agent Klassen ansehen und es nachbauen!
- Login und Register sind im Member, Role ist eine string in Member
- Loan_Info – Borrowed, weil many to many is pain in the ass


# eLibraryReinach Documentation
## Assignment for Internet Technology 2023

## Groupmembers:
Mara Garbellini <br>
Rahel Häusler <br>
Michèle Fille <br>
Jervin Ureath <br>

**Class:** 3b - BIT PT

Format: https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet

# 1. Analysis *Scenario ideation, use case analysis and user story writing*
## Scenario - update, must be in line with use cases and user storries !
The commune of Reinach has decided to create an electronic library, as today's world is very digital. Therefore, it wants to set up a web application. The online library will offer eBooks. <br>
To use the electronic library customers, have to create an user account. With the user account, the customers can log in to the electronic library and use the following services. <br>
The web application allows users to edit their user profile, to delete their user profile, to browse through an infinite amount of books, to search for books, to borrow books, to return books, to easily view and manage their borrowed books with a list view. <br>
In section "my borrowed books", users can view all books that are currently on loan and those which have already been returned. This section also displays the due date for return and an option to return the book early is available. As this is an online library, books do not need to be actively returned, access to the book is automatically taken away on the return date. <br>
The web application gets managed and kept updated by administrators. Therefore, the administrators have additional functions to the user functions.
The web application additionally allows administrators to add books, to edit existing books, to delete existing books, to easily view and manage all borrowed books with a list view. <br>
In section "all borrowed books", administrators can view all books that are currently on loan and those which have already been returned. This section also displays the username of the user, who is currently borrowing or has borrowed the book, the due date for return and an option to return the book early is available. <br>

## Use case analysis - update, make it simpler , also change diagrams!
Link to the use case diagrams: https://lucid.app/lucidchart/ff216cd6-dd92-4284-bdc1-30d08725a5d9/edit?viewport_loc=1733%2C31%2C2219%2C1097%2C0_0&invitationId=inv_ef872c42-5b9f-4504-93fc-5389022cccf9 <br>

### Use Case 100
<img src="https://github.com/michimel/electronic-library/blob/0743362ae9dbb8a27e095ad5172f523bd70f3704/images/Use%20case/Use%20Case%20Diagramm%20UC%20100.png" width="800"> <br>
**Use case 101 (Sign up)**: A user can sing up to the website and create an account. To create an account, the user must enter a username, email address, password, firstname and last name. (The user must also agree to the terms and conditions.) <br>
**Use Case 102 (Login)**: Once a user has created an account, they can log in using their username/email address and password. <br>
**Use case 103 (Update profile)**: The user can update their user profile once they are logged in. <br>
**Use case 104 (Log out)**: After logging in, the user can log out again. <br>

### Use Case 200
<img src="https://github.com/michimel/electronic-library/blob/f642a724d1250e2e2022fdc20df2296212f4ce51/images/Use%20case/Use%20Case%20Diagramm%20UC%20200.png" width="800"> <br>
**Use case 201 (Search Book)**: A user can search for books and get the results in a list view. <br>
**Use case 202 (Borrow Book)**: A user can borrow a book for a certain period of time. <br>
**Use case 203 (Return Book early)**: A user can return a book early if they do not need it anymore. <br>
**Use case 204 (My borrowed books)**: A user can see a list of the books he/she is currently borrowing <br>

### Use Case 300
These use cases are for administrators, which have the same basic functionalities as users but have additional functionalities. <br>
<img src="https://github.com/michimel/electronic-library/blob/f642a724d1250e2e2022fdc20df2296212f4ce51/images/Use%20case/Use%20Case%20Diagramm%20UC%20300.png" width="800"> <br>
**Use case 301 (Add new book)**: An administrator is able to add a new book to the library system by providing the book details such as title, author, genre, and publication year. <br>
**Use case 302 (Edit book)**: An administrator is able to edit a book from the library system. <br>
**Use case 304 (All borrowed books)**: An administrator can see a list of all books which are currently borrowed. <br>


## User Story - update, make it simpler !
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
## Services/Methods --> Rahel? - update or delete !
Link: https://lucid.app/lucidchart/f763dd83-1fa8-4140-bbcd-0a12ec91b5a9/edit?page=0_0&invitationId=inv_e39b7e2c-83e9-4dcb-9dfb-ffc701bf88de#

## Microservices - update or delete !
We tried to identify the microservices, domains, aggregates, and entities in the application using the approach of Domain Driven Design (DDD). <br>
<img src="https://github.com/michimel/electronic-library/blob/bd2893c3f7c0fa2f17f8602c88eba3398d5ababe/images/Microservices/Microservices.png"> <br>

## Domain Model
Link to the domain model: https://lucid.app/lucidchart/bfa39a78-e2ec-4b1a-b63b-18829cec80c9/edit?beaconFlowId=7134D7D032DE5064&invitationId=inv_0148f8f5-f3f9-433a-8296-e9667492d473&page=0_0# <br>

<img src="https://github.com/michimel/eLibraryReinach/blob/5bf4c8db53039e8c062b02d27d9f14302b91eefe/Documentation%20Sources/Domain%20Model/DomainModel%20UML%20CLass%20Diagram.png"> <br> 


# 3. Business Logic and API design *Definition of business logic and API*
## Business Logic

## API design
To test APIs use [this collection](https://galactic-star-276963.postman.co/workspace/Birtney~ebb933fd-cc47-488d-bce0-7eada0cf63ff/collection/26197022-9ec1ab6f-d964-4437-a948-2a0695195da6?action=share&creator=26197022) in Potsman in Workspace Birtney. <br>
We created the API design with [Swagger Editor](https://editor.swagger.io/), below you can see a screen shot of the generated documentation.
If you want to see or edit the code, you can import the [json file](https://github.com/michimel/electronic-library/blob/f9ad420b08456aa54977b1b3c0ec476764e7d551/images/API%20(Swagger%20Editor)/eLibraryAPIs.json) or [yaml file](https://github.com/michimel/electronic-library/blob/f9ad420b08456aa54977b1b3c0ec476764e7d551/images/API%20(Swagger%20Editor)/eLibraryAPIs.yaml) into Swagger Editor. <br>

<img src="https://github.com/michimel/electronic-library/blob/f9ad420b08456aa54977b1b3c0ec476764e7d551/images/API%20(Swagger%20Editor)/API%20Swagger%20Editor_%20Header,%20Tag(User).png"> <br>

<img src="https://github.com/michimel/electronic-library/blob/f9ad420b08456aa54977b1b3c0ec476764e7d551/images/API%20(Swagger%20Editor)/API%20Swagger%20Editor_Tag(Books,Loan).png"> <br>

<img src="https://github.com/michimel/electronic-library/blob/f9ad420b08456aa54977b1b3c0ec476764e7d551/images/API%20(Swagger%20Editor)/API%20Swagger%20Editor_Schemas.png"> <br>


# 4. Data and API implementation *mplementation of data access and business logic layers and API*

# 5. Security *Implementation of API-level security*

# 6. Frontend implementation *Design, prototyping and realization of frontend functionality*

# 7. Demonstrator *Integration of frontend and backend to realize an end-to-end application consuming REST APIs from the web service*

