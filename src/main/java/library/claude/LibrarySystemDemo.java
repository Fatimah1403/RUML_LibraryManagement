package library.claude;

public class LibrarySystemDemo {
    public static void main(String[] args) {
        // Create a library
        Library cityLibrary = new Library("City Public Library");

        // Create some library items
        Book novel = new Book("The Great Gatsby", "978-0-7432-7356-5");
        TextBook mathBook = new TextBook("Calculus", "978-0-321-74700-2", "Mathematics", "10th Edition");
        AudioBook audioNovel = new AudioBook("1984", "978-0-452-28423-4", 11.5, "Simon Prebble");

        // Add items to library
        cityLibrary.addItem(novel);
        cityLibrary.addItem(mathBook);
        cityLibrary.addItem(audioNovel);

        // Create members
        Member alice = new Member("M001", "Alice Johnson");
        Member bob = new Member("M002", "Bob Smith");

        // Add members to library
        cityLibrary.addMember(alice);
        cityLibrary.addMember(bob);

        // Demonstrate functionality
        System.out.println("Library System Demo");
        System.out.println("===================");
        System.out.println(cityLibrary);
        System.out.println();

        // Checkout items
        System.out.println("Checking out items:");
        boolean success1 = cityLibrary.checkoutItem("M001", "The Great Gatsby");
        boolean success2 = cityLibrary.checkoutItem("M002", "Calculus");
        System.out.println("Alice borrows The Great Gatsby: " + success1);
        System.out.println("Bob borrows Calculus: " + success2);
        System.out.println();

        // Show borrowed items
        System.out.println("Member status:");
        System.out.println(alice);
        System.out.println("Alice's borrowed items: " + alice.getBorrowedItems().size());
        System.out.println(bob);
        System.out.println("Bob's borrowed items: " + bob.getBorrowedItems().size());
        System.out.println();

        // Show available items
        System.out.println("Available items: " + cityLibrary.getAvailableItems().size());

        // Return an item
        System.out.println("\nReturning items:");
        boolean returned = cityLibrary.returnItem("M001", "The Great Gatsby");
        System.out.println("Alice returns The Great Gatsby: " + returned);
        System.out.println("Available items after return: " + cityLibrary.getAvailableItems().size());
    }
}
