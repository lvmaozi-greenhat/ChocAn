import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class memberData extends Data{
    public memberData(){
        super();
    }
    public memberData(Scanner fileInput){
       super(fileInput);
    }
    public void printAll(){
        super.printAll();
/*
        if(services.isEmpty()==false) {
            System.out.println("     |Services information|");
            for (Service service : services) {
                service.printPart();
            }
        }
        else{
            System.out.println("No services information");
        }
        System.out.println("********** I am the line *****************");
        System.out.println();

 */
    }

    public void writeReport() {
        //write a member report to reports/memberReport.txt
        BufferedWriter bw;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int totalServices = 0;
        double totalFee = 0;

        for(Service serviceInMember : services){
                totalFee += serviceInMember.fee;
                totalServices++;
        }

        try {
            bw = new BufferedWriter(new FileWriter("reports/memberReport.txt", true));
            bw.append(name);
            bw.append("\n");
            bw.append(Integer.toString(number));
            bw.append("\n");
            bw.append(address);
            bw.append("\n");
            bw.append(city);
            bw.append("\n");
            bw.append(state);
            bw.append("\n");
            bw.append("\n");
            bw.append("Total fee due: ");
            bw.append(Double.toString(totalFee));
            bw.append("\n");
            bw.append("Total number of services provided: ");
            bw.append(Integer.toString(totalServices));


            bw.close();
        } catch (Exception x) {
            System.out.println("File writing error.");
        }
    }
}
