package studys;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

 

public class File_Editor {
	
	public static void filer(FileOutputStream fs) {
		Scanner scan = new Scanner(System.in);
		String data;
		byte[] dt;
		System.out.println("Enter the information If you want to exit , then entry \"exit\"");
		while(true) {
			try {
				data = scan.nextLine();
				if(data.equals("exit")) { break; }
				dt = data.getBytes();
				fs.write(dt);
			} catch (IOException e) {
				System.out.println("File Write Error" + e);
				return;
			}
		}
	}
	
	public static void filer_Writer(FileWriter fs) {
		Scanner scan = new Scanner(System.in);
		String data;
		System.out.println("Enter the information If you want to exit , then entry \"exit\"");
		while(true) {
			try {
				data = scan.nextLine();
				if(data.equals("exit")) { break; }
				fs.write(data);
			} catch (IOException e) {
				System.out.println("File Write Error" + e);
				return;
			}
		}
	}

	public static void main(String[] args) {
		File dir = new File("C:\\");
		String str = "null";
		int selecter = 0;
		int str_data = 0;
		Scanner scan = new Scanner(System.in);
		FileInputStream is = null;
		FileOutputStream os = null;
		InputStreamReader rd = null;
		while(true) {
			System.out.println("_____Text Editor_____");
			System.out.println("_______1 . New_______");
			System.out.println("_______2 . Open______");
			System.out.println("_______3 . Save______");
			System.out.println("_______4 . Save As___");
			System.out.println("_______5 . Page Setup");
			System.out.println("_______6 . Print_____");
			System.out.println("_______7 . Exit______");
			System.out.println("_______8 . Delete____");
			System.out.print("Select : "); selecter = scan.nextInt();
			if (selecter == 7) { break; }
			
			switch (selecter) {
			case 1 : {
				try {
					System.out.print("File Name : "); 
					str = scan.next();
					os = new FileOutputStream("C:\\" + str + ".txt");
					System.out.println("The File has create in c:\\" + str + ".txt");
					filer(os);
				} catch (FileNotFoundException e) {
					System.out.println("File Create Error , please try again");
					continue;
				}
				break;
			}
			case 2 : {
				try {
					System.out.println("Enter the File name : "); 
					str = scan.next();
					File fl = new File("C:\\" + str + ".txt");	
					FileWriter fw = new FileWriter(fl , true);
					System.out.println("File open in C:\\" + str + ".txt");
					filer_Writer(fw);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
			case 3 : {
				if(str.equals("null")) {
					System.out.println("The File is not Open");
				} else {
				try {
					os = new FileOutputStream("C:\\" + str +".txt");
					System.out.println("Save Success");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				}
			}
			break;
			case 4 : {
				System.out.print("Enter the file name : ");
				str = scan.next();
				try {
					os = new FileOutputStream("C:\\" + str +".txt");
					System.out.println("Save Success");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			case 5 : {
				System.out.print("File Setup");
				File [] subfile = dir.listFiles();
				for(int i = 0; i < subfile.length ; i++) {
					File f = subfile[i];
					long t = f.lastModified();
					if(f.isDirectory()) { continue; }
					System.out.print(f.getName());
					System.out.print("\t File Size \t" + f.length() + "\n");
				}
				break;
			}
			case 6 : {
				System.out.print("Enter the File name : ");
				str = scan.next();
				try {
					is = new FileInputStream("C:\\" + str + ".txt");
					rd = new InputStreamReader(is , "UTF-8");
					while((str_data = rd.read()) != -1) {
						System.out.print((char)str_data);
					}
					System.out.println();
				} catch (FileNotFoundException e) {
					System.out.println("File Not existence"); 
				} catch (IOException e) {
					System.out.println("File reading Error");
				}
				break;
			}
			case 7 : {
				break;
			}
			case 8 : {
				System.out.print("Enter the File name : "); 
				str = scan.next();
				File file = new File("C:/" + str + ".txt");
				if( file.exists() ){
		    		if(file.delete()){
		    			System.out.println("File delete success");
		    		}else{
		    			System.out.println("File delete Fail");
		    		}
		    	}else{
		    		System.out.println("The File is not existence");
		    	}
				break;
				}
			default: 
			System.out.println("Please Select in 1 ~ 8 range");
			continue;		
			}

	}
		scan.close();
		
	}

}
