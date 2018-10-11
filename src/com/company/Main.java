package com.company;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //* #1
        Users a = new Users("'Ariel'", "'Gierczak'", "'Warszawa, 01-231'", "'arkan'", "'newpasword'");

        System.out.println("beforeUpdate:");
        for(int i=0; i<a.getUserDetails().size(); i++){
            System.out.println(a.getUserDetails().get(i).getUser_id() + " " + a.getUserDetails().get(i).getUser_name());
        }

        //* #2
        NewSQL_Worker.updateExistingDataOfUsers(a, "WebShop.dbo.Users"); //clear existing list and update by those from db

        System.out.println("afterUpdate:");
        for(int i=0; i<a.getUserDetails().size(); i++){
            System.out.println(a.getUserDetails().get(i).getUser_id() + " " + a.getUserDetails().get(i).getUser_name());
        }

        System.out.println(NewSQL_Worker.getSpecificUserDataFromDatabase("UserId", (short) 3));

        //* #3
        a.updateUserIdForDownloadedUsers(a, (short) NewSQL_Worker.getRowCount("WebShop.dbo.Users")); //Update of userId in array

        for(int i=0; i<a.getUserDetails().size(); i++){
            System.out.println(a.getUserDetails().get(i).getUser_id() + " " + a.getUserDetails().get(i).getUser_name());
        }

        System.out.println("Przed dodaniem: " + a.getUserDetails().size());
        //* #4
        a.VeryficationAndExecutionIfUserShouldBeCreatedInList("Arielos", "XD", "x", "x", "x");

        System.out.println("Po dodaniu: " + a.getUserDetails().size());

        //* #5 - zaktualizować funkcję poniższymi linijkami - przykelonymi
        a.createUserIdForNewlyCreatedUser();
            a.getUserDetails().get(a.getUserDetails().size()-1).setUser_id((short) 25);
            System.out.println(a.getUserDetails().size() + " " + a.getUserDetails().get(a.getUserDetails().size()-1).getUser_name() + " " +
                    a.getUserDetails().get(a.getUserDetails().size()-1).getUser_id());

            System.out.println("id dodanego: " + a.getUserDetails().get(a.getUserDetails().size()-1).getUser_name() + ", id: " + a.getUserDetails().get(a.getUserDetails().size()-1).getUser_id());
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
