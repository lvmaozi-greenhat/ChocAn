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
        //TODO: Implement
    }
}
