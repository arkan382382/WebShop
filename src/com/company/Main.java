package com.company;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //* #1
        Users a = new Users("'Ariel'", "'Gierczak'", "'Warszawa, 01-231'", "'arkan'", "'newpasword'");

        //* #2
        NewSQL_Worker.updateExistingDataOfUsers(a, "WebShop.dbo.Users"); //clear existing list and update by those from db

        //* #3
        a.updateUserIdForDownloadedUsers(a, (short) NewSQL_Worker.getRowCount("WebShop.dbo.Users")); //Update of userId in array

        //* #4
        a.VeryficationAndExecutionIfUserShouldBeCreatedInList("Arielos", "XD", "x", "x", "x");

        // #5
            a.createUserIdForNewlyCreatedUser();





        for(int i=0; i<a.getUserDetails().size(); i++){
            System.out.println("userId: " + a.getUserDetails().get(i).getUser_id() + ", name: " + a.getUserDetails().get(i).getUser_name());
        }

        // #6 update dabatase by newly added user
       // NewSQL_Worker.commitUserToDatabase(a); <- do sprawdzenia - i do poprawy nazwy tabel
            /*
Nadawanie ID_user – nie na poziomie tworzenia usera.

1.      Pobieranie danych z bazy danych – bez userId,                                  funkcją createUser- bez parametru id – czyli users.add…

2.      Dodanie userId do pobranych z tabeli (danymi z tabeli)    nowa funkcja wewnątrz NewSQL_Worker _na tym etapie w liście są wszystkie z bazy z aktualnym ID

3.      Tworzenie nowego do listy – createUserToList – bez parametru Id if(pkt.4) then users.add…., else – nie dodawaj

4.      Sprawdzenie czy nowododawany do listy jest już w bazie – jeśli jest (komunikat) – ujęte w punkcie 3.

#### #### ### done in file.

5.      Dodanie ID do nowego usera w liście – nowa funkcja wewnątrz NewSLQ_Worker – uzupełnienie wartością kolejną do poprzedniego usera z listy lub ostatniego z bazy danych. – wcześniej sprawdzić czy na tym etapie przedostatni z listy jest równy ostatniemu z bazy danych – funkcja public static Users getUserFromDatabase(short whichOne)

6.      Dodanie nowego z listy do bazy


 */


    }
}
