public class Main {

    public static void main(String[] args) {
        dataController data = new dataController();

        Interface mainInput = new Interface(data);

        mainInput.start();
        //data.printMembers();
        //data.printServices();
        //data.printProviders();
        //String memberFile="data/member.txt";
        //String providerFile="data/provider.txt";
        //      memberData m=new memberData();
        //data.writeInfor(m,memberFile);
        //data.writeInfor(m,providerFile);
        //       data.writeService(new Service(),"data/service.txt");

    }
}
