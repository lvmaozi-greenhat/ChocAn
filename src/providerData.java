import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class providerData extends Data {
    int n_consultations;
    double week_fees; //maybe unnecessary and should be calculated on the fly instead


    public providerData(){
        super();
        n_consultations=0;
        week_fees=88.88;
    }

    public providerData(Scanner fileInput){
       super(fileInput);
       n_consultations=0;
       week_fees=88.88;
    }

    public void printAll(){
        super.printAll();
        /*
        if(services.isEmpty()==false) {
            System.out.println("     |Services information|");
            for (Service service : services) {
                service.printAll();
            }
        }
        else{
            System.out.println("No services information");
        }

        System.out.println(n_consultations);
        System.out.println(week_fees);
        System.out.println("*******************  I am the line *******************");

         */
    }

    public void CalculateNandFees(){
       if(!services.isEmpty()){
          for(Service service : services){
              this.week_fees+=service.fee;
          }
          this.n_consultations=services.size();
       }
       else{
           this.n_consultations=0;
           this.week_fees=0;
       }
    }

    public void writeReport() {
        //write a report into reports/providerReport.txt
        File file1 = new File("reports/memberReport.txt");
        if(file1.exists())
            file1.delete();

        BufferedWriter bw;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int totalServices = 0;
        double totalFee = 0;

        for(Service serviceInMember : services){
            totalFee += serviceInMember.fee;
            totalServices++;
        }

        try {
            bw = new BufferedWriter(new FileWriter("reports/providerReport.txt", true));
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
            bw.append(Integer.toString(zip_code));
            bw.append("\n");
            bw.append("================");
            bw.append("\n");
            bw.append("List of all services:");
            bw.append("\n");
            for(Service serviceInProvider : services){
                bw.append(sdf.format(serviceInProvider.occurred_date));
                bw.append("\n");
                bw.append(sdf.format(serviceInProvider.received_in_system));
                bw.append("\n");
                bw.append(serviceInProvider.member_name);
                bw.append("\n");
                bw.append(Integer.toString(serviceInProvider.member_id));
                bw.append("\n");
                bw.append(Integer.toString(serviceInProvider.service_id));
                bw.append("\n");
                bw.append("\n");
            }
            bw.append("\n");
            bw.append("================");
            bw.append("\n");
            bw.append("\n");
            bw.append("Total fees: ");
            bw.append(Double.toString(totalFee));
            bw.append("\n");
            bw.append("Total number of services provided: ");
            bw.append(Integer.toString(totalServices));


            bw.close();
            System.out.println("Report written to reports/providerReport.txt");
        } catch (Exception x) {
            System.out.println("File writing error.");
        }
    }

}
