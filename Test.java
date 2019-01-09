import java.util.ArrayList;
import java.util.List;

public class Test {
	private static int NO_OF_CHAR_IN_FROM = 4;
	private static int NO_OF_CHAR_IN_SELECT = 6;
	public static void main(String[] args){
		
		String query1 = "select name from emp were id=8";
		String query2 = "select address from emp were id=8";
		String query3 = "select mobile from emp were id=8";
		
		List<String> queryList = new ArrayList<String>();
		List<String> columns = new ArrayList<String>();;
		queryList.add(query1);
		queryList.add(query2);
		queryList.add(query3);
		
		int index = 0;
		String tableName = null;
		String previousTableName = null;
		String finalQuery = null;
		for (String qry : queryList) {
			
			tableName = getTableName(qry);
			
			
			
			if(index == 0 || previousTableName!=null && tableName.equals(previousTableName)){
				getColumns(qry, columns);
				previousTableName = tableName;
				index++;
			}
			
			if(index == queryList.size()){ //&& !tableName.equals(previousTableName)){
				finalQuery = "select "+getListData(columns, ",")+" from "+tableName;
						System.out.println(finalQuery);
			}
			
		}

		
		
	}

	private static List<String> getColumns(String qry, List<String> columns) {
		String columnName;
		columnName = qry.substring(qry.indexOf("select")+NO_OF_CHAR_IN_SELECT, qry.indexOf("from"));
		columnName = columnName != null ? columnName.trim() : null;
		String[] allColumns = columnName.split(",");
		for(String column : allColumns){
			if(!columns.contains(column))
			columns.add(column.trim());
		}
		return columns;
	}

	private static String getTableName(String qry) {
		String tableName;
		tableName = qry.substring(qry.indexOf("from") + NO_OF_CHAR_IN_FROM);
		tableName = tableName != null ? tableName.trim() : null;
		return tableName;
	}
	
	public static final String getListData(List v, String seperator){
		if (v == null || v.isEmpty()){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (Object object : v) {
			sb.append(object).append(seperator);
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - seperator.length());
	}
	
}

 /*           
    for (int i = 0; i < sn.size(); i++) {
  for (int j = i+1; j < sn.size(); j++) {
    // compare list.get(i) and list.get(j)
      if(sn.get(i)== sn.get(j))
      {
          System.out.println("Equal");
      }
      else
      {
          System.out.println("Not Equal");
      }
  
    for (int ii = 0; ii < fn.size(); ii++) {
  for (int jj = ii+1; jj < fn.size(); jj++) {
    // compare list.get(i) and list.get(j)
      if(fn.get(ii)== fn.get(jj))
      {
          System.out.println("Second Equal");
      }
      else
      {
          System.out.println("Second Not Equal");
      }
  
  for (int iii = 0; iii < wn.size(); iii++) {
  for (int jjj = iii+1; jjj < wn.size(); jjj++) {
    // compare list.get(i) and list.get(j)
      if(wn.get(iii)== wn.get(jjj))
      {
          System.out.println("Tird Equal");
      }
      else
      {
          System.out.println("Tird Not Equal");
      }
  
    
    
    if((sn.get(i)== sn.get(j))&& (fn.get(ii)== fn.get(jj)) && (wn.get(iii)== wn.get(jjj)))
            {
                System.out.println("Same\n\n");
            }
    else
    {
        System.out.println("Not Same\n\n");
    }
  }
    }
  }
   }
  }
                 }
    */