public static void main(String[] args) {
   Map<string, string> map = new HashMap<string, string>();
   map.put("key1", "value1"); 
   map.put("key2", "value2"); 
   map.put("key3", "value3"); 
   map.put("key4", "value4"); 
  
    // 1. keySet
    for( String key : map.keySet() ){ 
    System.out.println( "key : " + key + ", value : " + map.get(key)) );
    } 
   
   // 2. entrySet
   for( Map.Entry<string, string> elem : map.entrySet() ){
    System.out.println( "key : " + elem.getKey() + ", value : " + elem.getValue()) ); } 
    
  
    
    // 3 : Iterator를 이용한 방법
    Iterator<string> keys = map.keySet().iterator(); 
      while( keys.hasNext() ){ 
        String key = keys.next(); 
        System.out.println( "key : " + key + ", value : " + map.get(key)) ); 
      }
    }

