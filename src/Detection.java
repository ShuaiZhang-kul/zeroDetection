import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Detection {
    public static void main(String[] args) throws IOException {
        System.out.println("Please type in your file path and press enter：");

        Scanner in = new Scanner(System.in);
        String filePath=in.next();

        File file = new File(filePath);//文件路径
        FileReader fileReader = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(fileReader);
        String txt = "initial";
        int lines = 0;
        Boolean zeroFlag=false;
        System.out.println("Starting to read the file");
        System.out.println("---------------------------------------");

        while (txt != null) {
            lines++;
            //new line scanned will start here
            txt = reader.readLine();
            //avoid null file
            if (txt==null){ break;}
            //split this row into multiple columns
            List<String> columns = Arrays.asList(txt.split(" "));
            int length =columns.size();
            //here zero value detected therefore set the flag to find the timestep next
            if (columns.lastIndexOf("0")== columns.size()-1&&columns.size()!=0){
                    System.out.println("there is an zero at line "+lines+", please check");
                    zeroFlag=true;
//                    System.exit(0);
                }
            //here use the flag to detect the time step by using the keyword of "Flow"
            if (zeroFlag==true && columns.contains("Flow")){
                System.out.println("The time step is "+columns.get(columns.size()-1));
                zeroFlag=false;
            }

        }

        System.out.println("---------------------------------------");
        System.out.println("Reading file finished");
        reader.close();
        fileReader.close();
    }
}
