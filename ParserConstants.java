
public interface ParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SELECT = 5;
  /** RegularExpression Id. */
  int FROM = 6;
  /** RegularExpression Id. */
  int WHERE = 7;
  /** RegularExpression Id. */
  int AND = 8;
  /** RegularExpression Id. */
  int OPEN_PAR = 9;
  /** RegularExpression Id. */
  int CLOSE_PAR = 10;
  /** RegularExpression Id. */
  int DOT = 11;
  /** RegularExpression Id. */
  int COMMA = 12;
  /** RegularExpression Id. */
  int QUO = 13;
  /** RegularExpression Id. */
  int OPERATOR = 14;
  /** RegularExpression Id. */
  int DIGITS = 15;
  /** RegularExpression Id. */
  int NAME = 16;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\r\"",
    "\"\\n\"",
    "\"SELECT\"",
    "\"FROM\"",
    "\"WHERE\"",
    "\"AND\"",
    "\"(\"",
    "\")\"",
    "\".\"",
    "\",\"",
    "\"\\\"\"",
    "<OPERATOR>",
    "<DIGITS>",
    "<NAME>",
  };

}
