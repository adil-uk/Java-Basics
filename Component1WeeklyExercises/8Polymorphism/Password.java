public class Password implements Encryptable
{
   private String value;
   private boolean encrypted;

   public Password(String text)
   {
      value = text;
      encrypted = false;
   }

   public void encrypt()
   {
      if (!encrypted)
      {
         value = new StringBuilder(value).reverse().toString();
         encrypted = true;
      }
   }

   public String decrypt()
   {
      if (encrypted)
      {
         value = new StringBuilder(value).reverse().toString();
         encrypted = false;
      }

      return value;
   }

   public String toString()
   {
      return value;
   }
}

