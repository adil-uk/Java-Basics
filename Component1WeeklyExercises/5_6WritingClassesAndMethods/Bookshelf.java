public class Bookshelf {

    public static void main(String[] args) {
        Book book1 = new Book("Diary of a Wimpy Kid", "Jeff Kinney", "Puffin Books", 2007);
        Book book2 = new Book("Of Mice and Men", "John Steinbeck", "Penguin", 1937);


        System.out.println(book1);
        System.out.println(book2);

        book2.setPublisher("New Publisher here"); // testing
        book2.setCopyrightDate(2026); // testing

        System.out.println(book2);
    }
}