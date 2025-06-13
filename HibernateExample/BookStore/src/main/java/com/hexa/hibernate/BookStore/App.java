package com.hexa.hibernate.BookStore;



import java.util.Scanner;

import service.BookService;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookService service = new BookService();


        while(true){
            System.out.println("\n---BookStore---");
            System.out.println("1. add newbook");
            System.out.println("2. update bookprice");
            System.out.println("3. remove book");
            System.out.println("4. generate bill");
            System.out.println("5. search book by id");
            System.out.println("6. listall books");
            System.out.println("7. Exit");
            System.out.print("enter your choice: ");
            int choice = sc.nextInt();
           

            switch (choice) {
                case 1:
                    service.addBookSer();
                    break;
                case 2:
                    service.updateBookPriceSer();
                    break;
                case 3:
                    service.removeBookSer();
                    break;
                case 4:
                    service.generateBillSer();
                    break;
                case 5:
                    service.enquiryByIdSer();
                    break;
                case 6:
                    service.showAllBooks();
                    break;
                case 7:
                    System.out.println("exiting");
                    sc.close();
                    return;
                default:
                    System.out.println("invalid choice");
            }

        } 

  
    }
}


