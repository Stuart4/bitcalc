public class BitCalc {
 
  public static void main(String[] args) throws ArithmeticException {
    
    final int x = 0;
    final int y = 500;
    
    System.out.printf("%d + %d = %d = %s\n\n",x, y, add(x,y), Integer.toBinaryString(add(x,y)));
    System.out.printf("%d - %d = %d = %s\n\n",x, y, subtract(x,y), Integer.toBinaryString(subtract(x,y)));
    System.out.printf("%d * %d = %d = %s\n\n",x, y, multiply(x,y), Integer.toBinaryString(multiply(x,y)));
    System.out.printf("%d / %d = %d = %s\n\n",x, y, divide(x,y), Integer.toBinaryString(divide(x,y)));
  }
 
  
  public static int add(int x, int y) {
    

   int xor = x ^ y;
   int and = x & y;

   
   while (and != 0) {
     
     and = and << 1;
     int tmpXor = xor ^ and;      
     int tmpAnd = xor & and;
     
     xor = tmpXor;
     and = tmpAnd;
     
     
   }
    
    return xor ^ and;
  }
  

  public static int subtract(int x, int y) {
    y = add(~y,1);

    return add(x,y);
  }
  
  public static int multiply(int x, int y) {
    int tmp = x;
    
    
    if (x < 0 ^ y < 0) {
      
      x = multiply(Math.abs(x),Math.abs(y));
      
      x = 0 - x;
  
    } else {
    
    for (int i = 1; i < y; i++) {
     
     x = add(x,tmp);
      
    }
    
    }
    
    return x;
  }
  
  public static int divide(int x, int y) throws ArithmeticException{
    
    if (x < 0 ^ y < 0) return add(~ divide(Math.abs(x),Math.abs(y)), 1);
    
    if ( y == 0) throw new ArithmeticException("Divided by zero");
  
    int tmp = 0;
    int ans = 0;
    
    while (tmp < x){
     
      tmp += y;
      
      ans = add(ans, 1);
      
    }
    
    return ans;
  }
}