import java.util.*;

class CrowdData {
    String crowdLevel;
    String waitTime;

    CrowdData(String crowdLevel, String waitTime) {
        this.crowdLevel = crowdLevel;
        this.waitTime = waitTime;
    }
}

public class DSA_Project {

    static ArrayList<String> places = new ArrayList<>();
    static HashMap<String, CrowdData> surveyData = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       String[] places = {
                "Taj Mahal",
                "Red Fort",
                "India Gate",
                "Charminar",
                "Gateway of India"
        };

        int choice;

        do {
            System.out.println("\n--- TourEase Menu ---");
            System.out.println("1. View Tourist Places");
            System.out.println("2. Submit Crowd Survey");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    for(String place : places) {
                        if(surveyData.containsKey(place)) {
                            CrowdData data = surveyData.get(place);
                            System.out.println(place + " | Crowd: " + data.crowdLevel + " | Wait: " + data.waitTime);
                        } else {
                            System.out.println(place + " | Crowd: Moderate | Wait: 10 mins");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter location: ");
                    String location = sc.nextLine();

                    System.out.print("Enter crowd level: ");
                    String crowd = sc.nextLine();

                    System.out.print("Enter wait time: ");
                    String wait = sc.nextLine();

                    surveyData.put(location, new CrowdData(crowd, wait));

                    System.out.println("Survey submitted!");
                    break;

            }

        } while(choice != 3);

        sc.close();
    }
}