public class Operand {
    private int value;
  public Operand( String token ) {
       this.value = Integer.parseInt(token);
  }
  public Operand( int value ) {
      this.value = value;
  }
  public int getValue() {
      return value;
  }
  public static boolean check( String token ) {
      // try catch block to check that the token is actually an int
      try{
          Integer.parseInt(token);
      }
      catch(Exception e){
          return false;
      }
      return true;
  }
}
