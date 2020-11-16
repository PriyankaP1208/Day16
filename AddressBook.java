package Day16Assgm;

import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class AddressBook
{
	public static void main(String[] args) throws IOException 
	{
		int choice;
	    System.out.println("1.Create Adress Book 2.Open Adress Book 3.Delete 4.Sort by name 5.Sort by Zip code 6.Edit data");
	    System.out.println("Enter your choice:");
	    Scanner s1=new Scanner(System.in);
	    choice=s1.nextInt();
	    switch(choice)
	    {
	    	case 1:
	              	CreateAdressBook();
	                break;
	        case 2:
	        		OpenAddressBook();
	                break;
	        
	        case 3:
	            	DeleteData();
	            	break;
	        case 4:
	            	SortName();
	            	break;
	        case 5:
	            	SortZip();
	            	break;
	        case 6:
	            	EditData();
	            	break;
	        }
	}
	public static void CreateAdressBook() throws IOException
    {
		int no;
        String fileName;
        String First_Name = null,Last_Name = null;
        String Address = null,City = null,State = null;
        String zip = null,phNo= null;
        System.out.println("Enter File Name:");
        Scanner sc=new Scanner(System.in);
        fileName=sc.nextLine();
        File f1=new File(fileName+".csv");
        FileWriter outputfile = new FileWriter(f1);
        BufferedWriter bw=new BufferedWriter(outputfile);
        PrintWriter pw=new PrintWriter(bw);
        System.out.println("Enter No of persons:");
        no=sc.nextInt();
        for(int i=0;i<no;i++)
        {
        	System.out.println("Enter First Name:");
            First_Name=sc.nextLine();
            System.out.println("Enter Last Name:");
            Last_Name=sc.nextLine();
            System.out.println("Enter Address:");
            Address=sc.nextLine();
            System.out.println("Enter City:");
            City=sc.nextLine();
            System.out.println("Enter State:");
            State=sc.nextLine();
            System.out.println("Enter Zip code:");
            zip=sc.nextLine();
            System.out.println("Enter Phonenumber:");
            phNo=sc.nextLine();
            pw.println(First_Name+" "+Last_Name+" "+Address+" "+City+" "+State+" "+zip+" "+phNo+" "); 
            pw.flush();
        }
        pw.close();
    }
    public static void OpenAddressBook()
    {
    	String name=null;
    	File directoryPath = new File("C:/Users/admin/eclipse-workspace/Day16Assgm");
        FilenameFilter textFilefilter = new FilenameFilter()
        {
            public boolean accept(File dir, String name) 
            {
               String lowercaseName = name.toLowerCase();
               if (lowercaseName.endsWith(".csv")) 
               {
                  return true;
               } 
               else 
               {
                  return false;
               }
            }
        };
        File filesList[] = directoryPath.listFiles(textFilefilter);
        System.out.println("List of the text files in the specified directory:");
        for(File file : filesList) 
        {
           System.out.println("File name: "+file.getName());
           System.out.println("File path: "+file.getAbsolutePath());
           System.out.println("Size :"+file.getTotalSpace());
           System.out.println(" ");
        }
        System.out.println("Enter name of file:");
        Scanner sc1=new Scanner(System.in);
        name=sc1.nextLine();
        final String delimiter = ",";
        try 
        {
        	File file = new File(name);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while((line = br.readLine()) != null) 
            {
            	tempArr = line.split(delimiter);
                for(String tempStr : tempArr) 
                {
                	System.out.print(tempStr + " ");
                }
                System.out.println();
            }
            br.close();
        } 
        catch(IOException ioe) 
        {
        	ioe.printStackTrace();
        }
    }
    public static void DeleteData() throws IOException
    {
    	String fname;
    	System.out.println("Enter name of file:");
        Scanner sc1=new Scanner(System.in);
        fname=sc1.nextLine();
    	PrintWriter pw = new PrintWriter(fname);
    	BufferedReader br1 = new BufferedReader(new FileReader(fname)); 
        String line1 = br1.readLine(); 
        while(line1 != null) 
        { 
            boolean flag = false; 
            BufferedReader br2 = new BufferedReader(new FileReader(fname)); 
            String line2 = br2.readLine();
            while(line2 != null) 
            { 
                if(line1.equals(line2)) 
                { 
                    flag = true; 
                    break; 
                } 
                line2 = br2.readLine(); 
            } 
            if(!flag) 
                pw.println(line1); 
            line1 = br1.readLine(); 
        } 
        pw.flush(); 
        br1.close(); 
        pw.close(); 
        System.out.println("Data deleted from file."); 
     }
    public static void SortName() throws IOException
    {
    	String inputFile = "Moni.csv";
		String outputFile = "output.csv";
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String inputLine;
		List<String> lineList = new ArrayList<String>();
		while ((inputLine = bufferedReader.readLine()) != null) 
		{
			lineList.add(inputLine);
		}
		fileReader.close();
		Collections.sort(lineList);
		FileWriter fileWriter = new FileWriter(outputFile);
		PrintWriter out = new PrintWriter(fileWriter);
		for (String outputLine : lineList) 
		{
			out.println(outputLine);
		}
		out.flush();
		out.close();
		fileWriter.close();
	}
    public static void SortZip() throws IOException
    {
    	String inputFile = "Priyanka.csv";
		String outputFile = "outputzip.csv";
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String inputLine;
		List<String> lineList = new ArrayList<String>();
		while ((inputLine = bufferedReader.readLine()) != null) 
		{
			lineList.add(inputLine);
		}
		fileReader.close();
		Collections.sort(lineList);
		FileWriter fileWriter = new FileWriter(outputFile);
		PrintWriter out = new PrintWriter(fileWriter);
		for (String outputLine : lineList) 
		{
			out.println(outputLine);
		}
		out.flush();
		out.close();
		fileWriter.close();
    }
    public static void EditData() throws IOException
    {
    	List<String> lines = new ArrayList<String>(); 
    	String line = null;
    	String name,name1;
    	try 
    	{
    		OpenAddressBook();
    		String fname;
    		System.out.println("Enter name of file:");
    		Scanner sc1=new Scanner(System.in);
    		fname=sc1.nextLine();
            File f1 = new File("C:/Users/admin/eclipse-workspace/Day16Assgm/"+fname);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Enter name of person:");
            Scanner sc=new Scanner(System.in);
            name=sc.nextLine();
            System.out.println("Enter name for replace:");
            name1=sc.nextLine();
            while ((line = br.readLine()) != null) 
            {
                if (line.contains(name))
                    line = line.replace(name, name1);
                lines.add(line);
            }
            fr.close();
            br.close();
            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                 out.write(s);
            out.flush();
            out.close();
        } 
    	catch (Exception ex) 
    	{
            ex.printStackTrace();
        }
    }
}




