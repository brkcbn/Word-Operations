import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Words 
{
	public static void main( String[] args ) throws FileNotFoundException
    {
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Please enter text file name : ");
	        
	    String file = scan.nextLine();
	        
	    BufferedReader buffReader = new BufferedReader(new FileReader(file));
	        
	    Scanner textFile = new Scanner(buffReader);    	
    	
    	System.out.println("[1] Show How Many Words");
    	System.out.println("[2] Show Distinct Words");
    	
    	int option = scan.nextInt();
    	
    	switch (option) 
    	{
    	
		case 1 :
			
			HashSet<String> set = new HashSet<>();       
	        
	        while (textFile.hasNext()) 
	        {
				set.add(textFile.next().toLowerCase());
			}
	    
	        System.out.println("There are " + set.size() + " words."); 
	        
	        break;
			
		case 2 :
			
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        
	        int counter ;
	        
	        while (textFile.hasNext()) 
	        {
				String words = textFile.next();
				
				words = words.trim().toLowerCase();
				
				if(map.containsKey(words))
				{
					counter = map.get(words) + 1;
					
					map.put(words, counter);
					
				}
				
				else
				{
					map.put(words, 1);
				}
				
			}
	        
	        for(Map.Entry<String,Integer> entry : map.entrySet())
	        {
	        	System.out.println(entry);
	        }
	        
	        break;

		default:
			
			System.out.println("Unexpected Entry");
			
			break;
		}          
    }  

}
