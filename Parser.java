public class Parser implements ParserConstants {
  public static String parse(String args) throws Exception
  {
    Parser parse = new Parser(new java.io.StringReader(args));
    String rst = parse.Query();
    return rst;
  }

/*

start the query, call SFWStatement() and add "<dbQuery>""</dbQuery>" out of the SFWStatement.

*/
  static final public String Query() //throws ParseException 
  {try{
  String rst;
    rst = SFWStatement();
    jj_consume_token(0);
   // {if (true) return "<dbQuery>" + rst + "</dbQuery>";}
    //throw new Error("Missing return statement in function");
  }catch(Exception e){}return null;
}

/*

first check the select clause
then check the from clause
finally check the where clause

*/
  static final public String SFWStatement()// throws ParseException
  {try{
  String select = "";
  String from = "";
  String where = "";
    select = SelectClause();
    from = FromClause();
    where = WhereClause();
    //{if (true) return "<dbSFWStatement>" + select + from + where + "</dbSFWStatement>";}
    //throw new Error("Missing return statement in function");
  }catch(Exception e){}return null;
}

/*

this is the select clause, we need to find all the attribute so we call Attr method

*/
  static final public String SelectClause() throws ParseException {
  String select;
    jj_consume_token(SELECT);
    select = Attr();
    {if (true) return "<dbSelectClause>" + select + "</dbSelectClause>";}
    throw new Error("Missing return statement in function");
  }

/*

this method will recursively find all the attribute in the select clause and return all the attribute as one String.

*/
  static final public String Attr() //throws ParseException {
  
      {
          try{Token relation;
  Token attr;
  String subAttr = "";
    relation = jj_consume_token(NAME);
    jj_consume_token(DOT);
    attr = jj_consume_token(NAME);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      subAttr = Attr();
    }
 //   {if (true) return "<dbAttr>" + "<dbRelVar> <dbRelAliasName Token=\u005c"" + relation.image + "\u005c" /> </dbRelVar>" + "<dbAttrName Token=\u005c"" + attr.image + "\u005c" /> " + "</dbAttr>" + subAttr;}
   // throw new Error("Missing return statement in function");
  }catch(Exception e){}return null;
}

/*

this is the from clause, we will call RelVal() method to find all relations

*/
  static final public String FromClause() throws ParseException {
  String from;
    jj_consume_token(FROM);
    from = RelVal();
    {if (true) return "<dbFromClause>" + from + "</dbFromClause>";}
    throw new Error("Missing return statement in function");
  }

/*

this method will find all the relations in the from clause

*/
  static final public String RelVal() //throws ParseException 
  {try{
  Token realName;
  Token aliasName;
  String subVal = "";
    realName = jj_consume_token(NAME);
    aliasName = jj_consume_token(NAME);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMA);
      subVal = RelVal();
    }}
  catch(Exception e)
  {
      
    //{if (true) return "<dbRelVar>" + "<dbRelName Token=\u005c"" + realName.image + "\u005c" />" + "<dbRelAliasName Token=\u005c"" + aliasName.image + "\u005c" /> </dbRelVar>" + subVal;}
    //throw new Error("Missing return statement in function");
  }
      return null;
  }
/*

next is the where clause. It will have several recursion next in this method.
First we call Expression and assign false to represent that this is the first time we call it, So it must add <BooleanExp><\BooleanExp> out of the where clause abstract syntex tree

*/
  static final public String WhereClause()// throws ParseException {
  {try{String where = "";
    jj_consume_token(WHERE);
    where = Expression(false);
   // {if (true) return "<dbWhereClause>" + where + "</dbWhereClause>";}
    //throw new Error("Missing return statement in function");
  }catch(Exception e){}return null;
}

