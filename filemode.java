
/**
 *
 * @author bilux (ii.bilux@gmail.com)
 *
 */
public class MobyDroid {
  public static void main(String[] args) throws JadbException {
    // (16877)10 == (40755)8 == 40000 + 755
    // (33216)10 == (100700)8 == 100000 + 700
    // (0x1 << 14) == (16384)10 == (40000)8
    //
    // 16877 in decimal is 40755 in octal, so it's 40000 + 755 (directory + mode)
    //
    // 33216 in decimal is 100700 in octal, so it's 100000 + 700 (regular + mode)
    
    //decimal to octal
    int oct = 0, dec = 0, ii = 0;
    dec = 16877;
    oct = 0;
    ii = 0;
    while (dec > 0) {
        oct += ((dec % 8) * Math.pow(10, ii++));
        dec /= 8;
    }
    System.out.println("dec= " + dec + " oct= " + oct);

    //octal to decimal
    oct = 755;
    dec = 0;
    ii = 0;
    while (oct > 0) {
        dec += (oct % 10) * Math.pow(8, ii++);
        oct /= 10;
    }
    System.out.println("dec= " + dec + " oct= " + oct);
  }
  
  public String getPermission(int mode) {
      StringBuilder sb = new StringBuilder();
      // DIRECTORY
      sb.append(((mode & (0x1 << 14)) == (0x1 << 14) ? "d" : "-"));
      // USER
      sb.append(((mode & (0x4 << 0x6)) == (0x4 << 0x6) ? "r" : "-"));   // READ
      sb.append(((mode & (0x2 << 0x6)) == (0x2 << 0x6) ? "w" : "-"));   // WRITE
      sb.append(((mode & (0x1 << 0x6)) == (0x1 << 0x6) ? "x" : "-"));   // EXECUTE
      // GROUP
      sb.append(((mode & (0x4 << 0x3)) == (0x4 << 0x3) ? "r" : "-"));   // READ
      sb.append(((mode & (0x2 << 0x3)) == (0x2 << 0x3) ? "w" : "-"));   // WRITE
      sb.append(((mode & (0x1 << 0x3)) == (0x1 << 0x3) ? "x" : "-"));   // EXECUTE
      // OS
      sb.append(((mode & (0x4)) == (0x4) ? "r" : "-"));   // READ
      sb.append(((mode & (0x2)) == (0x2) ? "w" : "-"));   // WRITE
      sb.append(((mode & (0x1)) == (0x1) ? "x" : "-"));   // EXECUTE
      return sb.toString();
  }
}
