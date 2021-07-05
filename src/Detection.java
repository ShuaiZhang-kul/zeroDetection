import java.io.*;

public class Detection {
    public static void main(String[] args) throws IOException {
        long timeStart = System.currentTimeMillis();
        File file = new File("C:\\Users\\shuai\\Desktop\\test.txt");//文件路径
        FileReader fileReader = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(fileReader);
        int number = 9999999;//设置指定行数
        String txt = "initial";
        int lines = 0;
        System.out.println("Starting to read the file");
        System.out.println("---------------------------------------");

        while (txt != null) {

            lines++;
            txt = reader.readLine();
            if (txt==null){ break;}
//                System.out.println("第" + reader.getLineNumber() + "的内容是：" + txt + "\n");
                String [] column = txt.split(" ");
                if (column[column.length-1].equals("0")){
                    System.out.println("there is an arrow at line "+lines+", please check");
                    System.exit(0);
                }



        }

        System.out.println("---------------------------------------");
        System.out.println("Reading file finished");
        System.out.println("There is no error");
        reader.close();
        fileReader.close();
    }
}