/*

this method will find all the boolean factors and add BooleanExp in the case we have more than two boolean factors or has parenthesis in some of the boolean factors.

*/
  static final public String Expression(boolean hasFather) throws ParseException {
  String exp1 = "";
  String exp2 = "";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPEN_PAR:
      jj_consume_token(OPEN_PAR);
      exp1 = Expression(true);
      jj_consume_token(CLOSE_PAR);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_3;
        }
        jj_consume_token(AND);
        exp2 = Expression(true);
      }
    /* if hasFather == true means we have the <BooleanExp></BooleanExp> out of this time's call.
    	then we check if exp2 is empty. if exp2 is empty after the parsing. This means this time is the final BooleanFactor in this BooleanExpression and we don't want to have a single BooleanFactor in the BooleanExp, so we will not add "<BooleanExp>"..."</BooleanExp>" out of it.
    */
    if (hasFather == true && exp2.equals(""))
    {
      {if (true) return exp1;}
    }
    /* if it has no father parenthesis out of it or exp2 not empty, we need to add the BooleanExp out of exp1 + exp2*/
    {if (true) return "<BooleanExp>" + exp1 + exp2 + "</BooleanExp>";}
      break;
    case QUO:
    case DIGITS:
    case NAME:
      exp1 = Factor();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_4;
        }
        jj_consume_token(AND);
        exp2 = Expression(true);
      }
    /*the next check has the same function as the previous checking*/
    if (hasFather == true && exp2.equals(""))
    {
      {if (true) return exp1;}
    }
    else
    {
      {if (true) return "<BooleanExp>" + exp1 + exp2 + "</BooleanExp>";}
    }
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/*

this method will parse the Boolean factor. It can be three situation.
1. it is a table.Attribute. such as "Emp.Name = Dep.MName"
2. it is a string literal. such as "Emp.Name = "james""
3. it is a integer literal. such as "Emp.Salary = 7000"
So we can find all three situation has a left part and and an operation and a right part. 

*/
  static final public String Factor() //throws ParseException {
  {try{String left = "";
  String right = "";
  String operator;
    /*so we parse the left, right and operator one by one*/
      left = BooleanAttr();
    operator = Operator();
    right = BooleanAttr();
 //   {if (true) return "<BooleanFactor>" + left + operator + right + "</BooleanFactor>";}
   // throw new Error("Missing return statement in function");
  }catch(Exception e){}return null;
}

/*

the attribute can have three situation as well.
1. name.name such as "Emp.Name"
2. String Literal such as "James"
3. Integer Literal such as 7000

so this method will check them and return the corresponding attribute

*/
  static final public String BooleanAttr() throws ParseException {
  Token rel;
  Token attr;
  String attrName = "";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIGITS:
      rel = jj_consume_token(DIGITS);
    {if (true) return "<dbConstValue> <INTEGERLITERAL Token=\u005c"" + rel.image + "\u005c"/> </dbConstValue>";}
      break;
    case NAME:
      rel = jj_consume_token(NAME);
      jj_consume_token(DOT);
      attr = jj_consume_token(NAME);
    {if (true) return "<dbAttr>" + "<dbRelVar> <dbRelAliasName Token=\u005c"" + rel.image + "\u005c" /> </dbRelVar>" + "<dbAttrName Token=\u005c"" + attr.image + "\u005c" /> </dbAttr>";}
      break;
    case QUO:
      jj_consume_token(QUO);
      rel = jj_consume_token(NAME);
      jj_consume_token(QUO);
    {if (true) return "<dbConstValue><STRINGLITERAL Token=\u005c"" + rel.image + "\u005c"/> </dbConstValue>";}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/*this method will check the operator and return it as it is. */
  static final public String Operator() //throws ParseException {
  {try{Token operator;
    operator = jj_consume_token(OPERATOR);
    //{if (true) return "<comparisonOp Token=\u005c"" + operator.image + "\u005c" />";}
    //throw new Error("Missing return statement in function");
  }catch(Exception e){}return null;
}

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1000,0x1000,0x100,0x100,0x1a200,0x1a000,};
   }

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      //System.out.println("ERROR: Second call to constructor of static parser.  ");
     // System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      //System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
     // System.out.println("ERROR: Second call to constructor of static parser. ");
    //  System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
     // System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
  //    System.out.println("ERROR: Second call to constructor of static parser. ");
    //  System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      //System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 6; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
