public class HelloNumbers {
  public static void DrawStars(int N) {
    String a = "";
    int x = 0;
    while (x < N) {
      a = a + "*";
      x = x + 1;
      System.out.println(a);
    }
  }
  public static void main(String[] args) {
    DrawStars(10);
  }
}
/* Our variable x must be declared before it is used, and it must be given a type!

Our loop definition is contained inside of curly braces,

and the boolean expression that is tested is contained inside of parentheses.

Our print statement is just System.out.print instead of System.out.println.
This means we should not include a newline (a return).

Our print statement adds a number to a space.
This makes sure the numbers don't run into each other.
Try removing the space to see what happens.

When we run it, our prompt ends up on the same line as the numbers
(which you can fix in the following exercise if you'd like).
*/
