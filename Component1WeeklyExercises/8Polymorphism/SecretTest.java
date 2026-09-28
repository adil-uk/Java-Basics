//********************************************************************
//  SecretTest.java       Java Foundations
//
//  Demonstrates the use of a formal interface.
//********************************************************************

public class SecretTest
{
   //-----------------------------------------------------------------
   //  Creates Encryptable objects and exercises their methods.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      Encryptable item;

      item = new Secret("HELLO My name is someone else");
      System.out.println("Secret plain: " + item);
      item.encrypt();
      System.out.println("Secret encrypted: " + item);
      System.out.println("Secret decrypted: " + item.decrypt());

      System.out.println();

      item = new Password("simple123");
      System.out.println("Password plain: " + item);
      item.encrypt();
      System.out.println("Password encrypted: " + item);
      System.out.println("Password decrypted: " + item.decrypt());
   }
}
